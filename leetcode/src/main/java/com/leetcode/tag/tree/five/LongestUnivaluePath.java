package com.leetcode.tag.tree.five;

/**
 * 687. 最长同值路径
 * <p>
 * 十分钟看答案.十分钟看答案.
 */
public class LongestUnivaluePath {
    /**
     * 脑里执行一下示例.
     * <p>
     * 算法错误.
     */
    class Solution {
        int result;
        int count;

        public int longestUnivaluePath(TreeNode root) {
            post(root, Integer.MIN_VALUE);

            return result;
        }

        private void post(TreeNode root, int parent) {
            if (root == null) {
                return;
            }
            post(root.left, root.val);
            post(root.right, root.val);
            if (parent == root.val) {
                count++;
            } else {
                count = 0;
            }
            result = Math.max(result, count);
        }
    }

    /**
     * 后序遍历.类似之前的.
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-univalue-path/solution/zui-chang-tong-zhi-lu-jing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int ans;

        public int longestUnivaluePath(TreeNode root) {
            ans = 0;
            arrowLength(root);
            return ans;
        }

        public int arrowLength(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = arrowLength(node.left);
            int right = arrowLength(node.right);
            int arrowLeft = 0, arrowRight = 0;
            //这个厉害.这样可以区分left和right.
            if (node.left != null && node.left.val == node.val) {
                arrowLeft = left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                arrowRight = right + 1;
            }
            //答案是这个
            ans = Math.max(ans, arrowLeft + arrowRight);
            //返回子树最大
            return Math.max(arrowLeft, arrowRight);
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
