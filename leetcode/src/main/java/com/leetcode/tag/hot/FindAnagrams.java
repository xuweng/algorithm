package com.leetcode.tag.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {
    /**
     * 滑动固定窗口
     * <p>
     * 作者：wen-jian-69
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-gu-ding-chuang-kou-dai-ma-han-z-2aec/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            // 记录p的所有字母及其个数
            char[] need = new char[26];
            for (int i = 0; i < p.length(); i++) {
                need[p.charAt(i) - 'a']++;
            }
            // start和end分别控制窗口的前端和后端
            int start = 0, end = 0;
            char[] window = new char[26];
            List<Integer> ans = new ArrayList<>();
            while (end < s.length()) {
                // 加入窗口数据
                window[s.charAt(end) - 'a']++;
                // 维护一个长度为p.length()的窗口，并更新答案
                while (end - start + 1 == p.length()) {
                    if (Arrays.equals(window, need)) {
                        ans.add(start);
                    }
                    window[s.charAt(start) - 'a']--;
                    start++;
                }
                end++;
            }
            return ans;
        }
    }
}
