package com.leetcode.tag.daily.six;

import java.util.*;
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
                String key = new String(array);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }

}
