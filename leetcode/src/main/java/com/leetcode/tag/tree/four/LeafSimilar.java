package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeafSimilar {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> root1s = new ArrayList<>();
            List<Integer> root2s = new ArrayList<>();

            pre(root1, root1s);
            pre(root2, root2s);

            if (root1s.size() != root2s.size()) {
                return false;
            }
            for (int i = 0; i < root1s.size(); i++) {
                if (!root1s.get(i).equals(root2s.get(i))) {
                    return false;
                }
            }

            return true;
        }


        private void pre(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                result.add(root.val);
            }
            pre(root.left, result);
            pre(root.right, result);
        }
    }

    /**
     * dfs
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/leaf-similar-trees/solution/xie-zi-xiang-si-de-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaves1 = new ArrayList<>();
            List<Integer> leaves2 = new ArrayList<>();

            dfs(root1, leaves1);
            dfs(root2, leaves2);
            //这个比较厉害
            return leaves1.equals(leaves2);
        }

        public void dfs(TreeNode node, List<Integer> leafValues) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
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
