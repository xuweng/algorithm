package com.leetcode.tag.must1.one;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.next == null) {
                    return null;
                } else {
                    fast = fast.next.next;
                }
                // 移动fast后比较
                if (slow == fast) {
                    ListNode p = head;
                    while (p != slow) {
                        p = p.next;
                        slow = slow.next;
                    }
                    return p;
                }
                slow = slow.next;
            }

            return null;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
