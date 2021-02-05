package com.leetcode.tag.daily.seven;

/**
 * 1208. 尽可能使字符串相等
 */
public class EqualSubstring {
    /**
     * 方法一：前缀和 + 二分查找
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/jin-ke-neng-shi-zi-fu-chuan-xiang-deng-b-higz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int n = s.length();
            //前缀和
            int[] accDiff = new int[n + 1];
            for (int i = 0; i < n; i++) {
                accDiff[i + 1] = accDiff[i] + Math.abs(s.charAt(i) - t.charAt(i));
            }
            int maxLength = 0;
            for (int i = 1; i <= n; i++) {
                int start = binarySearch(accDiff, i, accDiff[i] - maxCost);
                maxLength = Math.max(maxLength, i - start);
            }
            return maxLength;
        }

        /**
         * 由于 diff 的的每个元素都是非负的，因此 accDiff 是递增的，对于每个下标 j，
         * <p>
         * 可以通过在 accDiff 内进行二分查找的方法找到符合要求的最小的下标 k。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/jin-ke-neng-shi-zi-fu-chuan-xiang-deng-b-higz/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param accDiff
         * @param endIndex
         * @param target
         * @return
         */
        public int binarySearch(int[] accDiff, int endIndex, int target) {
            int low = 0, high = endIndex;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (accDiff[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    /**
     * 方法二：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/jin-ke-neng-shi-zi-fu-chuan-xiang-deng-b-higz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int equalSubstring(String s, String t, int maxCost) {
            int n = s.length();
            int[] diff = new int[n];
            for (int i = 0; i < n; i++) {
                diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }

            int maxLength = 0;
            int start = 0, end = 0;
            int sum = 0;
            while (end < n) {
                sum += diff[end];
                while (sum > maxCost) {
                    sum -= diff[start];
                    start++;
                }
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }
            return maxLength;
        }
    }

    /**
     * 滑动窗口
     */
    class Solution2 {
        public int equalSubstring(String s, String t, int maxCost) {
            int left = 0;   // 窗口左边界
            int cost = 0;   // 当前窗口消耗
            // i作为窗口右边界
            for (int i = 0; i < s.length(); i++) {
                cost += Math.abs(s.charAt(i) - t.charAt(i));
                // 如果当前窗口消耗大于总开销，则左边界++，移动窗口
                if (cost > maxCost) {
                    cost -= Math.abs(s.charAt(left) - t.charAt(left));
                    left++;
                }
            }
            return s.length() - left;
        }
    }

}
