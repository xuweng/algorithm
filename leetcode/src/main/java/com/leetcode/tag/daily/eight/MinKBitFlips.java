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

    /**
     * 方法一：差分数组
     * <p>
     * 推理 推理
     * <p>
     * 而对于一个数若其经历了奇数次翻转，则其改变，若经历了偶数次翻转则其值未变，即
     * <p>
     * 0翻转偶数次后，数值仍然是0，需要被翻转
     * 0翻转奇数次后，数值变为1，无需被翻转
     * 1翻转偶数次后，数值任然是1，无需翻转
     * 1翻转奇数次后，数值变为0，需要被翻转
     * 则可使用(sumReA&1)^A[i]，判断是否需要翻转
     * <p>
     * 作者：yxiaojian
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-dseq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * <p>
     * https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-dseq/
     * <p>
     * 每次都模拟了以i开始长度为K的翻转，但这样效率便受限于K值了，而很明显，一次翻转是对【i,i+K-1】区间的数都进行了改变，
     * <p>
     * 而对于区间操作，有一种常见的方法——差分（前缀和的逆运用，对区间两端进行操作以代替区间内操作）
     * <p>
     * 作者：yxiaojian
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-dseq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-bikk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minKBitFlips(int[] A, int K) {
            int n = A.length;
            int[] diff = new int[n + 1];
            int ans = 0, revCnt = 0;
            for (int i = 0; i < n; ++i) {
                revCnt += diff[i];
                if ((A[i] + revCnt) % 2 == 0) {
                    if (i + K > n) {
                        return -1;
                    }
                    ++ans;
                    ++revCnt;
                    --diff[i + K];
                }
            }
            return ans;
        }
    }

    /**
     * 方法二：滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-bikk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int minKBitFlips(int[] A, int K) {
            int n = A.length;
            int ans = 0, revCnt = 0;
            for (int i = 0; i < n; ++i) {
                if (i >= K && A[i - K] > 1) {
                    revCnt ^= 1;
                    A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
                }
                if (A[i] == revCnt) {
                    if (i + K > n) {
                        return -1;
                    }
                    ++ans;
                    revCnt ^= 1;
                    A[i] += 2;
                }
            }
            return ans;
        }
    }

}
