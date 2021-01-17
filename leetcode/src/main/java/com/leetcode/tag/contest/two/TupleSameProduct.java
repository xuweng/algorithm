package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5243. 同积元组
 */
public class TupleSameProduct {
    static class Solution {
        public int tupleSameProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int k = i + 3; k < nums.length; k++) {
                    int p = nums[i] * nums[k];
                    int end = k - 1;
                    int j = i + 1;
                    while (j < end) {
                        int p1 = nums[j] * nums[end];
                        if (p == p1) {
                            result++;
                            j++;
                            end--;
                        } else if (p1 < p) {
                            j++;
                        } else {
                            end--;
                        }
                    }
                }
            }

            return result * 8;
        }
    }

    class Solution1 {
        public int tupleSameProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        for (int l = k + 1; l < nums.length; l++) {
                            if (nums[i] * nums[l] == nums[j] * nums[k] || nums[i] * nums[k] == nums[j] * nums[l]) {
                                result++;
                            }
                        }
                    }
                }
            }

            return result * 8;
        }
    }

    /**
     * 看题解
     * <p>
     * 先排序，从两边往中间搜索。固定头尾，遍历中间，不能整除直接跳过，剩下的值通过二分查找优化。
     * <p>
     * 作者：raphael-wang
     * 链接：https://leetcode-cn.com/problems/tuple-with-same-product/solution/java-er-fen-cha-zhao-by-raphael-wang-lliy/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int tupleSameProduct(int[] nums) {
            // 2,3,4,6 -> 8 -> 一定是8的倍数，因为一组可以有2*2*2个组合
            // 类似FourSum，剪支，二分查找
            Arrays.sort(nums);
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    int multi = nums[i] * nums[j];
                    for (int k = i + 1; k < j; k++) {
                        if (multi % nums[k] != 0) {
                            continue;
                        }
                        int target = multi / nums[k];
                        int left = k + 1;
                        int right = j - 1;
                        while (left <= right) {
                            int mid = left + ((right - left) >> 1);
                            if (nums[mid] > target) {
                                right = mid - 1;
                            } else if (nums[mid] < target) {
                                left = mid + 1;
                            } else {
                                count++;
                                break;
                            }
                        }
                    }
                }
            }

            return count * 8;
        }

    }
}
