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
            ListNode min = null;
            ListNode minLast = null;
            ListNode max = null;
            ListNode maxLast = null;

            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    if (min == null) {
                        min = p;
                        minLast = p;
                    } else {
                        minLast.next = p;
                    }
                } else {
                    if (max == null) {
                        max = p;
                        maxLast = p;
                    } else {
                        maxLast.next = p;
                    }
                }

                p = p.next;
            }

            if (minLast != null) {
                minLast.next = max;
            }

            return min == null ? max : min;
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
