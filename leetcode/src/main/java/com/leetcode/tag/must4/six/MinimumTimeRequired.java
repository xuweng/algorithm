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
                // 剪枝
                return;
            }
            if (u == n) {
                // 工作分配完
                ans = max;
                return;
            }
            for (int i = 0; i < k; i++) {
                // 0--0 1--0 2--0 3--0
                // 当前工作u分配给工人i
                sum[i] += jobs[u];

                // 分配下一份工作
                dfs(u + 1, sum, Math.max(sum[i], max));

                sum[i] -= jobs[u];
            }
        }
    }

    class Solution1 {
        int[] jobs;
        int n, k;
        int ans = 0x3f3f3f3f;

        public int minimumTimeRequired(int[] _jobs, int _k) {
            jobs = _jobs;
            n = jobs.length;
            k = _k;
            int[] sum = new int[k];

            dfs(0, 0, sum, 0);

            return ans;
        }

        /**
         * 【补充说明】不理解可以看看下面的「我猜你问」的 Q5 哦 ~
         * <p>
         * u     : 当前处理到那个 job
         * used  : 当前分配给了多少个工人了
         * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
         * max   : 当前的「最大工作时间」
         */
        void dfs(int u, int used, int[] sum, int max) {
            if (max >= ans) {
                return;
            }
            if (u == n) {
                ans = max;
                return;
            }
            // 优先分配给「空闲工人」
            if (used < k) {
                // 工作u分配工人used
                // 直接赋值 不是累加 一份工作分配给一个人
                sum[used] = jobs[u];

                // 0--0 1--1 2--2 3--3
                // 下一份工作u+1分配给工人used+1
                dfs(u + 1, used + 1, sum, Math.max(sum[used], max));

                // 回溯 置0
                sum[used] = 0;
            }
            for (int i = 0; i < used; i++) {
                // 当前工作u分配给工人i
                sum[i] += jobs[u];

                dfs(u + 1, used, sum, Math.max(sum[i], max));

                sum[i] -= jobs[u];
            }
        }
    }
}
