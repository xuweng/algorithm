package com.leetcode.tag.daily.five;

/**
 * 204. 计数质数
 */
public class CountPrimes {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int countPrimes(int n) {
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                ans += isPrime(i) ? 1 : 0;
            }
            return ans;
        }

        public boolean isPrime(int x) {
            for (int i = 2; i * i <= x; ++i) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
