package com.leetcode.tag.daily.eight;

/**
 * 995. K 连续位的最小翻转次数
 * <p>
 * 模拟理解题意 理解思路
 */
public class MinKBitFlips {
    /**
     * 一、初步实现——模拟翻转
     * <p>
     * 作者：yxiaojian
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-dseq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 对于每个位置开始的长度为k的翻转
         *
         * @param A
         * @param K
         * @return
         */
        public int minKBitFlips(int[] A, int K) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 1) {
                    continue;
                }
                if (i + K > A.length) {
                    return -1;
                }
                for (int j = i; j < i + K; j++) {
                    // 异或 翻转
                    // 0^1=1 1^1=0
                    A[j] ^= 1;
                }
                count++;
            }
            return count;
        }
    }

}
