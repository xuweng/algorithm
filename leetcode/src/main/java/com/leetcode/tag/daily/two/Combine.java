package com.leetcode.tag.daily.two;

import java.util.*;

/**
 * 77. 组合
 */
public class Combine {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            back(n, 1, k, stack, result);

            return result;
        }

        private void back(int n, int start, int k, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == k) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i <= n; i++) {
                stack.push(i);
                back(n, i + 1, k, stack, result);
                stack.pop();
            }
        }
    }

    /**
     * 方法一：递归实现组合型枚举
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
        }

        public void dfs(int cur, int n, int k) {
            // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
            if (temp.size() + (n - cur + 1) < k) {
                return;
            }
            // 记录合法的答案
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            // 考虑选择当前位置
            temp.add(cur);
            dfs(cur + 1, n, k);
            temp.remove(temp.size() - 1);
            // 考虑不选择当前位置
            dfs(cur + 1, n, k);
        }
    }

    /**
     * 方法二：非递归（字典序法）实现组合型枚举
     * <p>
     * 原序列中被选中的位置记为 1，不被选中的位置记为 0，对于每个方案都可以构造出一个二进制数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            List<Integer> temp = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            // 初始化
            // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
            // 末尾加一位 n + 1 作为哨兵
            for (int i = 1; i <= k; ++i) {
                temp.add(i);
            }
            temp.add(n + 1);

            int j = 0;
            while (j < k) {
                ans.add(new ArrayList<>(temp.subList(0, k)));
                j = 0;
                // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
                // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
                while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                    temp.set(j, j + 1);
                    ++j;
                }
                // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
                temp.set(j, temp.get(j) + 1);
            }
            return ans;
        }
    }

    /**
     * 官方
     */
    class Solution3 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }
            // 从 1 开始是题目的设定
            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, res);
            return res;
        }

        private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
            // 递归终止条件是：path 的长度等于 k
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 遍历可能的搜索起点
            for (int i = begin; i <= n; i++) {
                // 向路径变量里添加一个数
                path.addLast(i);
                // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
                dfs(n, k, i + 1, path, res);
                // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
                path.removeLast();
            }
        }
    }

}
