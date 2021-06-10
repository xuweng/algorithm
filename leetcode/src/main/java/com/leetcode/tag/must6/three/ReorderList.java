package com.leetcode.tag.must6.three;

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
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                ListNode pre = node;
                node = node.next;
                pre.next = null;
            }

            dfs(list, 0, list.size() - 1);
        }

        private ListNode dfs(List<ListNode> list, int left, int right) {
            if (left == right) {
                return list.get(left);
            }
            if (left > right) {
                return null;
            }
            list.get(left).next = list.get(right);
            list.get(right).next = dfs(list, left + 1, right - 1);

            return list.get(left);
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
