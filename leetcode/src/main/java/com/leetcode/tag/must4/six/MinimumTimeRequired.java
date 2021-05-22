package com.leetcode.tag.must4.six;

/**
 * 1723. 完成所有工作的最短时间
 */
public class MinimumTimeRequired {
    class Solution {
        int[] jobs;
        int n, k;
        int ans = 0x3f3f3f3f;

        public int minimumTimeRequired(int[] jobs, int k) {
            this.jobs = jobs;
            n = this.jobs.length;
            this.k = k;
            int[] sum = new int[this.k];

            dfs(0, sum, 0);

            return ans;
        }

        /**
         * u   : 当前处理到那个 job
         * sum : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
         * max : 当前的「最大工作时间」
         */
        private void dfs(int u, int[] sum, int max) {
            if (max >= ans) {
                return;
            }
            if (u == n) {
                // 工作分配完
                ans = max;
                return;
            }
            for (int i = 0; i < k; i++) {
                // 当前工作u分配给i
                sum[i] += jobs[u];

                // 分配下一份工作
                dfs(u + 1, sum, Math.max(sum[i], max));

                sum[i] -= jobs[u];
            }
        }
    }
}
