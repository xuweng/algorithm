package com.leetcode.tag.dp.one.two.six;

/**
 * 409. 最长回文串
 */
public class LongestPalindrome {
    /**
     * 方法一：贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            int length = s.length();
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                count[c]++;
            }

            int ans = 0;
            for (int v : count) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int longestPalindrome(String s) {
            // 找出可以构成最长回文串的长度
            int[] arr = new int[128];
            for (char c : s.toCharArray()) {
                arr[c]++;
            }
            //字符次数为奇数的个数
            int count = 0;
            for (int i : arr) {
                // 偶数为0
                // 统计字符次数为奇数的个数
                count += (i % 2);
            }
            // 1个奇数字符+所有偶数字符
            return count == 0 ? s.length() : (s.length() - count + 1);
        }
    }

}
