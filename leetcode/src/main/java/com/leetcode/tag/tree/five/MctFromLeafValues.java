package com.leetcode.tag.tree.five;

import java.util.Stack;

/**
 * 1130. 叶值的最小代价生成树
 * <p>
 * 最优、最值->dp
 */
public class MctFromLeafValues {
    /**
     * 单调递减栈.栈顶存的一直是当时能找到的最小值
     * <p>
     * 作者：zhanglintc
     * 链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/wei-shi-yao-dan-diao-di-jian-zhan-de-suan-fa-ke-xi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            Stack<Integer> st = new Stack<>();
            st.push(Integer.MAX_VALUE);
            int mct = 0;
            for (int j : arr) {
                while (j >= st.peek()) {
                    mct += st.pop() * Math.min(st.peek(), j);
                }
                st.push(j);
            }
            while (st.size() > 2) {
                mct += st.pop() * st.peek();
            }
            return mct;
        }
    }

    /**
     * 区间DP
     * <p>
     * 作者：ke-xue-jia-12
     * 链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/java-dp-by-ke-xue-jia-12/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            //这道题的核心是:
            //要知道中序遍历就决定了arr数组（0...n-1）里的第k位元素的所有左边元素（包括它自己）都在左子树里，而其右边元素都在右子树里
            //而此时左右两边子树分别选出最大值的乘积就是此时的根，也就是题目中说的非叶节点
            //所以我们可以假定从i到j位，最小和可能是：此刻k位左右两边元素中最大值的乘积 + 子问题k左边(i,k)的最小值 + 子问题k位右边(k+1,j)的最小值
            //即：dp[i][j]=min(dp[i][j], dp[i][k] + dp[k+1][j] + max[i][k]*max[k+1][j])
            //这道题跟leetcode1039一个套路
            //求arr从i到j之间的元素最大值, 保存在max[i][j]中
            //这道题i和j是可以相等的
            int[][] max = new int[n][n];
            for (int j = 0; j < n; j++) {
                int maxValue = arr[j];
                for (int i = j; i >= 0; i--) {
                    maxValue = Math.max(maxValue, arr[i]);
                    max[i][j] = maxValue;
                }
            }
            int[][] dp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = j; i >= 0; i--) {
                    //k是i到j之间的中间某个值,i<=k<j
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k + 1 <= j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                        dp[i][j] = min;
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

}
