package com.leetcode.tag.divide;

/**
 * 标准分治
 *
 * <p>标准分治
 *
 * <p>标准分治
 *
 * <p>标准分治
 *
 * <p>23. 合并K个排序链表
 */
public class MergeSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }

    return divide(lists, 0, lists.length - 1);
  }

  /**
   * 合并low 到high链表
   *
   * @param listNodes
   * @param low
   * @param high
   * @return
   */
  public ListNode divide(ListNode[] listNodes, int low, int high) {
    if (low >= high) {
      return listNodes[low];
    }
    int mid = low + (high - low) / 2;

    ListNode left = divide(listNodes, low, mid);
    ListNode right = divide(listNodes, mid + 1, high);

    return mergeTwo(left, right);
  }

  public ListNode mergeTwo(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val <= l2.val) {
      l1.next = mergeTwo(l1.next, l2);
    } else {
      l2.next = mergeTwo(l1, l2.next);
    }

    return (l1.val <= l2.val) ? l1 : l2;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
