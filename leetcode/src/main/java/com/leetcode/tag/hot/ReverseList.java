package com.leetcode.tag.hot;

/**
 * 206. 反转链表
 */
public class ReverseList {
    class Solution {
        ListNode node;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode re = re(head);
            re.next = null;

            return node;
        }

        private ListNode re(ListNode head) {
            if (head.next == null) {
                node = head;
                return head;
            }
            re(head.next).next = head;

            return head;
        }
    }

    class Solution1 {
        ListNode node;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            re(head);

            return node;
        }

        private ListNode re(ListNode head) {
            if (head.next == null) {
                node = head;
                return head;
            }
            re(head.next).next = head;
            head.next = null;

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

    /**
     * 方法一：迭代
     * <p>
     * 三指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

}
