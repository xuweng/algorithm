package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 */
public class RemoveDuplicateNodes {
  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode p = head;
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    while (p != null) {
      if (set.add(p.val)) {
        list.add(p.val);
      }
      p = p.next;
    }

    ListNode newHead = new ListNode(list.get(0));
    ListNode tail = newHead;
    for (int i = 1; i < list.size(); i++) {
      ListNode listNode = new ListNode(list.get(i));
      tail.next = listNode;
      tail = listNode;
    }
    return newHead;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci/solution/yi-chu-zhong-fu-jie-dian-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
      if (head == null) {
        return head;
      }
      Set<Integer> occurred = new HashSet<>();
      occurred.add(head.val);
      ListNode pos = head;
      // 枚举前驱节点
      while (pos.next != null) {
        // 当前待删除节点
        ListNode next = pos.next;
        if (occurred.add(next.val)) {
          pos = pos.next;
        } else {
          // 删除
          pos.next = pos.next.next;
        }
      }
      pos.next = null;
      return head;
    }
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
