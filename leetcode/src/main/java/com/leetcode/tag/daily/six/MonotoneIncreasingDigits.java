package com.leetcode.tag.daily.six;

/**
 * 738. 单调递增的数字
 */
public class MonotoneIncreasingDigits {
    /**
     * 方法一：贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/dan-diao-di-zeng-de-shu-zi-by-leetcode-s-5908/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            char[] strN = Integer.toString(N).toCharArray();
            int i = 1;
            while (i < strN.length && strN[i - 1] <= strN[i]) {
                i += 1;
            }
            if (i < strN.length) {
                while (i > 0 && strN[i - 1] > strN[i]) {
                    strN[i - 1] -= 1;
                    i -= 1;
                }
                for (i += 1; i < strN.length; ++i) {
                    strN[i] = '9';
                }
            }
            return Integer.parseInt(new String(strN));
        }
    }

}
