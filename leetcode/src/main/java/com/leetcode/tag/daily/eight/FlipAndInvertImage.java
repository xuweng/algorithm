package com.leetcode.tag.daily.eight;

/**
 * 832. 翻转图像
 */
public class FlipAndInvertImage {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/flipping-an-image/solution/fan-zhuan-tu-xiang-by-leetcode-solution-yljd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            int n = A.length;
            for (int i = 0; i < n; i++) {
                int left = 0, right = n - 1;
                while (left < right) {
                    if (A[i][left] == A[i][right]) {
                        A[i][left] ^= 1;
                        A[i][right] ^= 1;
                    }
                    left++;
                    right--;
                }
                if (left == right) {
                    A[i][left] ^= 1;
                }
            }
            return A;
        }
    }

}
