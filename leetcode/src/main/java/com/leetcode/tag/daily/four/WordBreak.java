package com.leetcode.tag.daily.four;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 140. 单词拆分 II
 */
public class WordBreak {
    class Solution {
        Set<String> set;
        List<String> result = new ArrayList<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            set = new HashSet<>(wordDict);

            dfs(s, 0, "");

            return result;
        }

        private void dfs(String s, int index, String temp) {
            if (index >= s.length()) {
                result.add(temp.substring(0, temp.length() - 1));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if (!set.contains(str)) {
                    continue;
                }
                dfs(s, i + 1, temp + str + " ");
            }
        }
    }

    /**
     * 方法一：记忆化搜索
     * <p>
     * https://leetcode-cn.com/problems/word-break-ii/solution/shou-hua-tu-jie-dan-ci-chai-fen-ii-cong-di-gui-dao/
     * <p>
     * 递归树.大量重复计算.
     * <p>
     * 递归树.大量重复计算.
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<Integer, List<List<String>>> map = new HashMap<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0);

            return wordBreaks.stream().map(wordBreak -> String.join(" ", wordBreak))
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index) {
            if (map.containsKey(index)) {
                return map.get(index);
            }
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (!wordSet.contains(word)) {
                    continue;
                }
                List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i);
                for (List<String> nextWordBreak : nextWordBreaks) {
                    LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                    wordBreak.offerFirst(word);
                    wordBreaks.add(wordBreak);
                }
            }
            // 使用哈希表存储字符串 s 的每个下标和从该下标开始的部分可以组成的句子列表,不需要重复计算
            map.put(index, wordBreaks);
            return map.get(index);
        }
    }

}
