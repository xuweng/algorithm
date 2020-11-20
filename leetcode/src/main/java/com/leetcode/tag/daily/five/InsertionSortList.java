package com.leetcode.tag.daily.five;

/**
 * 147. 对链表进行插入排序
 */
public class InsertionSortList {
    /**
     * 方法一：从前往后找插入点
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return head;
            }
            //哑节点。插入头结点。
            //引入哑节点是为了便于在 head 节点之前插入节点
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            //链表的已排序部分的最后一个节点
            ListNode lastSorted = head;
            ListNode curr = head.next;
            while (curr != null) {
                if (lastSorted.val <= curr.val) {
                    // 有序
                    lastSorted = lastSorted.next;
                } else {
                    ListNode prev = dummyHead;
                    //从头开始查找prev
                    while (prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    //假设curr插入头结点.curr最小.此时pre没有移动，此时pre就是哑结点.
                    lastSorted.next = curr.next;
                    //插入curr.链表插入.
                    curr.next = prev.next;
                    prev.next = curr;
                }
                curr = lastSorted.next;
            }
            return dummyHead.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
