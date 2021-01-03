package com.leetcode.tag.daily.six;

/**
 * 86. 分隔链表
 */
public class Partition {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return null;
            }
            ListNode min = null;
            ListNode minLast = null;
            ListNode max = null;
            ListNode maxLast = null;

            ListNode p = head;
            while (p != null) {
                // 防止链表有环,创建新结点
                ListNode listNode = new ListNode(p.val);
                if (p.val < x) {
                    if (min == null) {
                        min = listNode;
                    } else {
                        minLast.next = listNode;
                    }
                    minLast = listNode;
                } else {
                    if (max == null) {
                        max = listNode;
                    } else {
                        maxLast.next = listNode;
                    }
                    maxLast = listNode;
                }

                p = p.next;
            }

            if (minLast != null) {
                minLast.next = max;
            }

            return min == null ? max : min;
        }
    }

    /**
     * 方法一：模拟
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode-solution-7ade/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public ListNode partition(ListNode head, int x) {
            // smallHead 和 largeHead 分别为两个链表的哑节点
            ListNode small = new ListNode(0);
            // 不会改变哑结点
            ListNode smallHead = small;
            ListNode large = new ListNode(0);
            ListNode largeHead = large;
            while (head != null) {
                if (head.val < x) {
                    small.next = head;
                    small = head;
                } else {
                    large.next = head;
                    large = head;
                }
                head = head.next;
            }
            //large 的 next 指针置空，这是因为当前节点复用的是原链表的节点，而其 next 指针可能指向一个小于 x 的节点，我们需要切断这个引用
            large.next = null;
            small.next = largeHead.next;
            return smallHead.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
