package com.leetcode.tag.hot;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            int length = getLength(headA);
            int length1 = getLength(headB);

            ListNode headA1 = headA;
            ListNode headB1 = headB;
            if (length > length1) {
                int cha = length - length1;
                while (cha > 0 && headA1 != null) {
                    cha--;

                    headA1 = headA1.next;
                }
            } else {
                int cha = length1 - length;
                while (cha > 0 && headB1 != null) {
                    cha--;

                    headB1 = headB1.next;
                }
            }
            while (headA1 != null && headB1 != null && headA1 != headB1) {
                headA1 = headA1.next;
                headB1 = headB1.next;
            }

            return headA1;
        }

        private int getLength(ListNode head) {
            ListNode listNode = head;
            int length = 0;
            while (listNode != null) {
                length++;

                listNode = listNode.next;
            }

            return length;
        }
    }

    /**
     * 图解相交链表
     * <p>
     * 作者：reals
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
