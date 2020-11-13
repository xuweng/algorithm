package com.leetcode.tag.daily.five;

/**
 * 328. 奇偶链表
 */
public class OddEvenList {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return null;
            }
            // 奇数节点
            // head------------old
            // 偶数节点
            // evenHead--------even
            ListNode evenHead = head.next;
            ListNode odd = head, even = evenHead;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
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
