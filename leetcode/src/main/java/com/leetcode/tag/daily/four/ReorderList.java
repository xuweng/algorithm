package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.LinkedList;
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
            if (start == end) {
                return list.get(start);
            }
            if (start > end) {
                return null;
            }
            list.get(start).next = list.get(end);
            list.get(end).next = dfs(list, start + 1, end - 1);

            return list.get(start);
        }
    }

    /**
     * 方法一：线性表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }
    }

    /**
     * 方法二：寻找链表中点 + 链表逆序 + 合并链表
     * <p>
     * 注意到目标链表即为将原链表的左半端和反转后的右半端合并后的结果。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode mid = middleNode(head);
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = reverseList(l2);
            mergeList(head, l2);
        }

        /**
         * 2个指针
         * <p>
         * 快慢指针
         * <p>
         * 找到原链表的中点（参考「876. 链表的中间结点」）。
         * <p>
         * 我们可以使用快慢指针来 O(N) 地找到链表的中间节点。
         *
         * @param head
         * @return
         */
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        /**
         * 3个指针.
         * <p>
         * pre->cur->next
         * <p>
         * 将原链表的右半端反转（参考「206. 反转链表」）。
         * <p>
         * 我们可以使用迭代法实现链表的反转。
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        /**
         * 将原链表的两端合并。
         * <p>
         * 因为两链表长度相差不超过 1，因此直接合并即可。
         *
         * @param l1
         * @param l2
         */
        public void mergeList(ListNode l1, ListNode l2) {
            ListNode l1Tmp;
            ListNode l2Tmp;
            while (l1 != null && l2 != null) {
                l1Tmp = l1.next;
                l2Tmp = l2.next;

                l1.next = l2;
                l1 = l1Tmp;

                l2.next = l1;
                l2 = l2Tmp;
            }
        }
    }

    /**
     * 双端队列
     */
    class Solution4 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            //双端队列
            LinkedList<ListNode> deque = new LinkedList<>();
            while (head != null) {
                deque.add(head);
                head = head.next;
            }
            //哑结点
            ListNode vh = new ListNode(0);
            while (!deque.isEmpty()) {
                //从头出队
                ListNode prev = deque.pollFirst();
                vh.next = prev;
                //从尾出队
                ListNode next = deque.pollLast();
                prev.next = next;
                if (next == null) {
                    vh = prev;
                    return;
                }
                vh = next;
            }
            vh.next = null;
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
