package com.leetcode.tag.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElement {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) {
                return nums1;
            }
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], i);
            }
            int[] result = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                result[i] = get(nums2, nums1[i]);
            }

            return result;
        }

        private int get(int[] nums2, int value) {
            int index = map.get(value);
            for (int i = index + 1; i < nums2.length; i++) {
                if (nums2[i] > value) {
                    return nums2[i];
                }
            }

            return -1;
        }
    }

    /**
     * 方法一：单调栈
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] nextGreaterElement(int[] findNums, int[] nums) {
            // 单调递减
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] res = new int[findNums.length];
            // 正序遍历
            for (int num : nums) {
                while (!stack.empty() && num > stack.peek()) {
                    // 小的出栈
                    // 记录 栈顶元素 右边第一个大元素
                    map.put(stack.pop(), num);
                }
                // 大的入栈
                stack.push(num);
            }
            while (!stack.empty()) {
                // 剩余单调递减
                map.put(stack.pop(), -1);
            }
            for (int i = 0; i < findNums.length; i++) {
                res[i] = map.get(findNums[i]);
            }
            return res;
        }
    }

    class Solution2 {
        public int[] nextGreaterElement(int[] findNums, int[] nums) {
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] res = new int[findNums.length];
            //单调栈 倒序遍历 从左到右单调递增
            for (int i = nums.length - 1; i >= 0; --i) {
                while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                    stack.pop();
                }
                map.put(nums[i], stack.empty() ? -1 : nums[stack.peek()]);

                stack.push(i);
            }
            for (int i = 0; i < findNums.length; i++) {
                res[i] = map.get(findNums[i]);
            }
            return res;
        }
    }
}
