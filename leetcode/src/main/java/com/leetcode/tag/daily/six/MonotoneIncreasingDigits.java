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
                    // 低位变为9
                    for (int j = idx + 1; j < arr.length; j++) {
                        arr[j] = '9';
                    }
                    break;
                }
            }
            return Integer.parseInt(new String(arr));
        }
    }

    /**
     * 举例子 举例子 举例子 举例子 举例子
     * <p>
     * 例子：数字 1101 最大单调递增数为 999
     * 从低位向高位遍历，到0时发现前面有一个1>0，这里将后两位置为99，同时向高位“借位”，前两位变成11-1=10；此时num = 1099
     * 继续遍历又发现1>0，重复上述步骤得到结果999
     * <p>
     * 时间复杂度O(logN)
     * 空间复杂度O(1)
     * <p>
     * 作者：bei-ye-qing-yang
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/java-ologn-bu-xu-yao-zhuan-zi-fu-chuan-b-b7lk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int monotoneIncreasingDigits(int N) {
            int res = 0;
            // 倍数
            int seed = 1;
            while (N > 0) {
                int num = N % 10;
                N /= 10;
                int high = N % 10;
                if (high > num) {
                    // 高位大于低位，将低位全部置为9，高位数字-1
                    res = seed * 10 - 1;
                    N -= 1;
                } else {
                    res = num * seed + res;
                }
                seed *= 10;
            }
            return res;
        }

    }

}
