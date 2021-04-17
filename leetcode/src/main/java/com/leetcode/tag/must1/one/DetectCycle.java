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
                // 移动slow
                slow = slow.next;
                if (fast.next == null) {
                    return null;
                } else {
                    // 移动fast
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

    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            // fast从head开始
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    // 没有环
                    return null;
                }
                if (fast == slow) {
                    // 有环
                    // ptr和slow一起走直到相遇
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
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
