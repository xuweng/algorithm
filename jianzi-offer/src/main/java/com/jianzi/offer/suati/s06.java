package com.jianzi.offer.suati;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 */
public class s06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = head;
        int length = 0;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
            length++;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
