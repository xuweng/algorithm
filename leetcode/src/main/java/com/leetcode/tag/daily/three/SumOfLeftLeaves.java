package com.leetcode.tag.daily.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {
    class Solution {
        int result;

        public int sumOfLeftLeaves(TreeNode root) {
            pre(root, false);

            return result;
        }

        public void pre(TreeNode root, boolean isLeft) {
            if (root == null) {
                return;
            }
            if (isLeft && root.left == null && root.right == null) {
                result += root.val;
            }
            pre(root.left, true);
            pre(root.right, false);
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int sumOfLeftLeaves(TreeNode root) {
            return root != null ? dfs(root) : 0;
        }

        public int dfs(TreeNode node) {
            int ans = 0;
            if (node.left != null) {
                ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
            }
            if (node.right != null && !isLeafNode(node.right)) {
                ans += dfs(node.right);
            }
            return ans;
        }

        public boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }

    /**
     * 方法二：广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (isLeafNode(node.left)) {
                        ans += node.left.val;
                    } else {
                        queue.offer(node.left);
                    }
                }
                if (node.right != null && !isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
            return ans;
        }

        public boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
        }
    }

    class Solution3 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return sumOfLeftLeaves(root.left)
                    + sumOfLeftLeaves(root.right)
                    + (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0);
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
