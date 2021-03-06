package com.leetcode.tag.must7.two;

import java.util.Arrays;

/**
 * 274. H 指数
 */
public class HIndex {
    /**
     * 方法一：排序
     */
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);

            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }

    /**
     * 方法二：计数排序
     */
    class Solution1 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] counter = new int[n + 1];
            for (int citation : citations) {
                if (citation >= n) {
                    counter[n]++;
                } else {
                    counter[citation]++;
                }
            }
            int tot = 0;
            for (int i = n; i >= 0; i--) {
                tot += counter[i];
                if (tot >= i) {
                    return i;
                }
            }
            return 0;
        }
    }

    /**
     * 模拟 + 二分
     * 找到满足条件「引用次数至少为 x 次的 x 篇论文」中的最大 x 值
     * <p>
     * 少于等于 x 的数值必然满足条件；
     * 大于 x 的数值必然不满足。
     */
    class Solution2 {
        public int hIndex(int[] cs) {
            int n = cs.length;
            // [0.n)
            // [0,n-1]
            int l = 0, r = n;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (check(cs, mid)) {
                    // 满足条件
                    // 如果 h 有多种可能的值，h 指数是其中最大的那个
                    // 扩大
                    l = mid;
                } else {
                    // 缩小
                    r = mid - 1;
                }
            }
            return r;
        }

        boolean check(int[] cs, int mid) {
            // 引用次数>mid 的数量
            int ans = 0;
            for (int i : cs) {
                if (i >= mid) {
                    ans++;
                }
            }
            // 引用了至少 mid 次
            return ans >= mid;
        }
    }

    class Solution3 {
        public int hIndex(int[] cs) {
            int n = cs.length;
            // [0.n)
            // [0,n-1]
            int left = 0;
            int right = n - 1;
            // n-1
            // 0 < 0 不能进入循环
            while (left < right) {
                // [0,n-1]
                // left + right + 1  两个选择第二个 防止死循环
                int mid = (left + right + 1) >> 1;
                if (check(cs, mid)) {
                    // 满足条件
                    // 如果 h 有多种可能的值，h 指数是其中最大的那个
                    // 扩大
                    left = mid;
                } else {
                    // 缩小
                    right = mid - 1;
                }
            }
            return left;
        }

        boolean check(int[] cs, int mid) {
            // 引用次数>mid 的数量
            int ans = 0;
            for (int i : cs) {
                if (i >= mid) {
                    ans++;
                }
            }
            // 引用了至少 mid 次
            return ans >= mid;
        }
    }
}
