package com.leetcode.tag.daily;

import java.util.HashMap;

/**
 * 好多细节处理
 *
 * <p>头结点和尾结点
 *
 * <p>146. LRU缓存机制
 */
public class LRUCache {
  HashMap<Integer, Node> map;
  int capacity;
  Node head;
  Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }
    if (node == head) {
      return node.value;
    }
    delete(node);

    head.next = node;
    node.pre = head;
    node.next = null;

    head = node;

    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == map.size()) {
      Node node = map.get(key);
      if (node != null) {
        if (node == head) {
          node.value = value;
          return;
        }
        delete(node);
        map.remove(key);
        node = null;
      } else {
        map.remove(tail.key);
        delete(tail);
      }
    }
    if (head == null) {
      head = new Node(key, value, null, null);
      tail = head;
    } else {
      Node node = new Node(key, value, head, null);
      head.next = node;
      head = node;
    }

    map.put(key, head);
  }

  public void delete(Node node) {
    if (node.next != null) {
      node.next.pre = node.pre;
    }
    if (node.pre != null) {
      node.pre.next = node.next;
    }
    if (node == tail) {
      tail = tail.next;
    }
  }

  class Node {
    int key;
    int value;
    Node pre;
    Node next;

    Node(int key, int value, Node pre, Node next) {
      this.key = key;
      this.value = value;
      this.pre = pre;
      this.next = next;
    }
  }
}
