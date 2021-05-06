package com.leetcode.tag.must3;

/**
 * 23. 合并K个升序链表
 */
public class MergeKLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int left, int right) {
            if (left >= right) {
                return lists[left];
            }
            int mid = left + (right - left) / 2;

            return merge(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode ya = new ListNode(-1);
            ListNode cur = ya;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }

            return ya.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
