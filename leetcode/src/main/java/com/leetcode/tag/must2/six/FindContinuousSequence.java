package com.leetcode.tag.must2.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class FindContinuousSequence {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> vec = new ArrayList<>();
            // (target - 1) / 2 等效于 target / 2 下取整
            int sum = 0, limit = (target - 1) / 2;
            for (int i = 1; i <= limit; ++i) {
                for (int j = i; ; ++j) {
                    sum += j;
                    if (sum > target) {
                        sum = 0;
                        break;
                    } else if (sum == target) {
                        int[] res = new int[j - i + 1];
                        for (int k = i; k <= j; ++k) {
                            res[k - i] = k;
                        }
                        vec.add(res);
                        sum = 0;
                        break;
                    }
                }
            }
            return vec.toArray(new int[vec.size()][]);
        }
    }

    /**
     * 方法三：双指针
     */
    class Solution1 {
        public int[][] findContinuousSequence(int target) {
            List<int[]> vec = new ArrayList<>();
            for (int l = 1, r = 2; l < r; ) {
                // sum 表示 [l,r] 的区间和
                int sum = (l + r) * (r - l + 1) / 2;
                if (sum == target) {
                    int[] res = new int[r - l + 1];
                    for (int i = l; i <= r; ++i) {
                        res[i - l] = i;
                    }
                    vec.add(res);
                    l++;
                } else if (sum < target) {
                    r++;
                } else {
                    l++;
                }
            }
            return vec.toArray(new int[vec.size()][]);
        }
    }

    /**
     * 滑动窗口
     */
    class Solution2 {
        public int[][] findContinuousSequence(int target) {
            int i = 1; // 滑动窗口的左边界
            int j = 1; // 滑动窗口的右边界
            int sum = 0; // 滑动窗口中数字的和
            List<int[]> res = new ArrayList<>();

            while (i <= target / 2) {
                if (sum < target) {
                    // 右边界向右移动
                    sum += j;
                    j++;
                } else if (sum > target) {
                    // 左边界向右移动
                    sum -= i;
                    i++;
                } else {
                    // 记录结果
                    int[] arr = new int[j - i];
                    for (int k = i; k < j; k++) {
                        arr[k - i] = k;
                    }
                    res.add(arr);
                    // 左边界向右移动
                    sum -= i;
                    i++;
                }
            }

            return res.toArray(new int[res.size()][]);
        }
    }
}
