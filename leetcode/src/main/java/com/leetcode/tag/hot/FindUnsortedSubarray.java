package com.leetcode.tag.hot;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * <p>
 * 最值 最值 最值 最值 最值
 * <p>
 * 最值 区间
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
                    // [i,j] 最值
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, nums[k]);
                        max = Math.max(max, nums[k]);
                    }
                    if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max)) {
                        continue;
                    }
                    // [0,i-1] 是否升序
                    int k = 0;
                    while (k < i && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    if (k != i) {
                        continue;
                    }
                    // [j+1,n] 是否升序
                    k = j;
                    while (k < nums.length && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    // 更新结果
                    if (k == nums.length) {
                        res = Math.min(res, j - i);
                    }
                }
            }
            return res;
        }
    }

    class Solution1 {
        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int[] nums1 = new int[nums.length];
            System.arraycopy(nums, 0, nums1, 0, nums.length);
            Arrays.sort(nums1);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != nums1[i]) {
                    min = Math.min(min, i);
                    max = Math.max(max, i);
                }
            }

            return min == Integer.MAX_VALUE ? 0 : max - min + 1;
        }
    }

    class Solution2 {
        public int findUnsortedSubarray(int[] nums) {
            int[] snums = nums.clone();

            Arrays.sort(snums);

            int start = snums.length, end = 0;
            for (int i = 0; i < snums.length; i++) {
                // 比较 nums  和 snums 的元素来决定最左边和最右边不匹配的元素
                if (snums[i] != nums[i]) {
                    start = Math.min(start, i);
                    end = Math.max(end, i);
                }
            }
            return (end - start >= 0 ? end - start + 1 : 0);
        }
    }
}
