package com.leetcode.tag.dp.one.three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 */
public class FindLongestChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0) {
                return 0;
            }
            Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));

            int[] dp = new int[pairs.length];
            int max = 1;
            for (int i = 0; i < pairs.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    class Solution1 {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0) {
                return 0;
            }
            //这里已经按照第二列的元素从小到大排好序
            Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[1]));

            int result = 0;
            int cur = Integer.MIN_VALUE;
            for (int[] pair : pairs) {
                if (pair[0] > cur) {
                    result++;
                    cur = pair[1];
                }
            }

            return result;
        }
    }

    class Solution2 {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
            //这里已经按照第二列的元素从小到大排好序,
            //在后续可加入的元素中，遍历到的第一个就是后续中第二列列有最小值的
            //每次加入的都是第二列最小值的，画个数轴表示一下应该就懂为什么这样做是最优解的道理了

            int cur = Integer.MIN_VALUE, ans = 0;
            // int left=pairs[0][0],right=pairs[0][1];

            for (int[] pair : pairs) {
                if (cur < pair[0]) {
                    //替换第二列的最大值,始终是链尾数对的第二个数值
                    cur = pair[1];
                    ans++;
                }
            }
            return ans;
        }
    }
}
