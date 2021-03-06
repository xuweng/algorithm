package com.leetcode.tag.must1.four;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null) {
                if (fast.next == null) {
                    return null;
                } else {
                    fast = fast.next.next;
                }
                slow = slow.next;
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
