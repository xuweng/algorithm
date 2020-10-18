package com.leetcode.tag.daily.four;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode p1 = head, p2 = head, p3 = head;
            for (int i = 1; i < n && p1 != null; i++) {
                p1 = p1.next;
            }

            while (p1 != null && p1.next != null) {
                p3 = p2;
                p2 = p2.next;
                p1 = p1.next;
            }
            //删掉第一个结点
            if (p3 == head && p2 == p3) {
                return head.next;
            }
            p3.next = p3.next.next;
            return head;
        }
    }

    /**
     * 方法一：计算链表长度
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //添加一个哑节点（dummy node），它的 next 指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。
            ListNode dummy = new ListNode(0, head);
            int length = getLength(head);
            ListNode cur = dummy;
            for (int i = 1; i < length - n + 1; ++i) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return dummy.next;
        }

        public int getLength(ListNode head) {
            int length = 0;
            while (head != null) {
                ++length;
                head = head.next;
            }
            return length;
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
