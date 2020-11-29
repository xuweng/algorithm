package com.leetcode.tag.daily.five;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 */
public class LargestPerimeter {
    /**
     * 方法一：贪心 + 排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle/solution/san-jiao-xing-de-zui-da-zhou-chang-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            //倒序枚举第 i 个数作为最长边
            for (int i = A.length - 1; i >= 2; --i) {
                if (A[i - 2] + A[i - 1] > A[i]) {
                    return A[i - 2] + A[i - 1] + A[i];
                }
            }
            return 0;
        }
    }

}
