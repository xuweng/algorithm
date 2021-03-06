package com.leetcode.tag.dfs.one;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 面试题 17.22. 单词转换
 * <p>
 * dp.dp.dp.dp.dp
 * <p>
 * 递归终止条件.递归终止条件.递归终止条件.递归终止条件.
 * <p>
 * 递归终止条件太重要.树形dp.递归终止条件.漂亮代码.
 */
public class FindLadders {
    /**
     * 算法错误
     * <p>
     * 不用按照从左到右的顺序选择
     */
    class Solution {
        List<String> result;
        List<String> stack = new ArrayList<>();

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 0);

            if (result == null) {
                return new ArrayList<>();
            }
            result.add(0, beginWord);

            return result;
        }

        public void dfs(String beginWord, String endWord, List<String> wordList, int start) {
            if (beginWord.equals(endWord)) {
                result = result == null ? new ArrayList<>(stack) : result;
                return;
            }
            for (int i = start; i < wordList.size(); i++) {
                if (!check(beginWord, wordList.get(i))) {
                    continue;
                }
                stack.add(wordList.get(i));
                dfs(wordList.get(i), endWord, wordList, i + 1);
                stack.remove(stack.size() - 1);
            }
        }

        private boolean check(String beginWord, String str) {
            if (beginWord.length() != str.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    /**
     * 超出时间限制
     */
    class Solution1 {
        List<String> result;
        List<String> stack = new ArrayList<>();
        boolean[] used;

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            used = new boolean[wordList.size()];

            dfs(beginWord, endWord, wordList);

            if (result == null) {
                return new ArrayList<>();
            }
            result.add(0, beginWord);

            return result;
        }

        public void dfs(String beginWord, String endWord, List<String> wordList) {
            if (result != null) {
                return;
            }
            if (beginWord.equals(endWord)) {
                result = new ArrayList<>(stack);
                return;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (!check(beginWord, wordList.get(i)) || used[i]) {
                    continue;
                }
                used[i] = true;
                stack.add(wordList.get(i));
                dfs(wordList.get(i), endWord, wordList);
                stack.remove(stack.size() - 1);
                //used不需要回溯
                //used[i] = false;
            }
        }

        private boolean check(String beginWord, String str) {
            if (beginWord.length() != str.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    class Solution6 {
        List<String> result;
        // LinkedList当作stack厉害
        LinkedList<String> stack = new LinkedList<>();
        boolean[] used;

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            used = new boolean[wordList.size()];

            dfs(beginWord, endWord, wordList);

            if (result == null) {
                return new ArrayList<>();
            }
            result.add(0, beginWord);

            return result;
        }

        public void dfs(String beginWord, String endWord, List<String> wordList) {
            //剪枝
            //递归终止条件
            if (result != null) {
                return;
            }
            //剪枝
            //递归终止条件
            if (beginWord.equals(endWord)) {
                result = new ArrayList<>(stack);
                return;
            }
            List<String> hou = getHou(beginWord, wordList);
            for (String s : hou) {
                stack.add(s);
                dfs(s, endWord, wordList);
                stack.removeLast();
            }
        }


        private List<String> getHou(String beginWord, List<String> wordList) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < wordList.size(); i++) {
                if (used[i] || !check(beginWord, wordList.get(i))) {
                    continue;
                }
                used[i] = true;
                result.add(wordList.get(i));
            }
            return result;
        }

        private boolean check(String beginWord, String str) {
            if (beginWord.length() != str.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }

    }

    /**
     * bfs
     * <p>
     * 作者：lonely-praecursor
     * 链接：https://leetcode-cn.com/problems/word-transformer-lcci/solution/xiang-bu-chu-biao-ti-by-lonely-praecursor/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        boolean f(String a, String b) {
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    cnt++;
                }
                if (cnt > 1) {
                    return false;
                }
            }
            return cnt == 1;
        }

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            Stack<LinkedList<String>> stack = new Stack<>();
            LinkedList<String> result = new LinkedList<>();
            result.add(beginWord);
            stack.add(new LinkedList<>(result));
            wordList.remove(beginWord);

            while (!stack.isEmpty()) {
                result = stack.pop();
                String s1 = result.peekLast();
                if (Objects.equals(s1, endWord)) {
                    return result;
                } else {
                    //满足条件的元素入队
                    for (int i = wordList.size() - 1; i >= 0; i--) {
                        String s = wordList.get(i);
                        if (!f(s1, s)) {
                            continue;
                        }
                        wordList.remove(i);
                        result.add(s);
                        stack.add(new LinkedList<>(result));
                        result.remove(s);
                    }
                }
            }
            return new LinkedList<>();
        }
    }

    /**
     * dfs
     */
    class Solution3 {
        public boolean canTranslate(String from, String to) {
            if (from.length() != to.length()) {
                return false;
            }
            return (int) IntStream.range(0, from.length()).filter(i -> from.charAt(i) != to.charAt(i)).count() == 1;
        }

        boolean hasRoute(String curWord, String endWord, List<String> wordList,
                         boolean[] visited, List<String> result) {
            if (curWord.equals(endWord)) {
                return true;
            }
            // 候选集是所有数据
            for (int i = 0; i < wordList.size(); ++i) {
                if (visited[i] || !canTranslate(curWord, wordList.get(i))) {
                    continue;
                }
                // 只需要把访问的数据标记.标记不需要回溯.
                visited[i] = true;
                result.add(wordList.get(i));
                if (hasRoute(wordList.get(i), endWord, wordList, visited, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
                // 精华
                // 如果运行到这一步，意味着无法从i这个点找到路径，所以visited[i]无需改为false.
                // visited[i] = false;
            }
            return false;
        }

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<String> result = new ArrayList<>();
            result.add(beginWord);
            boolean[] visited = new boolean[wordList.size()];
            if (hasRoute(beginWord, endWord, wordList, visited, result)) {
                return result;
            }
            return new ArrayList<>();
        }
    }

    /**
     * dfs
     */
    class Solution4 {
        Map<String, Set<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        boolean flag = false;
        boolean match = false;

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);

            Set<String> beginSet = new HashSet<>();
            beginSet.add(beginWord);

            Set<String> endSet = new HashSet<>();
            endSet.add(endWord);
            if (!set.contains(endWord)) {
                return new ArrayList<>();
            }

            set.remove(beginWord);
            set.remove(endWord);
            if (!bfs(beginSet, endSet, set, true)) {
                return new ArrayList<>();
            }

            List<String> list = new ArrayList<>();
            list.add(beginWord);
            dfs(beginWord, endWord, list);

            return res;
        }


        public void dfs(String beginWord, String endWord, List<String> list) {
            if (flag) {
                return;
            }
            if (beginWord.equals(endWord)) {
                res.addAll(list);
                flag = true;
                return;
            }
            Set<String> l = map.get(beginWord);
            if (l == null) {
                return;
            }
            for (String o : l) {
                list.add(o);
                dfs(o, endWord, list);
                list.remove(list.size() - 1);
            }
        }

        public boolean bfs(Set<String> beginSet, Set<String> endSet, Set<String> set, boolean forward) {
            if (match) {
                return true;
            }
            if (beginSet.size() == 0) {
                return false;
            }

            boolean match = false;
            Set<String> newset = new HashSet<>();
            for (String o : beginSet) {

                char[] str = o.toCharArray();
                for (int i = 0; i < str.length; i++) {
                    char tmp = str[i];
                    for (char j = 'a'; j < 'z'; j++) {
                        if (str[i] == j) {
                            continue;
                        }
                        str[i] = j;
                        String temp = String.valueOf(str);
                        if (set.contains(temp) || endSet.contains(temp)) {
                            newset.add(temp);
                            if (forward) {
                                map.computeIfAbsent(o, k -> new HashSet<>()).add(temp);
                            } else {
                                map.computeIfAbsent(temp, k -> new HashSet<>()).add(temp);
                            }
                            if (endSet.contains(temp)) {
                                match = true;
                            }
                        }
                    }
                    str[i] = tmp;
                }
            }
            set.removeAll(newset);
            beginSet = newset;
            if (match) {
                return true;
            }
            if (beginSet.size() > endSet.size()) {
                return bfs(endSet, beginSet, set, !forward);
            } else {
                return bfs(beginSet, endSet, set, forward);
            }
        }
    }

    /**
     * DFS，只不过与当前节点相邻是与之只差一个字母的string
     * 1.先实现一个函数，返回与当前String 只差一个字母的字符串列表。
     * 2.遍历返回的列表中的string：
     * 如果与endword相等，则返回结果。
     * 如果与endword不等，继续dfs
     * 如果已经遍历完当前列表还没找到endword, 说明这个路径不对，删除当前string, 回溯到上一层
     * <p>
     * DFS+回溯
     * <p>
     * 第一次遇到标记不需要回溯
     * <p>
     * 递归终止条件
     * <p>
     * 作者：sangege
     * 链接：https://leetcode-cn.com/problems/word-transformer-lcci/solution/dfshui-su-by-sangege/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution5 {
        List<String> wordList;
        boolean[] marked;
        List<String> output;
        String endWord;
        List<String> result;

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            this.wordList = wordList;
            output = new ArrayList<>();
            marked = new boolean[wordList.size()];
            result = new ArrayList<>();
            this.endWord = endWord;
            dfs(beginWord);
            return result;
        }

        public void dfs(String s) {
            output.add(s);
            Queue<String> queue = oneCharDiff(s);
            for (String str : queue) {
                if (str.equals(endWord)) {
                    output.add(str);
                    result = new ArrayList<>(output);
                    return;
                }
                dfs(str);
                output.remove(output.size() - 1);
            }

        }

        /**
         * 预先处理候选集
         * <p>
         * 返回与当前String 只差一个字母的字符串列表
         *
         * @param s
         * @return
         */
        public Queue<String> oneCharDiff(String s) {
            Queue<String> queue = new LinkedList<>();
            for (int j = 0; j < wordList.size(); j++) {
                String str = wordList.get(j);
                int diffNum = 0;
                if (str.length() != s.length() || marked[j]) {
                    continue;
                }
                for (int i = 0; i < str.length(); i++) {
                    if (diffNum >= 2) {
                        break;
                    }
                    if (str.charAt(i) != s.charAt(i)) {
                        diffNum++;
                    }
                }
                if (diffNum == 1) {
                    queue.add(str);
                    marked[j] = true;
                }
            }
            return queue;
        }
    }

}
