package com.leetcode.tag.must.four;

/**
 * LCP 34. 二叉树染色
 */
public class MaxValue {
    /**
     * 方法：动态规划
     * <p>
     * 作者：hu-li-hu-wai
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-ran-se-UGC/solution/dp-by-hu-li-hu-wai-rr0c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxValue(TreeNode root, int k) {
            //dp[i] 表示 每个节点的状态，i 表示染了几个节点，i=0 表示没有染色，i>0 表示染色 。
            int[] dp = dynamic(root, k);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= k; i++) {
                //取root的各种染色情况的最大值
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        /**
         * 定义状态转移方程：
         * 当前节点为root，dp逻辑为（详见注释）：
         * <p>
         * root不染色，那么只要返回 dp[0]，其值为左、右子树染色或不染色的最大值之和
         * root染色，那么就分左子树染色 j 个，右子树染色 i - 1 - j 个时，加上 root.val 的和。
         * 注意：j 需要从 0 取到 i - 1，也就是包含 l[0] 和 r[0]。因为 l[0] 也包含左子树染了j个节点的情况，因为左子树的下一层子节点可能染了j个节点。
         * <p>
         * dp[i] = Math.max(dp[i], root.val + l[j] + r[i - 1 - j]);
         * <p>
         * 作者：hu-li-hu-wai
         * 链接：https://leetcode-cn.com/problems/er-cha-shu-ran-se-UGC/solution/dp-by-hu-li-hu-wai-rr0c/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param root
         * @param k
         * @return
         */
        private int[] dynamic(TreeNode root, int k) {
            int[] dp = new int[k + 1];
            //1.初始化：空节点为底，自底向上
            if (root == null) {
                return dp;
            }
            //2.获取左、右子树的状态
            //- 左子树染色状态的dp表
            int[] l = dynamic(root.left, k);
            //- 右子树染色状态的dp表
            int[] r = dynamic(root.right, k);
            //3.更新处理root的 染色/不染色 的情况下的dp表
            //- 不染root
            int ml = Integer.MIN_VALUE, mr = Integer.MIN_VALUE;
            // root不染色，那么只要返回 dp[0]，其值为左、右子树染色或不染色的最大值之和
            for (int i = 0; i <= k; i++) {
                //- 分别取子节点的最大值
                ml = Math.max(ml, l[i]);
                mr = Math.max(mr, r[i]);
            }
            dp[0] = ml + mr;
            //- 染root
            // 左子树染色 j 个，右子树染色 i - 1 - j 个时，加上 root.val 的和
            // j i-j-1 减去root结点
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < i; j++) {
                    //- 还需要染色 i - 1 个点，左子树 j 个，右子树 i-1-j 个
                    dp[i] = Math.max(dp[i], root.val + l[j] + r[i - 1 - j]);
                }
            }
            //4.更新完毕，返回后继续向上动态规划
            return dp;
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
