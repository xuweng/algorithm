package com.leetcode.tag.daily.three;

/**
 * 141. 环形链表
 * <p>
 * dp是难点和重点
 */
public class HasCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head, fast = head;
            while (slow != null) {
                slow = slow.next;
                if (fast != null && fast.next != null) {
                    fast = fast.next.next;
                }
                if (slow == fast) {
                    return true;
                }
            }

            return false;
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
