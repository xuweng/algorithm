package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 1002. 查找常用字符
 * <p>
 * 用示例来理解代码.
 * <p>
 * 用示例来理解代码.
 */
public class CommonChars {
    class Solution {
        public List<String> commonChars(String[] A) {
            if (A == null) {
                return new ArrayList<>();
            }
            Map<Character, Integer> map = new HashMap<>();
            for (String s : A) {
                for (int i = 0; i < s.length(); i++) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                }
            }
            List<String> result = new ArrayList<>();
            map.forEach((k, v) -> {
                int size = v / 3;
                for (int i = 0; i < size; i++) {
                    result.add(String.valueOf(k));
                }
            });

            return result;
        }
    }

    /**
     * 方法一：计数
     * <p>
     * 厉害
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-common-characters/solution/cha-zhao-chang-yong-zi-fu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<String> commonChars(String[] A) {
            int[] minfreq = new int[26];
            Arrays.fill(minfreq, Integer.MAX_VALUE);
            for (String word : A) {
                int[] freq = new int[26];
                int length = word.length();
                // 统计每个字符出现的次数
                for (int i = 0; i < length; ++i) {
                    char ch = word.charAt(i);
                    ++freq[ch - 'a'];
                }
                for (int i = 0; i < 26; ++i) {
                    minfreq[i] = Math.min(minfreq[i], freq[i]);
                }
            }

            //当我们遍历完所有字符串后，minfreq[c] 就存储了字符 c 在所有字符串中出现次数的最小值。
            //没有出现的字符统计次数为0
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < minfreq[i]; ++j) {
                    ans.add(String.valueOf((char) (i + 'a')));
                }
            }
            return ans;
        }
    }

}
