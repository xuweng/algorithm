package com.leetcode.tag.daily;

import java.util.*;

/**
 * 336. 回文对
 * <p>
 * 没什么思路。
 * <p>
 * 没什么思路。
 * <p>
 * 没什么思路。
 * <p>
 * 没什么思路。没什么思路。没什么思路。没什么思路。没什么思路。
 * <p>
 * 没什么思路。没什么思路。
 * <p>
 * 穷举。穷举。穷举。
 * <p>
 * 穷举不是最优解。穷举不是最优解。穷举不是最优解。
 */
public class PalindromePairs {
    class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            return null;
        }
    }

    /**
     * 方法一：枚举前缀和后缀
     * <p>
     * 使用字典树
     * <p>
     * 思路及算法
     * <p>假设s1+s2是一个回文串。
     * <p>
     * 这类题目看答案。看答案。看答案。看答案。看答案。看答案。看答案。看答案。看答案。看答案。
     * <p>
     * 具体地说，我们枚举每一个字符串 k
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        class Node {
            int[] ch = new int[26];
            int flag;

            public Node() {
                flag = -1;
            }
        }

        List<Node> tree = new ArrayList<Node>();

        public List<List<Integer>> palindromePairs(String[] words) {
            tree.add(new Node());
            int n = words.length;
            for (int i = 0; i < n; i++) {
                insert(words[i], i);
            }
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) {
                int m = words[i].length();
                for (int j = 0; j <= m; j++) {
                    if (isPalindrome(words[i], j, m - 1)) {
                        int leftId = findWord(words[i], 0, j - 1);
                        if (leftId != -1 && leftId != i) {
                            ret.add(Arrays.asList(i, leftId));
                        }
                    }
                    if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                        int rightId = findWord(words[i], j, m - 1);
                        if (rightId != -1 && rightId != i) {
                            ret.add(Arrays.asList(rightId, i));
                        }
                    }
                }
            }
            return ret;
        }

        public void insert(String s, int id) {
            int len = s.length(), add = 0;
            for (int i = 0; i < len; i++) {
                int x = s.charAt(i) - 'a';
                if (tree.get(add).ch[x] == 0) {
                    tree.add(new Node());
                    tree.get(add).ch[x] = tree.size() - 1;
                }
                add = tree.get(add).ch[x];
            }
            tree.get(add).flag = id;
        }

        public boolean isPalindrome(String s, int left, int right) {
            int len = right - left + 1;
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(left + i) != s.charAt(right - i)) {
                    return false;
                }
            }
            return true;
        }

        public int findWord(String s, int left, int right) {
            int add = 0;
            for (int i = right; i >= left; i--) {
                int x = s.charAt(i) - 'a';
                if (tree.get(add).ch[x] == 0) {
                    return -1;
                }
                add = tree.get(add).ch[x];
            }
            return tree.get(add).flag;
        }
    }

    /**
     * 使用哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        List<String> wordsRev = new ArrayList<String>();
        Map<String, Integer> indices = new HashMap<String, Integer>();

        public List<List<Integer>> palindromePairs(String[] words) {
            int n = words.length;
            for (String word : words) {
                wordsRev.add(new StringBuffer(word).reverse().toString());
            }
            for (int i = 0; i < n; ++i) {
                indices.put(wordsRev.get(i), i);
            }

            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) {
                String word = words[i];
                int m = words[i].length();
                if (m == 0) {
                    continue;
                }
                for (int j = 0; j <= m; j++) {
                    if (isPalindrome(word, j, m - 1)) {
                        int leftId = findWord(word, 0, j - 1);
                        if (leftId != -1 && leftId != i) {
                            ret.add(Arrays.asList(i, leftId));
                        }
                    }
                    if (j != 0 && isPalindrome(word, 0, j - 1)) {
                        int rightId = findWord(word, j, m - 1);
                        if (rightId != -1 && rightId != i) {
                            ret.add(Arrays.asList(rightId, i));
                        }
                    }
                }
            }
            return ret;
        }

        public boolean isPalindrome(String s, int left, int right) {
            int len = right - left + 1;
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(left + i) != s.charAt(right - i)) {
                    return false;
                }
            }
            return true;
        }

        public int findWord(String s, int left, int right) {
            return indices.getOrDefault(s.substring(left, right + 1), -1);
        }
    }


}
