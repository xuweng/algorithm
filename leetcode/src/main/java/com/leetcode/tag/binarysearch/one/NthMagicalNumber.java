package com.leetcode.tag.binarysearch.one;

/**
 * 878. 第 N 个神奇数字
 */
public class NthMagicalNumber {
    /**
     * 方法一：数学方法
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/nth-magical-number/solution/di-n-ge-shen-qi-shu-zi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int nthMagicalNumber(int N, int A, int B) {
            int mOD = 1_000_000_007;
            int l = A / gcd(A, B) * B;
            int m = l / A + l / B - 1;
            int q = N / m, r = N % m;

            long ans = (long) q * l % mOD;
            if (r == 0) {
                return (int) ans;
            }

            int[] heads = new int[]{A, B};
            for (int i = 0; i < r - 1; ++i) {
                if (heads[0] <= heads[1]) {
                    heads[0] += A;
                } else {
                    heads[1] += B;
                }
            }

            ans += Math.min(heads[0], heads[1]);
            return (int) (ans % mOD);
        }

        public int gcd(int x, int y) {
            if (x == 0) {
                return y;
            }
            return gcd(y % x, x);
        }
    }

    /**
     * 方法二： 二分搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/nth-magical-number/solution/di-n-ge-shen-qi-shu-zi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int nthMagicalNumber(int N, int A, int B) {
            int mOD = 1_000_000_007;
            int l = A / gcd(A, B) * B;

            long lo = 0;
            long hi = (long) 1e15;
            while (lo < hi) {
                long mi = lo + (hi - lo) / 2;
                // If there are not enough magic numbers below mi...
                if (mi / A + mi / B - mi / l < N) {
                    lo = mi + 1;
                } else {
                    hi = mi;
                }
            }

            return (int) (lo % mOD);
        }

        public int gcd(int x, int y) {
            if (x == 0) {
                return y;
            }
            return gcd(y % x, x);
        }
    }

}
