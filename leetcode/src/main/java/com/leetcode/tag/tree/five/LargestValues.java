package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 515. 在每个树行中找最大值
 */
public class LargestValues {
    class Solution {
        long[] maxLevel;

        public List<Integer> largestValues(TreeNode root) {
            maxLevel = new long[10000];
            Arrays.fill(maxLevel, Long.MIN_VALUE);

            preorder(root, 1);

            return Arrays.stream(maxLevel).filter(i -> i != Long.MIN_VALUE).mapToInt(i -> (int) i).boxed().collect(Collectors.toList());
        }

        private void preorder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            maxLevel[level] = Math.max(root.val, maxLevel[level]);
            preorder(root.left, level + 1);
            preorder(root.right, level + 1);
        }
    }

    /**
     * 简洁代码
     * <p>
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/solution/javadai-ma-bfshe-dfsliang-chong-jie-jue-si-lu-yi-j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class S {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res, 1);
            return res;
        }

        //level表示的是第几层，集合res中的第一个数据表示的是
        // 第一层的最大值，第二个数据表示的是第二层的最大值……
        private void helper(TreeNode root, List<Integer> res, int level) {
            if (root == null) {
                return;
            }
            //如果走到下一层了直接加入到集合中
            if (level == res.size() + 1) {
                //先序遍历.第level层的最左边的结点.
                res.add(root.val);
            } else {
                //注意：我们的level是从1开始的，也就是说root
                // 是第一层，而集合list的下标是从0开始的，
                // 所以这里level要减1。
                // Math.max(res.get(level - 1), root.val)表示的
                // 是遍历到的第level层的root.val值和集合中的第level
                // 个元素的值哪个大，就要哪个。
                res.set(level - 1, Math.max(res.get(level - 1), root.val));
            }
            //下面两行是DFS的核心代码
            helper(root.left, res, level + 1);
            helper(root.right, res, level + 1);
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
