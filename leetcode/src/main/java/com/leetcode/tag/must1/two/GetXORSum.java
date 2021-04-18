package com.leetcode.tag.must1.two;

/**
 * 5737. 所有数对按位与结果的异或和
 */
public class GetXORSum {
    class Solution {
        public int getXORSum(int[] arr1, int[] arr2) {
            int sum2 = 0;
            int ret = 0;
            for (int i : arr2) {
                sum2 ^= i;
            }
            for (int i : arr1) {
                ret ^= (i & sum2);
            }
            return ret;
        }
    }

    /**
     * 代码可以转化为，直接将两个数组的异或和进行“按位与”运算
     */
    class Solution1 {
        public int getXORSum(int[] arr1, int[] arr2) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i : arr1) {
                sum1 ^= i;
            }
            for (int i : arr2) {
                sum2 ^= i;
            }
            return sum1 & sum2;
        }
    }
}
