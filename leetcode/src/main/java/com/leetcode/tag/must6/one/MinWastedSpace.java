package com.leetcode.tag.must6.one;

import java.util.Arrays;

/**
 * 5779. 装包裹的最小浪费空间
 */
public class MinWastedSpace {
    /**
     * 前缀和 + 二分
     */
    class Solution {
        public int minWastedSpace(int[] packages, int[][] boxes) {
            int mod = (int) (1e9 + 7);
            int n = packages.length;
            long ans = Long.MAX_VALUE;
            // 排序包裹以便可以二分查找
            Arrays.sort(packages);
            // 前缀和用来后面 可以O(1)时间计算浪费空间
            long[] preSum = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
                preSum[i] = preSum[i - 1] + packages[i - 1];
            }
            for (int[] box : boxes) {
                Arrays.sort(box);
                // 当前供应商的浪费空间
                long cur = 0;
                // 上一个盒子可以装下的盒子下标
                int pre = 0;
                for (int v : box) {
                    // 对于每个盒子找到最后一个可以装下的包裹下标
                    int index = bsearch(packages, v);
                    // index为-1说明盒子装不下任意一个包裹 此时continue
                    // index不为-1 累加浪费空间
                    if (index != -1) {
                        // 例如 packages=[2,3,5,6] boxes=[1,5,6]
                        // 当 v 遍历到 5 index为2 pre为0 需要计算的是 (5-2)+(5-3)+(5-5) 即5*3-(2+3+5)
                        // 其中2+3+5就可以利用前缀和信息计算 即 preSum[index+1]-preSum[pre]
                        // 下面cur累加公式到这里就解释清楚了
                        // (index - pre + 1) * v 可能溢出 一定要先转long
                        // 另外注意不可以在这里取余
                        cur += (index - pre + 1) * (long) v - (preSum[index + 1] - preSum[pre]);
                        // pre更新为index+1 注意不是index 否则会重复计算index处的值
                        pre = index + 1;
                    }
                }
                // pre到这里只有为n时 才说明装下了所有包裹 才更新ans
                if (pre == n) {
                    ans = Math.min(ans, cur);
                }
            }
            return ans == Long.MAX_VALUE ? -1 : (int) (ans % mod);
        }

        // 查找数组中最后一个小于等于value的元素 并返回其下标
        public int bsearch(int[] a, int value) {
            int low = 0;
            int high = a.length - 1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (a[mid] > value) {
                    high = mid - 1;
                } else {
                    if (mid == high || (a[mid + 1] > value)) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
