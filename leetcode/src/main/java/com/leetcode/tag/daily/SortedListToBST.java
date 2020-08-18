package com.leetcode.tag.daily;

/**
 * 109. 有序链表转换二叉搜索树
 */
public class SortedListToBST {
    /**
     * 将给定的有序链表转换为二叉搜索树的第一步是确定根节点
     * <p>
     * 我们可以找出链表元素的中位数作为根节点的值
     */
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return null;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head, null);
        }

        public TreeNode buildTree(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }
            ListNode mid = getMedian(left, right);
            TreeNode root = new TreeNode(mid.val);
            root.left = buildTree(left, mid);
            root.right = buildTree(mid.next, right);
            return root;
        }

        /**
         * 找出链表中位数节点的方法多种多样，其中较为简单的一种是「快慢指针法」
         *
         * @param left
         * @param right
         * @return
         */
        public ListNode getMedian(ListNode left, ListNode right) {
            ListNode fast = left;
            ListNode slow = left;
            while (fast != right && fast.next != right) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    class Solution2 {
        ListNode globalHead;

        public TreeNode sortedListToBST(ListNode head) {
            globalHead = head;
            int length = getLength(head);
            return buildTree(0, length - 1);
        }

        public int getLength(ListNode head) {
            int ret = 0;
            while (head != null) {
                ++ret;
                head = head.next;
            }
            return ret;
        }

        public TreeNode buildTree(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right + 1) / 2;
            TreeNode root = new TreeNode();
            root.left = buildTree(left, mid - 1);
            root.val = globalHead.val;
            globalHead = globalHead.next;
            root.right = buildTree(mid + 1, right);
            return root;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
