package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 面试题 02.01. 移除重复节点
 */
public class RemoveDuplicateNodes {
  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode p = head;
    Set<Integer> set = new TreeSet<>();
    while (p != null) {
      set.add(p.val);
      p = p.next;
    }
    List<Integer> list = new ArrayList<>(set);

    ListNode newHead = new ListNode(list.get(0));
    ListNode tail = newHead;
    for (int i = 1; i < list.size(); i++) {
      ListNode listNode = new ListNode(list.get(i));
      tail.next = listNode;
      tail = listNode;
    }
    return newHead;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
