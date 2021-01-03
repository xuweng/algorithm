package com.leetcode.tag.daily.six;

/**
 * 86. 分隔链表
 */
public class Partition1 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode minHead = new ListNode(0);
            ListNode min = minHead;
            ListNode maxHead = new ListNode(0);
            ListNode max = maxHead;

            while (head != null) {
                if (head.val < x) {
                    min.next = head;
                    min = head;
                } else {
                    max.next = head;
                    max = head;
                }

                head = head.next;
            }

            max.next = null;
            min.next = maxHead.next;

            return minHead.next;
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
