package com.leetcode.tag.dfs.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 */
public class Rob {
    class Solution {
        Map<TreeNode, Integer> memo = new HashMap<>();

        public int rob(TreeNode root) {
            if (memo.containsKey(root)) {
                return memo.get(root);
            }
            if (root == null) {
                return 0;
            }
            int left = 0;
            int right = 0;
            int cur = root.val;
            if (root.left != null) {
                left = rob(root.left);
                cur += rob(root.left.left);
                cur += rob(root.left.right);
            }
            if (root.right != null) {
                right = rob(root.right);
                cur += rob(root.right.left);
                cur += rob(root.right.right);
            }
            memo.put(root, Math.max(cur, left + right));

            return memo.get(root);
        }
    }

    /**
     * 每个点有两种状态（选中和不选中）
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/house-robber-iii/solution/da-jia-jie-she-iii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int rob(TreeNode root) {
            int[] rootStatus = dfs(root);
            return Math.max(rootStatus[0], rootStatus[1]);
        }

        public int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            int[] l = dfs(node.left);
            int[] r = dfs(node.right);
            int selected = node.val + l[1] + r[1];
            int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
            return new int[]{selected, notSelected};
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
