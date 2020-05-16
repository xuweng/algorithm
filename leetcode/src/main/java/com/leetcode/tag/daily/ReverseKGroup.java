package com.leetcode.tag.daily;

/**
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
  /**
   *
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 0) {
      return null;
    }
    ListNode result = head;
    ListNode node = head;
    while (node != null) {
      ListNode tail = node;
      for (int i = 0; i < k - 1 && tail != null; i++) {
        tail = tail.next;
      }
      if (node == head) {
        result = tail;
      }
      if (tail == null) {
        break;
      }
      // 记录next
      ListNode nodeNext = tail.next;
      re(node, tail);
      node = nodeNext;
    }

    return result;
  }

  public ListNode re(ListNode head, ListNode tail) {
    if (head == tail) {
      return head;
    }

    re(head.next, tail).next = head;
    return tail;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
