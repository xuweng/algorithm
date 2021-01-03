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
                // 防止链表有环,创建新结点
                ListNode listNode = new ListNode(p.val);
                if (p.val < x) {
                    if (min == null) {
                        min = listNode;
                    } else {
                        minLast.next = listNode;
                    }
                    minLast = listNode;
                } else {
                    if (max == null) {
                        max = listNode;
                    } else {
                        maxLast.next = listNode;
                    }
                    maxLast = listNode;
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
