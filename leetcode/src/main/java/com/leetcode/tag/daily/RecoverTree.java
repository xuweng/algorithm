package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 */
public class RecoverTree {
    /**
     * 想到中序遍历
     */
    class Solution {
        public void recoverTree(TreeNode root) {

        }
    }

    /**
     * 方法一：显式中序遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/hui-fu-er-cha-sou-suo-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 复杂算法拆分成多个函数
         *
         * @param root
         */
        public void recoverTree(TreeNode root) {
            //中序遍历结果
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);
            int[] swapped = findTwoSwapped(nums);
            recover(root, 2, swapped[0], swapped[1]);
        }

        /**
         * 中序遍历
         *
         * @param root
         * @param nums
         */
        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        /**
         * 找到两个没有排序的数字
         *
         * @param nums
         * @return
         */
        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int x = -1, y = -1;
            for (int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) >= nums.get(i)) {
                    continue;
                }
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
            return new int[]{x, y};
        }

        /**
         * 先序遍历来交换两个数字
         *
         * @param root
         * @param count
         * @param x
         * @param y
         */
        public void recover(TreeNode root, int count, int x, int y) {
            if (root == null) {
                return;
            }
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
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
