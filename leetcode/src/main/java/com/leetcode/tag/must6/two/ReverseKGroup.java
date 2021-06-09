package com.leetcode.tag.must6.two;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 快慢指针 3指针
 * <p>
 * 快慢指针 3指针
 * <p>
 * 快慢指针 3指针
 */
public class ReverseKGroup {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/k-ge-yi-zu-fan-zhuan-lian-biao-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode hair = new ListNode(0);
            hair.next = head;
            ListNode pre = hair;

            while (head != null) {
                ListNode tail = pre;
                // 查看剩余部分长度是否大于等于 k
                for (int i = 0; i < k; ++i) {
                    tail = tail.next;
                    if (tail == null) {
                        return hair.next;
                    }
                }
                ListNode nex = tail.next;
                ListNode[] reverse = myReverse(head, tail);
                head = reverse[0];
                tail = reverse[1];
                // 把子链表重新接回原链表
                pre.next = head;
                tail.next = nex;
                pre = tail;
                head = tail.next;
            }

            return hair.next;
        }

        /**
         * 翻转一个分组内的子链表
         *
         * @param head
         * @param tail
         * @return
         */
        public ListNode[] myReverse(ListNode head, ListNode tail) {
            ListNode prev = tail.next;
            ListNode p = head;
            while (prev != tail) {
                ListNode nex = p.next;
                p.next = prev;
                prev = p;
                p = nex;
            }
            return new ListNode[]{tail, head};
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
