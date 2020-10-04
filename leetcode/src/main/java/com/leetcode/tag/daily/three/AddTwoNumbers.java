package com.leetcode.tag.daily.three;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //Line 13: java.lang.NumberFormatException: For input string: "1000000000000000000000000000001"
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

    /**
     * 方法一：模拟
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null, tail = null;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                int sum = n1 + n2 + carry;
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
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
