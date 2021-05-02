package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * <p>
 * left最多 left最多 left最多
 * <p>
 * 滑动窗口 滑动窗口 滑动窗口 滑动窗口
 * <p>
 * left最多 left最多 left最多 left最多 target/2 target/2
 * <p>
 * right right right right
 */
public class GetIntersectionNode {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
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
