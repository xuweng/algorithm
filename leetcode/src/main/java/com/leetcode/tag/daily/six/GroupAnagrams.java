package com.leetcode.tag.daily.six;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strs) {
                map.computeIfAbsent(get(str), v -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }

        private int get(String s) {
            return IntStream.range(0, s.length()).map(s::charAt).sum();
        }
    }

    /**
     * 方法一：排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                map.computeIfAbsent(new String(array), v -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    /**
     * 方法二：计数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        /**
         * 由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，
         * <p>
         * 故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
         *
         * @param strs
         * @return
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int[] counts = new int[26];
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        sb.append((char) ('a' + i)).append(counts[i]);
                    }
                }
                map.computeIfAbsent(sb.toString(), v -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    /**
     * groupingBy
     * <p>
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/group-anagrams/solution/kan-wo-yi-ju-hua-ac-zi-mu-yi-wei-ci-fen-yrnis/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            return new ArrayList<>(Arrays.stream(strs)
                    .collect(Collectors.groupingBy(str -> {
                        // 返回 str 排序后的结果。
                        // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                        char[] array = str.toCharArray();
                        Arrays.sort(array);
                        return new String(array);
                    })).values());
        }
    }

}
