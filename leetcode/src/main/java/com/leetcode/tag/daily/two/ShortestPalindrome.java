package com.leetcode.tag.daily.two;

/**
 * 214. 最短回文串
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 */
public class ShortestPalindrome {
    class Solution {
        public String shortestPalindrome(String s) {
            return null;
        }
    }

    /**
     * 方法一：字符串哈希
     * <p>
     * 这里我们用 s'+s 表示得到的回文串。显然，这等价于找到最短的字符串 s'，使得 s'+s是一个回文串
     * <p>
     * 由于我们一定可以将 s 去除第一个字符后得到的字符串反序地添加在 s 的前面得到一个回文串，因此一定有 |s'| < |s|，其中 |s|表示字符串 s 的长度。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/shortest-palindrome/solution/zui-duan-hui-wen-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public String shortestPalindrome(String s) {
            int n = s.length();
            int base = 131, mod = 1000000007;
            int left = 0, right = 0, mul = 1;
            int best = -1;
            for (int i = 0; i < n; ++i) {
                left = (int) (((long) left * base + s.charAt(i)) % mod);
                right = (int) ((right + (long) mul * s.charAt(i)) % mod);
                if (left == right) {
                    best = i;
                }
                mul = (int) ((long) mul * base % mod);
            }
            String add = (best == n - 1 ? "" : s.substring(best + 1));
            StringBuffer ans = new StringBuffer(add).reverse();
            ans.append(s);
            return ans.toString();
        }
    }

}
