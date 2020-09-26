package com.leetcode.tag.tree.three;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

            fill(res, root, 0, 0, res[0].length);

            return Arrays.stream(res).map(Arrays::asList).collect(Collectors.toList());
        }

        /**
         * @param res
         * @param root
         * @param i    表示当前节点所在层数
         * @param l    表示当前子树在数组 res 中的左边界
         * @param r    表示当前子树在数组 res 中的右边界
         */
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
