package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 */
public class RecoverTree {
    /**
     * 以为简单.算法错误.
     */
    class Solution {
        List<TreeNode> list = new ArrayList<>();

        public void recoverTree(TreeNode root) {
            inorder(root);

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).val > list.get(i + 1).val) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(i + 1).val;
                    list.get(i + 1).val = temp;
                    break;
                }
            }
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }

    /**
     * 官方
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/hui-fu-er-cha-sou-suo-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);

            int[] swapped = findTwoSwapped(nums);
            recover(root, 2, swapped[0], swapped[1]);
        }

        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public int[] findTwoSwapped(List<Integer> nums) {
            int x = -1, y = -1;
            for (int i = 0; i < nums.size() - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    y = nums.get(i + 1);
                    if (x == -1) {
                        x = nums.get(i);
                    } else {
                        break;
                    }
                }
            }
            return new int[]{x, y};
        }

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
