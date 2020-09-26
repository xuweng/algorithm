package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 655. 输出二叉树
 */
public class PrintTree {
    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/print-binary-tree/solution/shu-chu-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<String>> printTree(TreeNode root) {
            int height = getHeight(root);
            String[][] res = new String[height][(1 << height) - 1];
            for (String[] arr : res) {
                Arrays.fill(arr, "");
            }
            List<List<String>> ans = new ArrayList<>();
            fill(res, root, 0, 0, res[0].length);
            for (String[] arr : res) {
                ans.add(Arrays.asList(arr));
            }
            return ans;
        }

        public void fill(String[][] res, TreeNode root, int i, int l, int r) {
            if (root == null) {
                return;
            }
            res[i][(l + r) / 2] = "" + root.val;
            fill(res, root.left, i + 1, l, (l + r) / 2);
            fill(res, root.right, i + 1, (l + r + 1) / 2, r);
        }

        public int getHeight(TreeNode root) {
            return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
