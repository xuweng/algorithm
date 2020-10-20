package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 */
public class ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode p = head;
            List<ListNode> list = new ArrayList<>();
            while (p != null) {
                list.add(p);
                ListNode pre = p;
                p = p.next;
                pre.next = null;
            }

            dfs(list, 0, list.size() - 1);
        }

        private ListNode dfs(List<ListNode> list, int start, int end) {
            if (start + 1 >= end) {
                return list.get(start);
            }
            list.get(start).next = list.get(end);
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
