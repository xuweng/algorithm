package com.leetcode.tag.must6.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 */
public class ReorderList {
    /**
     * 方法一：线性表
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                // 05 14
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                // 52
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }
    }

    class Solution1 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            // 找到原链表的中点
            ListNode mid = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            // 将原链表的右半端反转
            l2 = reverseList(l2);
            // 将原链表的两端合并
            mergeList(l1, l2);
        }

        /**
         * 找到原链表的中点
         *
         * @param head
         * @return
         */
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        /**
         * 将原链表的右半端反转
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        /**
         * 将原链表的两端合并
         *
         * @param l1
         * @param l2
         */
        public void mergeList(ListNode l1, ListNode l2) {
            ListNode l1_tmp;
            ListNode l2_tmp;
            while (l1 != null && l2 != null) {
                l1_tmp = l1.next;
                l2_tmp = l2.next;

                l1.next = l2;
                l1 = l1_tmp;

                l2.next = l1;
                l2 = l2_tmp;
            }
        }
    }

    class Solution2 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode cur = head;
            List<ListNode> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur);
                ListNode pre = cur;
                cur = cur.next;
                // 断开链表 结点独立
                pre.next = null;
            }

            dfs(list, 0, list.size() - 1);
        }

        private ListNode dfs(List<ListNode> list, int start, int end) {
            if (start == end) {
                // 只有一个
                return list.get(start);
            }
            if (start > end) {
                // 越界
                return null;
            }
            // 第一个连接最后一个
            list.get(start).next = list.get(end);
            // 最后一个 递归
            list.get(end).next = dfs(list, start + 1, end - 1);

            return list.get(start);
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
