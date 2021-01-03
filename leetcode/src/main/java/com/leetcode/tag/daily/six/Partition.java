package com.leetcode.tag.daily.six;

/**
 * 86. 分隔链表
 */
public class Partition {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode min = new ListNode(0);
            ListNode max = new ListNode(0);

            ListNode p = head;
            ListNode last = null;
            while (p != null) {
                if (p.val < x) {
                    min.next = p;
                    last = p;
                } else {
                    max.next = p;
                }

                p = p.next;
            }

            if (last != null) {
                last.next = max.next;
            }

            return min.next;
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
