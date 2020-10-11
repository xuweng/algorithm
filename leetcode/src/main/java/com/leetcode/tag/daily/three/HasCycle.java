package com.leetcode.tag.daily.three;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * <p>
 * dp是难点和重点
 */
public class HasCycle {
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head, fast = head;
            while (slow != null) {
                slow = slow.next;
                if (fast != null) {
                    fast = fast.next;
                }
                if (fast != null) {
                    fast = fast.next;
                }
                if (slow != null && slow == fast) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * 方法一：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> seen = new HashSet<>();
            while (head != null) {
                //add方法厉害
                if (!seen.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;
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
