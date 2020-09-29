package com.leetcode.tag.tree.five;

/**
 * 1379. 找出克隆二叉树中的相同节点
 * <p>
 * 太难就放弃.太难就放弃.回溯顺序相反.回溯顺序相反.
 */
public class GetTargetCopy {
    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (original == null) {
                return null;
            }
            if (original == target) {
                return cloned;
            }
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            TreeNode right = getTargetCopy(original.right, cloned.right, target);

            return left == null ? right : left;
        }
    }

    /**
     * 时间快
     */
    class Solution1 {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (cloned == null) {
                return null;
            }
            if (original == target) {
                return cloned;
            }
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }
            return getTargetCopy(original.right, cloned.right, target);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
