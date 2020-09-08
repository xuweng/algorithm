package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
                ans.add(new ArrayList<Integer>(temp));
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

}
