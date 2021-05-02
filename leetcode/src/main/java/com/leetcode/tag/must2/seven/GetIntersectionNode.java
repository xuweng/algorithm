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
    /**
     * 设「第一个公共节点」为 node ，「链表 headA」的节点数量为 a ，「链表 headB」的节点数量为 b ，「两链表的公共尾部」的节点数量为 c ，则有：
     * <p>
     * 头节点 headA 到 node 前，共有 a - c 个节点；
     * 头节点 headB 到 node 前，共有 b - c 个节点；
     * <p>
     * 指针 A 先遍历完链表 headA ，再开始遍历链表 headB ，当走到 node 时，共走步数为：
     * a + (b - c)
     * 指针 B 先遍历完链表 headB ，再开始遍历链表 headA ，当走到 node 时，共走步数为：
     * b + (a - c)
     * 如下式所示，此时指针 A , B 重合，并有两种情况：
     * <p>
     * a + (b - c) = b + (a - c)
     */
    public class Solution {
        /**
         * node是第一个公共结点
         * <p>
         * lengthA + [headB,node] = lengthB + [headA,node]
         *
         * @param headA
         * @param headB
         * @return
         */
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
