package com.leetcode.tag.top.one;

/**
 * 42. 接雨水
 * <p>
 * 结果：最长重复字符长度 + k
 */
public class Trap {
    class Solution {
        public int trap(int[] height) {
            int[] left = new int[height.length];
            int maxLeft = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > maxLeft) {
                    left[i] = height[i];
                    maxLeft = height[i];
                } else {
                    left[i] = maxLeft;
                }
            }
            int[] right = new int[height.length];
            int maxRight = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                if (height[i] > maxRight) {
                    right[i] = height[i];
                    maxRight = height[i];
                } else {
                    right[i] = maxRight;
                }
            }

            int result = 0;
            for (int i = 0; i < height.length; i++) {
                result += Math.min(left[i], right[i]) - height[i];
            }

            return result;
        }
    }

    /**
     * 方法 1：暴力
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int ans = 0;
            int size = height.length;
            for (int i = 1; i < size - 1; i++) {
                int maxLeft = 0, maxRight = 0;
                for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                    maxLeft = Math.max(maxLeft, height[j]);
                }
                for (int j = i; j < size; j++) { //Search the right part for max bar size
                    maxRight = Math.max(maxRight, height[j]);
                }
                ans += Math.min(maxLeft, maxRight) - height[i];
            }
            return ans;
        }
    }

    /**
     * 方法 2：动态编程
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int ans = 0;
            int size = height.length;
            // 左侧递增
            int[] leftMax = new int[size];
            leftMax[0] = height[0];
            for (int i = 1; i < size; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }

            // 右侧递增
            int[] rightMax = new int[size];
            rightMax[size - 1] = height[size - 1];
            for (int i = size - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }

            for (int i = 1; i < size - 1; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }

    }
}
