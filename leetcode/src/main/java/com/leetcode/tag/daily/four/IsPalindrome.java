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

    /**
     * 方法三：快慢指针
     * <p>
     * 整个流程可以分为以下五个步骤：
     * <p>
     * 找到前半部分链表的尾节点。
     * 反转后半部分链表。
     * 判断是否回文。
     * 恢复链表。
     * 返回结果。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        private ListNode reverseList(ListNode head) {
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
         * 可以使用快慢指针在一次遍历中找到：慢指针一次走一步，快指针一次走两步，快慢指针同时出发。
         * <p>
         * 当快指针移动到链表的末尾时，慢指针恰好到链表的中间。通过慢指针将链表分为两部分。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param head
         * @return
         */
        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
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
