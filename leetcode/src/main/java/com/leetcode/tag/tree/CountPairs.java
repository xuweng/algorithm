package com.leetcode.tag.tree;

/**
 * 1530. 好叶子节点对的数量
 * <p>
 * 题目看起来很复杂
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 */
public class CountPairs {
    /**
     * 题目看起来很复杂
     */
    class Solution {
        public int countPairs(TreeNode root, int distance) {
            return 0;
        }
    }

    /**
     * 它们之间有且仅有一条最短路径。设两个叶子节点的最近公共祖先为 P，则最短路径的长度，等于 A 到 P 的距离，加上 B 到 P 的距离
     * <p>
     * 我们遍历所有非叶子节点 P，找到以 P 为最近公共祖先的所有叶子节点对，并根据上面的等式，计算每一对之间的距离，
     * <p>
     * 并统计距离不超过distance 的节点对数目，就能够得到最终的答案。
     * <p>
     * 方法一：递归
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/solution/hao-xie-zi-jie-dian-dui-de-shu-liang-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int countPairs(TreeNode root, int distance) {
            Pair pair = dfs(root, distance);
            return pair.count;
        }

        /**
         * 太复杂的代码以后也记不住
         *
         * @param root
         * @param distance
         * @return
         */
        // 对于 dfs(root,distance)，同时返回：
        // 1）每个叶子节点与 root 之间的距离
        // 2) 以 root 为根节点的子树中好叶子节点对的数量
        public Pair dfs(TreeNode root, int distance) {
            int[] depths = new int[distance + 1];
            boolean isLeaf = root.left == null && root.right == null;
            if (isLeaf) {
                depths[0] = 1;
                return new Pair(depths, 0);
            }

            int[] leftDepths = new int[distance + 1];
            int[] rightDepths = new int[distance + 1];
            int leftCount = 0, rightCount = 0;
            if (root.left != null) {
                Pair leftPair = dfs(root.left, distance);
                leftDepths = leftPair.depths;
                leftCount = leftPair.count;
            }
            if (root.right != null) {
                Pair rightPair = dfs(root.right, distance);
                rightDepths = rightPair.depths;
                rightCount = rightPair.count;
            }

            for (int i = 0; i < distance; i++) {
                depths[i + 1] += leftDepths[i];
                depths[i + 1] += rightDepths[i];
            }

            int cnt = 0;
            for (int i = 0; i <= distance; i++) {
                for (int j = 0; j + i + 2 <= distance; j++) {
                    cnt += leftDepths[i] * rightDepths[j];
                }
            }
            return new Pair(depths, cnt + leftCount + rightCount);
        }
    }

    /**
     * 封装数据结构
     */
    class Pair {
        int[] depths;
        int count;

        public Pair(int[] depths, int count) {
            this.depths = depths;
            this.count = count;
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
