package com.leetcode.tag.tree;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 十分钟看题解
 * <p>
 * 思路
 * <p>
 * 思路
 * <p>
 * 思路
 * <p>
 * 刷题效率。刷题效率。刷题效率。
 */
public class CountCompleteTreeNodes {
    class Solution {
        public int countNodes(TreeNode root) {
            return 0;
        }
    }

    /**
     * 方法一：线性时间
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int countNodes(TreeNode root) {
            return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
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
