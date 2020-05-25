package com.leetcode.tag.daily;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
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
    if (node == tail) {
      tail = tail.next;
    }
    if (node.next != null) {
      node.next.pre = node.pre;
    }
    if (node.pre != null) {
      node.pre.next = node.next;
    }

    head.next = node;
    node.pre = head;

    head = node;

    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == map.size()) {
      map.remove(tail.key);
      tail = tail.next;
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
