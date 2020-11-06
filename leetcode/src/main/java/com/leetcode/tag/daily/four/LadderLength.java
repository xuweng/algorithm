package com.leetcode.tag.daily.four;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 127. 单词接龙
 */
public class LadderLength {
    static class Solution {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Set<String> memo = new HashSet<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 重复计算
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @param count
         */
        private void dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, count);
                return;
            }
            if (memo.contains(beginWord)) {
                return;
            }
            memo.add(beginWord);

            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            for (String string : strings) {
                dfs(string, endWord, wordList, count + 1);
            }
            set.remove(beginWord);
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(s)).collect(Collectors.toList());
        }

        private boolean check(String s, String s1) {
            if (s.length() != s1.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    class Solution1 {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 重复计算
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @param count
         */
        private void dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, count);
                memo.put(beginWord, min);
                return;
            }
            if (memo.containsKey(beginWord) && memo.get(beginWord) <= count) {
                return;
            }
            memo.put(beginWord, count);

            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            for (String string : strings) {
                dfs(string, endWord, wordList, count + 1);
            }
            set.remove(beginWord);
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(s)).collect(Collectors.toList());
        }

        private boolean check(String s, String s1) {
            if (s.length() != s1.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    static class Solution2 {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 重复计算
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @param count
         */
        private int dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, count);
                memo.put(beginWord, 0);
                return 0;
            }
            if (memo.containsKey(beginWord)) {
                if (memo.get(beginWord) != Integer.MAX_VALUE) {
                    min = Math.min(min, count + memo.get(beginWord));
                }
                return memo.get(beginWord);
            }

            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            // beginWord到endWord的最小距离
            int result = Integer.MAX_VALUE;
            for (String string : strings) {
                int d = dfs(string, endWord, wordList, count + 1);
                if (d == Integer.MAX_VALUE) {
                    // 到不了终点
                    continue;
                }
                result = Math.min(result, d + 1);
            }
            set.remove(beginWord);
            memo.put(beginWord, result);
            return result;
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(s)).collect(Collectors.toList());
        }

        private boolean check(String s, String s1) {
            if (s.length() != s1.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    /**
     * 方法二：双向广度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        Map<String, Integer> wordId = new HashMap<>();
        List<List<Integer>> edge = new ArrayList<>();
        int nodeNum = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);
            if (!wordId.containsKey(endWord)) {
                return 0;
            }

            int[] disBegin = new int[nodeNum];
            Arrays.fill(disBegin, Integer.MAX_VALUE);
            int beginId = wordId.get(beginWord);
            disBegin[beginId] = 0;
            //从 beginWord 开始
            Queue<Integer> queBegin = new LinkedList<>();
            queBegin.offer(beginId);

            int[] disEnd = new int[nodeNum];
            Arrays.fill(disEnd, Integer.MAX_VALUE);
            int endId = wordId.get(endWord);
            disEnd[endId] = 0;
            //从 endWord 开始
            Queue<Integer> queEnd = new LinkedList<>();
            queEnd.offer(endId);

            while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
                //每次从两边各扩展一层节点，当发现某一时刻两边都访问过同一顶点时就停止搜索
                int queBeginSize = queBegin.size();
                for (int i = 0; i < queBeginSize; ++i) {
                    int nodeBegin = queBegin.poll();
                    if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                        return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                    }
                    for (int it : edge.get(nodeBegin)) {
                        if (disBegin[it] == Integer.MAX_VALUE) {
                            disBegin[it] = disBegin[nodeBegin] + 1;
                            queBegin.offer(it);
                        }
                    }
                }

                int queEndSize = queEnd.size();
                for (int i = 0; i < queEndSize; ++i) {
                    int nodeEnd = queEnd.poll();
                    if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                        return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                    }
                    for (int it : edge.get(nodeEnd)) {
                        if (disEnd[it] == Integer.MAX_VALUE) {
                            disEnd[it] = disEnd[nodeEnd] + 1;
                            queEnd.offer(it);
                        }
                    }
                }
            }
            return 0;
        }

        public void addEdge(String word) {
            addWord(word);
            int id1 = wordId.get(word);
            char[] array = word.toCharArray();
            int length = array.length;
            for (int i = 0; i < length; ++i) {
                char tmp = array[i];
                array[i] = '*';
                String newWord = new String(array);
                addWord(newWord);
                int id2 = wordId.get(newWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
                array[i] = tmp;
            }
        }

        public void addWord(String word) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, nodeNum++);
                edge.add(new ArrayList<>());
            }
        }
    }

}
