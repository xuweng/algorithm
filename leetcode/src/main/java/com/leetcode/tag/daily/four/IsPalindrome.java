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
                return true;
            }
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return dfs(list, 0, list.size() - 1);
        }

        private boolean dfs(List<Integer> list, int start, int end) {
            if (start > end) {
                return false;
            }
            if (start == end) {
                return true;
            }
            if (start + 1 == end) {
                return Objects.equals(list.get(start), list.get(end));
            }

            return Objects.equals(list.get(start), list.get(end)) && dfs(list, start + 1, end - 1);
        }
    }

    /**
     * 方法一：将值复制到数组中后用双指针法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            List<Integer> vales = new ArrayList<>();

            // 将链表的值复制到数组中
            ListNode currentNode = head;
            while (currentNode != null) {
                vales.add(currentNode.val);
                currentNode = currentNode.next;
            }

            // 使用双指针判断是否回文
            int front = 0;
            int back = vales.size() - 1;
            while (front < back) {
                // 这里判断
                if (!vales.get(front).equals(vales.get(back))) {
                    return false;
                }
                front++;
                back--;
            }
            return true;
        }
    }

    /**
     * 方法二：递归
     * <p>
     * 如果使用递归反向迭代节点，同时使用递归函数外的变量向前迭代，就可以判断链表是否为回文。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        private ListNode frontPointer;

        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode == null) {
                return true;
            }
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            // 回溯
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
            return true;
        }

        public boolean isPalindrome(ListNode head) {
            frontPointer = head;
            return recursivelyCheck(head);
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
