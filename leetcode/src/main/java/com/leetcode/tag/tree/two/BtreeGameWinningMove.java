package com.leetcode.tag.tree.two;

/**
 * 1145. 二叉树着色游戏
 */
public class BtreeGameWinningMove {
    class Solution {
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            return true;
        }
    }

    /**
     * 巧妙利用左右节点数量
     * <p>
     * 如何确定蓝色是否有必胜策略，就可以转换为，被红色点切割的三个连通分量中，是否存在一个连通分量，大小大于所有结点数目的一半
     *
     * <p>
     * 作者：huangyt
     * 链接：https://leetcode-cn.com/problems/binary-tree-coloring-game/solution/qiao-miao-li-yong-zuo-you-jie-dian-shu-liang-jian-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        private int left;

        private int right;

        private int num;

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            num = x;

            dfs(root);

            int half = n / 2;
            return left > half || right > half || (left + right) < half;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftNum = 0;
            int rightNum = 0;
            if (node.left != null) {
                leftNum = dfs(node.left);
            }
            if (node.right != null) {
                rightNum = dfs(node.right);
            }
            if (node.val == num) {
                left = leftNum;
                right = rightNum;
            }
            return leftNum + rightNum + 1;
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
