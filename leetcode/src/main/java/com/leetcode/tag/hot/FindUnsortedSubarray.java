package com.leetcode.tag.hot;

/**
 * 581. 最短无序连续子数组
 * <p>
 * 最值 最值 最值 最值 最值
 */
public class FindUnsortedSubarray {
    /**
     * 方法 1：暴力
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j <= nums.length; j++) {
                    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, nums[k]);
                        max = Math.max(max, nums[k]);
                    }
                    if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
                        continue;
                    int k = 0;
                    while (k < i && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    if (k != i)
                        continue;
                    k = j;
                    while (k < nums.length && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    if (k == nums.length) {
                        res = Math.min(res, j - i);

                    }
                }
            }
            return res;
        }
    }

}
