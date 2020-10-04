package com.leetcode.tag.daily.three;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long sum = Long.parseLong(getLong(l1)) + Long.parseLong(getLong(l2));
            String str = String.valueOf(sum);

            ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(str.charAt(str.length() - 1))));
            ListNode tail = listNode;
            for (int i = str.length() - 2; i >= 0; i--) {
                ListNode l = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))));
                tail.next = l;
                tail = l;
            }

            return listNode;
        }

        /**
         * 大数溢出
         *
         * @param listNode
         * @return
         */
        private String getLong(ListNode listNode) {
            return listNode == null ? "" : getLong(listNode.next) + listNode.val;
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
