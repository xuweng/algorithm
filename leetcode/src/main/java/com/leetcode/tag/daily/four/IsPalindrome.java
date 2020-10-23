package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 234. 回文链表
 */
public class IsPalindrome {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return dfs(list, 0, list.size() - 1);
        }

        private boolean dfs(List<Integer> list, int start, int end) {
            if (start == end) {
                return true;
            }
            if (start > end) {
                return false;
            }
            return Objects.equals(list.get(start), list.get(end)) && dfs(list, start + 1, end - 1);
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
