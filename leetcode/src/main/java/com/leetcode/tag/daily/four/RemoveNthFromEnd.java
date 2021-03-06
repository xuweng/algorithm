package com.leetcode.tag.daily.four;

import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 方法二：栈
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //学习哑结点
            ListNode dummy = new ListNode(0, head);
            //栈
            Deque<ListNode> stack = new LinkedList<>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; ++i) {
                stack.pop();
            }
            ListNode prev = stack.peek();
            prev.next = prev.next.next;
            return dummy.next;
        }
    }

    /**
     * 快慢指针
     * <p>
     * 双指针
     * <p>
     * 方法三：一次遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            //当 first 遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点
            ListNode second = dummy;
            for (int i = 0; i < n; ++i) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            //当 first 遍历到链表的末尾时，second 的下一个节点就是我们需要删除的节点
            second.next = second.next.next;
            return dummy.next;
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
