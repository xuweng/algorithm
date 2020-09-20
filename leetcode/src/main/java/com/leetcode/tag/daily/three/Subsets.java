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
     * 集合中每个元素的选和不选，构成了一个满二叉状态树，比如，左子树是不选，右子树是选
     * <p>
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。本质上，其实是比较完整的中序遍历。
     * <p>
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

        /**
         * 神奇的方法
         * <p>
         * 满二叉树
         * <p>
         * 递归树
         * <p>
         * 每个元素选择或者不选择
         *
         * @param cur
         * @param nums
         */
        public void dfs(int cur, int[] nums) {
            //叶子结点就是答案
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

    /**
     * 集合中每个元素的选和不选，构成了一个满二叉状态树，比如，左子树是不选，右子树是选
     * <p>
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。本质上，其实是比较完整的中序遍历。
     * <p>
     * 作者：dao-fa-zi-ran-2
     * 链接：https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class S {
        /**
         * DFS，前序遍历
         */
        public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
            if (i >= nums.length) {
                return;
            }
            // 到了新的状态，记录新的路径，要重新拷贝一份
            subset = new ArrayList<>(subset);

            // 这里
            res.add(subset);
            preOrder(nums, i + 1, subset, res);
            subset.add(nums[i]);
            preOrder(nums, i + 1, subset, res);
        }

        /**
         * DFS，中序遍历
         */
        public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
            if (i >= nums.length) {
                return;
            }
            subset = new ArrayList<>(subset);

            inOrder(nums, i + 1, subset, res);
            subset.add(nums[i]);
            // 这里
            res.add(subset);
            inOrder(nums, i + 1, subset, res);
        }

        /**
         * DFS，后序遍历
         */
        public static void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
            if (i >= nums.length) {
                return;
            }
            subset = new ArrayList<>(subset);

            postOrder(nums, i + 1, subset, res);
            subset.add(nums[i]);
            postOrder(nums, i + 1, subset, res);
            // 这里
            res.add(subset);
        }

    }
}
