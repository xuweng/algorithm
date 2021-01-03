package com.leetcode.tag.daily.six;

/**
 * 86. 分隔链表
 */
public class Partition {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode min = null;
            ListNode minLast = null;
            ListNode max = null;
            ListNode maxLast = null;

            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    if (min == null) {
                        min = p;
                    } else {
                        minLast.next = p;
                    }
                    minLast = p;
                } else {
                    if (max == null) {
                        max = p;
                    } else {
                        maxLast.next = p;
                    }
                    maxLast = p;
                }

                p = p.next;
            }

            if (minLast != null) {
                minLast.next = max;
            }

            return min == null ? max : min;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
