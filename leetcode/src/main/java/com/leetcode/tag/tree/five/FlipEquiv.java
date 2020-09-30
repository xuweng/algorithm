package com.leetcode.tag.tree.five;

/**
 * 951. 翻转等价二叉树
 * <p>
 * 十分钟看答案.十分钟看答案.不能浪费太多时间.
 * <p>
 * 一开始的思路错误.
 * <p>
 * 101. 对称二叉树的变形
 */
public class FlipEquiv {
    class Solution {
        boolean result = true;

        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            pre(root1, root2);

            return result;
        }

        private void pre(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return;
            }
            if (root1.left != null) {
                if (root2.left == null || root1.left.val != root2.left.val) {
                    TreeNode left = root1.left;
                    root1.left = root1.right;
                    root1.right = left;

                    boolean b = root1.left == null ? root2.left == null : root1.val == root2.val;
                    if (!b) {
                        result = false;
                        return;
                    }
                }
            }
            pre(root1.left, root2.left);
            pre(root1.right, root2.right);
        }
    }

    /**
     * 思路
     * <p>
     * 如果二叉树 root1，root2 根节点值相等，那么只需要检查他们的孩子是不是相等就可以了。
     * <p>
     * 如果 root1 或者 root2 是 null，那么只有在他们都为 null 的情况下这两个二叉树才等价。
     * 如果 root1，root2 的值不相等，那这两个二叉树的一定不等价。
     * 如果以上条件都不满足，也就是当 root1 和 root2 的值相等的情况下，需要继续判断 root1 的孩子节点是不是跟 root2 的孩子节点相等。
     * 因为可以做翻转操作，所以这里有两种情况需要去判断。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/flip-equivalent-binary-trees/solution/fan-zhuan-deng-jie-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == root2) {
                return true;
            }
            if (root1 == null || root2 == null || root1.val != root2.val) {
                return false;
            }

            //厉害.
            //因为可以做翻转操作，所以这里有两种情况需要去判断
            //left-left.right-right.
            //left-right.right-left.
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                    (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
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
