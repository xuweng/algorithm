package com.leetcode.tag.tree.three;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {
    class Solution {
        boolean findX;
        boolean findY;
        TreeNode parentX;
        TreeNode parentY;
        int depthX;
        int depthY;

        public boolean isCousins(TreeNode root, int x, int y) {
            isCousins(root, x, y, null, 0);

            return (parentX != parentY) && (depthX == depthY);
        }

        private void isCousins(TreeNode root, int x, int y, TreeNode parent, int depth) {
            if ((root == null) || (findX && findY)) {
                return;
            }
            if (root.val == x) {
                findX = true;
                parentX = parent;
                depthX = depth;
            }
            if (root.val == y) {
                findY = true;
                parentY = parent;
                depthY = depth;
            }
            isCousins(root.left, x, y, root, depth + 1);
            isCousins(root.right, x, y, root, depth + 1);
        }
    }

    /**
     * 标记每一个节点，对于每一个节点 node，它的父亲为 par，深度为 d
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree/solution/er-cha-shu-de-tang-xiong-di-jie-dian-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<Integer, Integer> depth;
        Map<Integer, TreeNode> parent;

        public boolean isCousins(TreeNode root, int x, int y) {
            depth = new HashMap<>();
            parent = new HashMap<>();
            dfs(root, null);
            return (Objects.equals(depth.get(x), depth.get(y)) && parent.get(x) != parent.get(y));
        }

        /**
         * 先序遍历
         *
         * @param node
         * @param par
         */
        public void dfs(TreeNode node, TreeNode par) {
            if (node == null) {
                return;
            }
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);

            dfs(node.left, node);
            dfs(node.right, node);
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
