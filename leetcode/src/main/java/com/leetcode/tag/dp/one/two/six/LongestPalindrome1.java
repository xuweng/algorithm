package com.leetcode.tag.dp.one.two.six;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome1 {
    /**
     * 方法一：暴力匹配 （Brute Force）
     * <p>
     * 时间复杂度：O(N^3)，这里 NN 是字符串的长度，枚举字符串的左边界、右边界，然后继续验证子串是否是回文子串
     * <p>
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
            char[] charArray = s.toCharArray();

            // 枚举所有长度大于 1 的子串 charArray[i..j]
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        /**
         * 验证子串 s[left..right] 是否为回文串
         */
        private boolean validPalindromic(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            String res = s.substring(0, 1);
            // 中心位置枚举到 len - 2 即可
            for (int i = 0; i < len - 1; i++) {
                //1、如果传入重合的索引编码，进行中心扩散，此时得到的回文子串的长度是奇数；
                //2、如果传入相邻的索引编码，进行中心扩散，此时得到的回文子串的长度是偶数。
                // 输入 i i 奇数
                // 输入 i i+1 偶数
                String oddStr = centerSpread(s, i, i);
                String evenStr = centerSpread(s, i, i + 1);
                String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
                if (maxLenStr.length() > maxLen) {
                    maxLen = maxLenStr.length();
                    res = maxLenStr;
                }
            }
            return res;
        }

        private String centerSpread(String s, int left, int right) {
            // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
            // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
            int len = s.length();
            int i = left;
            int j = right;
            while (i >= 0 && j < len) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                } else {
                    i--;
                    j++;
                }
            }
            // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
            return s.substring(i + 1, j);
        }
    }

}
