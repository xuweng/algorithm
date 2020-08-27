package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 */
public class IncreasingBST {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            List<TreeNode> result = new ArrayList<>();

            zhong(root, result);

            for (int i = 0; i < result.size() - 1; i++) {
                TreeNode treeNode = result.get(i);
                treeNode.left = null;
                treeNode.right = result.get(i + 1);
            }
            return result.get(0);
        }

        private void zhong(TreeNode root, List<TreeNode> result) {
            if (root == null) {
                return;
            }
            zhong(root.left, result);
            result.add(root);
            zhong(root.right, result);
        }
    }

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)，其中 N 是树上的节点个数。
     * <p>
     * 空间复杂度：O(N)。
     * <p>
     * 方法一：中序遍历 + 构造新的树
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree/solution/di-zeng-shun-xu-cha-zhao-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            inorder(root, vals);

            TreeNode ans = new TreeNode(0), cur = ans;
            for (int v : vals) {
                cur.right = new TreeNode(v);
                cur = cur.right;
            }
            return ans.right;
        }

        public void inorder(TreeNode node, List<Integer> vals) {
            if (node == null) {
                return;
            }
            inorder(node.left, vals);
            vals.add(node.val);
            inorder(node.right, vals);
        }
    }

    /**
     * 方法二：中序遍历 + 更改树的连接方式
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree/solution/di-zeng-shun-xu-cha-zhao-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        TreeNode cur;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode ans = new TreeNode(0);
            cur = ans;
            inorder(root);
            return ans.right;
        }

        /**
         * 树上进行中序遍历，但会将树中的节点之间重新连接而不使用额外的空间。具体地，
         * <p>
         * 当我们遍历到一个节点时，把它的左孩子设为空，并将其本身作为上一个遍历到的节点的右孩子。
         *
         * @param node
         */
        public void inorder(TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(node.left);
            node.left = null;
            cur.right = node;
            cur = node;
            inorder(node.right);
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
