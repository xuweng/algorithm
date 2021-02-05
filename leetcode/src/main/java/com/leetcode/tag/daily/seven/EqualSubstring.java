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

}
