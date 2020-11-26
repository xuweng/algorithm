package com.leetcode.tag.daily.five;

import java.util.Arrays;

/**
 * 164. 最大间距
 */
public class MaximumGap {
    /**
     * 方法一：基数排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-gap/solution/zui-da-jian-ju-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 最高位优先(Most Significant Digit first)法，简称MSD法
         * <p>
         * 最低位优先(Least Significant Digit first)法，简称LSD法
         *
         * @param nums
         * @return
         */
        public int maximumGap(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return 0;
            }
            long exp = 1;
            int[] buf = new int[n];
            int maxVal = Arrays.stream(nums).max().getAsInt();

            //基数排序
            while (maxVal >= exp) {
                //0到9的桶子
                int[] cnt = new int[10];
                for (int num : nums) {
                    int digit = (num / (int) exp) % 10;
                    cnt[digit]++;
                }
                for (int i = 1; i < 10; i++) {
                    cnt[i] += cnt[i - 1];
                }
                for (int i = n - 1; i >= 0; i--) {
                    int digit = (nums[i] / (int) exp) % 10;
                    buf[cnt[digit] - 1] = nums[i];
                    cnt[digit]--;
                }
                System.arraycopy(buf, 0, nums, 0, n);
                exp *= 10;
            }

            // 相邻最大距离
            int ret = 0;
            for (int i = 1; i < n; i++) {
                ret = Math.max(ret, nums[i] - nums[i - 1]);
            }
            return ret;
        }
    }

    /**
     * 方法二：基于桶的算法
     * <p>
     * 后一个桶的最小值与前一个桶的最大值之差作为两个桶的间距
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-gap/solution/zui-da-jian-ju-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maximumGap(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return 0;
            }
            int minVal = Arrays.stream(nums).min().getAsInt();
            int maxVal = Arrays.stream(nums).max().getAsInt();
            int d = Math.max(1, (maxVal - minVal) / (n - 1));
            int bucketSize = (maxVal - minVal) / d + 1;

            int[][] bucket = new int[bucketSize][2];
            for (int i = 0; i < bucketSize; ++i) {
                Arrays.fill(bucket[i], -1); // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
            }
            for (int num : nums) {
                int idx = (num - minVal) / d;
                if (bucket[idx][0] == -1) {
                    bucket[idx][0] = bucket[idx][1] = num;
                } else {
                    bucket[idx][0] = Math.min(bucket[idx][0], num);
                    bucket[idx][1] = Math.max(bucket[idx][1], num);
                }
            }

            int ret = 0;
            int prev = -1;
            for (int i = 0; i < bucketSize; i++) {
                if (bucket[i][0] == -1) {
                    continue;
                }
                if (prev != -1) {
                    //后一个桶的最小值与前一个桶的最大值之差作为两个桶的间距
                    ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
                }
                prev = i;
            }
            return ret;
        }
    }

    class Solution2 {
        public int maximumGap(int[] nums) {
            int len = nums.length;
            if (len < 2) {
                return 0;
            }
            Arrays.sort(nums);
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i] - nums[i - 1]);
            }
            return max;
        }
    }

}
