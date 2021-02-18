package com.leetcode.tag.daily.eight;

import java.util.Arrays;

/**
 * 567. 字符串的排列
 * <p>
 * 定长滑动窗口 动态滑动窗口
 * <p>
 * 暂时跳过
 */
public class CheckInclusion {
    /**
     * 方法一：滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt1 = new int[26];
            //使用一个固定长度为 n 的滑动窗口来维护cnt2
            int[] cnt2 = new int[26];
            for (int i = 0; i < n; ++i) {
                ++cnt1[s1.charAt(i) - 'a'];
                ++cnt2[s2.charAt(i) - 'a'];
            }
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
            for (int i = n; i < m; ++i) {
                //滑动窗口每向右滑动一次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符
                ++cnt2[s2.charAt(i) - 'a'];
                --cnt2[s2.charAt(i - n) - 'a'];
                if (Arrays.equals(cnt1, cnt2)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 优化
     * <p>
     * 每次窗口滑动时，只统计了一进一出两个字符，却比较了整个cnt1和cnt2
     * <p>
     * 可以用一个变量 diff 来记录cnt1和cnt2不同值的个数，这样判断cnt1和cnt2是否相等就转换成了判断diff 是否为 0.
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; ++i) {
                --cnt[s1.charAt(i) - 'a'];
                ++cnt[s2.charAt(i) - 'a'];
            }
            int diff = 0;
            for (int c : cnt) {
                if (c != 0) {
                    ++diff;
                }
            }
            if (diff == 0) {
                return true;
            }
            for (int i = n; i < m; ++i) {
                //每次窗口滑动，记一进一出两个字符为 x 和 y.
                int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
                if (x == y) {
                    continue;
                }
                if (cnt[x] == 0) {
                    ++diff;
                }
                ++cnt[x];
                if (cnt[x] == 0) {
                    --diff;
                }
                if (cnt[y] == 0) {
                    ++diff;
                }
                --cnt[y];
                if (cnt[y] == 0) {
                    --diff;
                }
                if (diff == 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 方法二：双指针
     * <p>
     * 动态滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-7k7u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; ++i) {
                --cnt[s1.charAt(i) - 'a'];
            }
            int left = 0;
            for (int right = 0; right < m; ++right) {
                int x = s2.charAt(right) - 'a';
                ++cnt[x];
                while (cnt[x] > 0) {
                    --cnt[s2.charAt(left) - 'a'];
                    // 收缩
                    ++left;
                }
                if (right - left + 1 == n) {
                    return true;
                }
            }
            return false;
        }
    }

}
