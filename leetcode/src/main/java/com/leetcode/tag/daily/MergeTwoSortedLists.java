package com.leetcode.tag.daily;

/**
 * 先用最简单的方法做出来,保证自己的思路正确
 *
 * <p>思路正确后再优化.思路正确后再优化.思路正确后再优化.思路正确后再优化
 *
 * <p>21. 合并两个有序链表
 */
public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    // 最小值
    ListNode n1 = (l1.val <= l2.val) ? new ListNode(l1.val) : new ListNode(l2.val);
    if (l1.val <= l2.val) {
      // 拿掉l1
      n1.next = mergeTwoLists(l1.next, l2);
    } else {
      // 拿掉l2
      n1.next = mergeTwoLists(l1, l2.next);
    }
    return n1;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
