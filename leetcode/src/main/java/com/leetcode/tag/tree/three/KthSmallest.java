package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * 反序遍历.反序遍历.反序遍历
 */
public class KthSmallest {
    class Solution {
        int count;
        int result;

        public int kthSmallest(TreeNode root, int k) {
            zhong(root, k);

            return result;
        }

        private void zhong(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            zhong(root.left, k);
            count++;
            if (count == k) {
                result = root.val;
                return;
            }

            zhong(root.right, k);
        }

    }

    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
            if (root == null) {
                return arr;
            }
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
            return arr;
        }

        public int kthSmallest(TreeNode root, int k) {
            ArrayList<Integer> nums = inorder(root, new ArrayList<>());
            //第 k-1 个元素就是第 k 小的元素
            return nums.get(k - 1);
        }
    }

    /**
     * 方法二：迭代
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int kthSmallest(TreeNode root, int k) {
            LinkedList<TreeNode> stack = new LinkedList<>();

            while (true) {
                //left
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                //root
                root = stack.removeLast();
                if (--k == 0) {
                    return root.val;
                }
                //right
                root = root.right;
            }
        }
    }

    class TreeNode {
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
