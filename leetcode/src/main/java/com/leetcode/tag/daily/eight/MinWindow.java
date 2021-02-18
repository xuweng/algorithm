package com.leetcode.tag.daily.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {
    /**
     * 方法一：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();

        public String minWindow(String s, String t) {
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();
            while (r < sLen) {
                ++r;
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            for (Map.Entry<Character, Integer> characterIntegerEntry : ori.entrySet()) {
                Map.Entry entry = characterIntegerEntry;
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution1 {
        public String minWindow(String s, String t) {
            char[] chars = s.toCharArray(), chart = t.toCharArray();
            int n = chars.length, m = chart.length;

            int[] hash = new int[128];
            for (char ch : chart) {
                hash[ch]--;
            }

            String res = "";
            for (int i = 0, j = 0, cnt = 0; i < n; i++) {
                hash[chars[i]]++;
                if (hash[chars[i]] <= 0) {
                    cnt++;
                }
                while (cnt == m && hash[chars[j]] > 0) {
                    hash[chars[j++]]--;
                }
                if (cnt == m) {
                    if ("".equals(res) || res.length() > i - j + 1) {
                        res = s.substring(j, i + 1);
                    }
                }
            }
            return res;
        }
    }

    /**
     * 容易理解 框架
     * <p>
     * 滑动窗口
     * <p>
     * 作者：zhi-zhao-22
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring/solution/labuladongde-suan-fa-xiao-chao-javaban-b-glhm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;
            // 记录最小覆盖字串的起始索引
            int start = 0;
            // 记录最小覆盖字串长度
            int len = Integer.MAX_VALUE;
            while (right < s.length()) {
                char c = s.charAt(right);
                // 扩张
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }

                // 判断是否需要收缩（已经找到合适的覆盖串）
                while (valid == need.size()) {
                    if (right - left < len) {
                        // 更新最下长度
                        start = left;
                        len = right - left;
                    }

                    char c1 = s.charAt(left);
                    // 收缩
                    left++;
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }

            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }

}
