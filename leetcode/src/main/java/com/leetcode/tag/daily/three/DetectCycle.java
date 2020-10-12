package com.leetcode.tag.daily.three;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * <p>
 * 双指针.
 * <p>
 * dp.dp.
 * <p>
 * bst.中序遍历.pre
 */
public class DetectCycle {
    class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (!set.add(head)) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }
    }

    class Solution1 {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode slow = head, fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    /**
     * 数学推导才是重点
     * <p>
     * 方法二：快慢指针
     * <p>
     * 如果链表中存在环，则 fast 指针最终将再次与 slow 指针在环中相遇。
     * <p>
     * 数学公式
     * <p>
     * a+n(b+c)+b=a+(n+1)b+nca+n(b+c)+b=a+(n+1)b+nc。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            //双指针从同一节点出发
            ListNode slow = head, fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                } else {
                    return null;
                }
                //当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；
                //随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
                if (fast == slow) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;
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
