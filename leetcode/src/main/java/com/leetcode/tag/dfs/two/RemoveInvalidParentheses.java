package com.leetcode.tag.dfs.two;

import java.util.*;

/**
 * 301. 删除无效的括号
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.
 * <p>
 * 经典题目.经典题目.经典题目.经典题目.
 * <p>
 * 递增递归.
 * <p>
 * 十分钟.十分钟.十分钟.十分钟.十分钟.十分钟
 * <p>
 * 经典题目.经典题目.经典题目
 */
public class RemoveInvalidParentheses {
    /**
     * 回到我们的问题上来，现在出现的问题是，如何决定要删除哪些括号？
     * <p>
     * 因为我们不知道哪一个括号可能被删除，所以我们尝试了所有的选项！
     * <p>
     * 对于每个括号，我们有两个选择：
     * <p>
     * 它可以被视为最终表达式的一部分(不删)
     * 它可以被忽略，也就是说，我们可以从最终表达式中删除它。(删除)
     * 这样的问题，我们有多个选择，我们没有战略或指标来贪婪地决定选择哪一个选择，我们尝试了所有的选择，看看哪一个导致了答案。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/shan-chu-wu-xiao-de-gua-hao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        private final Set<String> validExpressions = new HashSet<>();
        // 删除的最小数量
        private int minimumRemoved;

        private void reset() {
            this.validExpressions.clear();
            this.minimumRemoved = Integer.MAX_VALUE;
        }

        /**
         * 对当前字符分类讨论
         *
         * @param s
         * @param index        索引
         * @param leftCount    表示我们到目前为止添加到表达式中的左括号的数目
         * @param rightCount   表示我们到目前为止添加到表达式中的右括号的数目
         * @param expression   正确的表达式
         * @param removedCount 删除括号的数量
         */
        private void recurse(
                String s,
                int index,
                int leftCount,
                int rightCount,
                StringBuilder expression,
                int removedCount) {
            // 终止条件
            // If we have reached the end of string.
            if (index == s.length()) {
                // 表达式正确
                // If the current expression is valid.
                if (leftCount == rightCount) {
                    // If the current count of removed parentheses is <= the current minimum count
                    if (removedCount <= this.minimumRemoved) {
                        // 答案
                        // Convert StringBuilder to a String. This is an expensive operation.
                        // So we only perform this when needed.
                        String possibleAnswer = expression.toString();
                        // If the current count beats the overall minimum we have till now
                        if (removedCount < this.minimumRemoved) {
                            // 清空
                            this.validExpressions.clear();
                            // 删除的最小数量
                            this.minimumRemoved = removedCount;
                        }
                        this.validExpressions.add(possibleAnswer);
                    }
                }
                return;
            }
            // 当前字符
            char currentCharacter = s.charAt(index);
            int length = expression.length();
            // If the current character is neither an opening bracket nor a closing one,
            // simply recurse further by adding it to the expression StringBuilder
            if (currentCharacter != '(' && currentCharacter != ')') {
                // 普通字符
                // 直接添加到表达式
                expression.append(currentCharacter);
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            } else {
                // '(' 或者 ')'
                // Recursion where we delete the current character and move forward
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                expression.append(currentCharacter);
                // If it's an opening parenthesis, consider it and recurse
                if (currentCharacter == '(') {
                    // 左括号数量加1
                    this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    // 右括号数量加1
                    // For a closing parenthesis, only recurse if right < left
                    this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }
                // Undoing the append operation for other recursions.
                expression.deleteCharAt(length);
            }
        }

        public List<String> removeInvalidParentheses(String s) {
            this.reset();
            this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
            return new ArrayList<>(this.validExpressions);
        }
    }

    /**
     * BFS
     * <p>
     * 利用BFS理解起来要远远比DFS要简单的多，因为这道题说的是删除最少的括号！！，
     * <p>
     * 如果我们每次只删除一个括号，然后观察被删除一个括号后是否合法，如果已经合法了，
     * <p>
     * 我们就不用继续删除了啊。因此我们并不需要将遍历进行到底，而是层层深入，一旦达到需求，就不再深入了。
     * <p>
     * 作者：allen-238
     * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/bfsjian-dan-er-you-xiang-xi-de-pythonjiang-jie-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                res.add("");
                return res;
            }
            Deque<String> queue = new LinkedList<>();
            HashMap<String, Boolean> help = new HashMap<>();
            queue.offer(s);
            while (!queue.isEmpty()) {
                for (String str : queue) {
                    if (isValid(str)) {
                        // 合法
                        if (!help.containsKey(str)) {
                            res.add(str);
                        }
                        help.put(str, true);
                    }
                }
                if (!res.isEmpty()) {
                    // 满足最小删除直接返回
                    return res;
                }
                for (int k = queue.size(); k > 0; k--) {
                    String str = queue.poll();
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                            // 删除第i个数据
                            // 添加删除后的字符串
                            queue.offer(str.substring(0, i) + str.substring(i + 1));
                        }
                    }
                }
            }
            res.add("");
            return res;
        }

        /**
         * 是否是正确的表达式
         * <p>
         * 厉害
         *
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    count++;
                }
                if (s.charAt(i) == ')') {
                    count--;
                }
                if (count < 0) {
                    return false;
                }
            }
            return count == 0;
        }
    }
}
