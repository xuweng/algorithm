package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        map.remove(key);
        delete(node);
        node = null;
      } else {
        map.remove(tail.key);
        node = tail;
        delete(tail);
        node = null;
      }
    }
    insert(key, value);

    map.put(key, head);
  }

  public void insert(int key, int value) {
    if (head == null) {
      head = new Node(key, value, null, null);
      tail = head;
    } else {
      Node node = new Node(key, value, head, null);
      head.next = node;
      head = node;
    }
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

  /**
   * 需要用到一个哈希表和一个双向链表
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
      super(capacity, 0.75F, true);
      this.capacity = capacity;
    }

    public int get(int key) {
      return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
      super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
      return size() > capacity;
    }
  }

  class LRUCache2 {
    class DLinkedNode {
      int key;
      int value;
      DLinkedNode prev;
      DLinkedNode next;

      public DLinkedNode() {
      }

      public DLinkedNode(int _key, int _value) {
        key = _key;
        value = _value;
      }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2(int capacity) {
      this.size = 0;
      this.capacity = capacity;
      // 使用伪头部和伪尾部节点
      // 创建两个
      head = new DLinkedNode();
      tail = new DLinkedNode();
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        return -1;
      }
      // 如果 key 存在，先通过哈希表定位，再移到头部
      moveToHead(node);
      return node.value;
    }

    public void put(int key, int value) {
      DLinkedNode node = cache.get(key);
      if (node == null) {
        // 如果 key 不存在，创建一个新的节点
        DLinkedNode newNode = new DLinkedNode(key, value);
        // 添加进哈希表
        cache.put(key, newNode);
        // 添加至双向链表的头部
        addToHead(newNode);
        ++size;
        if (size > capacity) {
          // 如果超出容量，删除双向链表的尾部节点
          DLinkedNode tail = removeTail();
          // 删除哈希表中对应的项
          cache.remove(tail.key);
          --size;
        }
      } else {
        // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
        node.value = value;
        moveToHead(node);
      }
    }

    private void addToHead(DLinkedNode node) {
      node.prev = head;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
    }

    private void removeNode(DLinkedNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
      removeNode(node);
      addToHead(node);
    }

    private DLinkedNode removeTail() {
      DLinkedNode res = tail.prev;
      removeNode(res);
      return res;
    }
  }
}
