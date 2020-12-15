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

    /**
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/jian-dan-tan-xin-shou-ba-shou-jiao-xue-k-a0mp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int monotoneIncreasingDigits(int N) {
            char[] arr = (N + "").toCharArray();
            int max = -1, idx = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
                if (arr[i] > arr[i + 1]) {
                    arr[idx] -= 1;
                    for (int j = idx + 1; j < arr.length; j++) {
                        arr[j] = '9';
                    }
                    break;
                }
            }
            return Integer.parseInt(new String(arr));
        }
    }

}
