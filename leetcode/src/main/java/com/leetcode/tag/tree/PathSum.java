package com.leetcode.tag.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 04.12. 求和路径
 */
public class PathSum {
    class Solution {
        int result;

        public int pathSum(TreeNode root, int sum) {
            myPathSum(root, sum);

            return result;
        }

        /**
         * 先序遍历
         *
         * @param root
         * @param sum
         */
        public void myPathSum(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            path(root, sum);

            myPathSum(root.left, sum);
            myPathSum(root.right, sum);
        }

        private void path(TreeNode root, int sum) {
            //考虑负数
            if (root == null) {
                return;
            }
            if (root.val == sum) {
                result++;
            }
            path(root.left, sum - root.val);
            path(root.right, sum - root.val);
        }
    }

    /**
     * 前缀和
     * <p>
     * 作者：burning-summer
     * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci/solution/qian-zhui-he-de-ying-yong-di-gui-hui-su-by-shi-huo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int pathSum(TreeNode root, int sum) {
            // key是前缀和, value是大小为key的前缀和出现的次数
            Map<Integer, Integer> prefixSumCount = new HashMap<>(64);
            // 前缀和为0的一条路径
            prefixSumCount.put(0, 1);
            // 前缀和的递归回溯思路
            return recursionPathSum(root, prefixSumCount, sum, 0);
        }

        /**
         * 前缀和的递归回溯思路
         * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
         * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
         * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
         *
         * @param node           树节点
         * @param prefixSumCount 前缀和Map
         * @param target         目标值
         * @param currSum        当前路径和
         * @return 满足题意的解
         */
        private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
            // 1.递归终止条件
            if (node == null) {
                return 0;
            }
            // 2.本层要做的事情
            int res = 0;
            // 当前路径上的和
            currSum += node.val;

            //---核心代码
            // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
            // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
            // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
            res += prefixSumCount.getOrDefault(currSum - target, 0);
            // 更新路径上当前节点前缀和的个数
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
            //---核心代码

            // 3.进入下一层
            res += recursionPathSum(node.left, prefixSumCount, target, currSum);
            res += recursionPathSum(node.right, prefixSumCount, target, currSum);

            // 4.回到本层，恢复状态，去除当前节点的前缀和数量
            prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
            return res;
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
