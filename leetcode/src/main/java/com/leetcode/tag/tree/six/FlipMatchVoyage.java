package com.leetcode.tag.tree.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 */
public class FlipMatchVoyage {
    class Solution {
        int rootIndex;
        boolean flag;
        List<Integer> result = new ArrayList<>();

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            pre(root, voyage);

            return result;
        }

        public void pre(TreeNode root, int[] voyage) {
            if (root == null || flag) {
                return;
            }
            if (root.val != voyage[rootIndex++]) {
                result.clear();
                result.add(-1);
                flag = true;
                return;
            }
            if (root.left != null) {
                if (root.left.val != voyage[rootIndex] && root.right != null) {
                    //注意npe
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;

                    result.add(root.val);
                }

                pre(root.left, voyage);
            }
            if (root.right != null) {
                pre(root.right, voyage);
            }
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/solution/fan-zhuan-er-cha-shu-yi-pi-pei-xian-xu-bian-li-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<Integer> flipped;
        int index;
        int[] voyage;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            flipped = new ArrayList<>();
            index = 0;
            this.voyage = voyage;

            dfs(root);
            if (!flipped.isEmpty() && flipped.get(0) == -1) {
                flipped.clear();
                flipped.add(-1);
            }

            return flipped;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }

            if (index < voyage.length && node.left != null &&
                    node.left.val != voyage[index]) {
                flipped.add(node.val);
                //不用翻转.改变遍历顺序也可以.
                //right-left
                dfs(node.right);
                dfs(node.left);
            } else {
                //left-right
                dfs(node.left);
                dfs(node.right);
            }
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
