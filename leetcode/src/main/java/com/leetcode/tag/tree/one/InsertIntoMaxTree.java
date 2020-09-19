package com.leetcode.tag.tree.one;

/**
 * 998. 最大二叉树 II
 * <p>
 * 不太搞懂题意
 * <p>
 * 搞懂题意。搞懂题意。搞懂题意。搞懂题意。搞懂题意
 */
public class InsertIntoMaxTree {
    class Solution {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            return null;
        }
    }

    /**
     * 作者：hu-li-hu-wai
     * 链接：https://leetcode-cn.com/problems/maximum-binary-tree-ii/solution/shuang-bai-di-gui-by-hu-li-hu-wai/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            //root.val < val
            if (root == null || root.val < val) {
                TreeNode tmp = new TreeNode(val);
                //连接
                tmp.left = root;
                //返回新结点
                return tmp;
            }
            //root.val >= val
            root.right = insertIntoMaxTree(root.right, val);
            return root;
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
