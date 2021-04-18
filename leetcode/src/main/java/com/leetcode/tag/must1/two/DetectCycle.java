package com.leetcode.tag.must1.two;

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
                slow = slow.next;
                if (fast.next == null) {
                    // 没有环
                    return null;
                } else {
                    fast = fast.next.next;
                }
                // 移动后比较
                if (slow == fast) {
                    ListNode p = head;
                    while (p != slow) {
                        p = p.next;
                        slow = slow.next;
                    }

                    return p;
                }
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
