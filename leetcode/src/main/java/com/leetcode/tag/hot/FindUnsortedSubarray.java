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
     * 对于每一个子序列 nums[i:j]  ，我们检查它是否是最小的无序子序列。因此对于每一个子序列，我们求出这个子序列中的最大和最小值，
     * <p>
     * 并分别用 max 和 min 表示。
     * <p>
     * 子序列 nums[0:i-1] 和 nums[j:n-1] 是升序的，那么仅有 nums[i:j] 是可能的子序列。更进一步，
     * <p>
     * nums[0:i-1]中所有的元素都要比 min 小且 nums[j:n-1] 中所有的元素都要比 max大。我们对于枚举的每一对 i 和 j 都做这样的检查。
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
                    if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max)) {
                        continue;
                    }
                    int k = 0;
                    while (k < i && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    if (k != i) {
                        continue;
                    }
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
