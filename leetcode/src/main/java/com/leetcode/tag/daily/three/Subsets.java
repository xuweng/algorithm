package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(nums, 0, result, stack);

            return result;
        }

        private void back(int[] nums, int begin, List<List<Integer>> result, Deque<Integer> stack) {
            result.add(new ArrayList<>(stack));

            for (int i = begin; i < nums.length; i++) {
                stack.push(nums[i]);
                back(nums, i + 1, result, stack);
                stack.pop();
            }
        }
    }

    /**
     * 方法一：迭代法实现子集枚举
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<>(t));
            }
            return ans;
        }
    }

    /**
     * 方法二：递归法实现子集枚举
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<>(t));
                return;
            }
            // 考虑选择当前位置
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            // 考虑不选择当前位置
            dfs(cur + 1, nums);
        }
    }

}
