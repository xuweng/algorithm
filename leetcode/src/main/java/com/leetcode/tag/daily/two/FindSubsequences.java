package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * <p>
 * 不再盲目做题就是一种进步
 * <p>
 * 分析。
 */
public class FindSubsequences {
    /**
     * 假设n-1解决,推导n?这样推到太麻烦。
     */
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            return null;
        }
    }

    /**
     * 总感觉可以用回溯
     * <p>
     * 回溯可以脑海风暴
     */
    class Solution1 {
        public List<List<Integer>> findSubsequences(int[] nums) {
            return null;
        }
    }

    /**
     * 方法一：二进制枚举 + 哈希
     * <p>
     * 可以采取最朴素的思路，即枚举出所有的子序列，然后判断当前的子序列是否是非严格递增的
     * <p>
     * 这个很常用。枚举所有，然后再判断.
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/increasing-subsequences/solution/di-zeng-zi-xu-lie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        //使用set保存哈希值
        Set<Integer> set = new HashSet<>();
        int n;

        /**
         * 由此可见长度为 n 的序列选择子序列一共会有 2^n种情况，这 2^n中情况就是区间 [0， 2^{n - 1}]的所有整数的二进制表示。
         * <p>
         * 我们可以枚举区间 [0， 2^{n - 1}]中的每一个数
         * <p>
         * 我们还需要解决子序列去重的问题。对于序列去重，我们可以使用串哈希算法
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> findSubsequences(int[] nums) {
            n = nums.length;
            for (int i = 0; i < (1 << n); ++i) {
                findSubsequences(i, nums);
                int hashValue = getHash(263, (int) 1E9 + 7);
                if (check() && !set.contains(hashValue)) {
                    ans.add(new ArrayList<>(temp));
                    set.add(hashValue);
                }
            }
            return ans;
        }

        /**
         * 子序列
         *
         * @param mask
         * @param nums
         */
        public void findSubsequences(int mask, int[] nums) {
            temp.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & 1) != 0) {
                    temp.add(nums[i]);
                }
                mask >>= 1;
            }
        }

        /**
         * hash函数
         * <p>
         * 去重
         *
         * @param base
         * @param mod
         * @return
         */
        public int getHash(int base, int mod) {
            int hashValue = 0;
            for (int x : temp) {
                hashValue = hashValue * base % mod + (x + 101);
                hashValue %= mod;
            }
            return hashValue;
        }

        public boolean check() {
            for (int i = 1; i < temp.size(); ++i) {
                if (temp.get(i) < temp.get(i - 1)) {
                    return false;
                }
            }
            return temp.size() >= 2;
        }
    }

    /**
     * 方法二：递归枚举 + 减枝
     */
    class Solution3 {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(0, Integer.MIN_VALUE, nums);
            return ans;
        }

        /**
         * 通用模板
         * <p>
         * 讲清楚。讲清楚。讲清楚。讲清楚。讲清楚。
         * <p>
         * 讲清楚。讲清楚。讲清楚
         * <p>
         * 使用  cur 来表示当前位置的下标，在 dfs(cur, nums) 开始之前，[0,cur−1] 这个区间内的所有元素都已经被考虑过，
         * <p>
         * 而 [cur,n] 这个区间内的元素还未被考虑
         * <p>
         * 考虑 cur 这个位置选或者不选.如果选择当前元素，那么把当前元素加入到 temp 中，然后递归下一个位置
         * <p>
         * 结合二叉树。回溯？从最底层开始回溯。
         * <p>
         * 如果不选当前的元素，直接递归下一个位置
         *
         * @param cur
         * @param last
         * @param nums
         */
        public void dfs(int cur, int last, int[] nums) {
            //越界是一个答案
            //结合二叉树。从底层回溯。每次到底都是答案。
            if (cur == nums.length) {
                if (temp.size() >= 2) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }
            //使序列合法的办法非常简单
            if (nums[cur] >= last) {
                //选择当前元素
                temp.add(nums[cur]);
                dfs(cur + 1, nums[cur], nums);
                temp.remove(temp.size() - 1);
            }
            //保证没有重复
            if (nums[cur] != last) {
                //跳过当前元素
                dfs(cur + 1, last, nums);
            }
        }
    }

    class S {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
                if (isVSalid() && notVisited()) {
                    ans.add(new ArrayList<>(temp));
                }
                return;
            }
            // 如果选择当前元素
            temp.add(nums[cur]);
            dfs(cur + 1, nums);
            temp.remove(temp.size() - 1);
            // 如果不选择当前元素
            dfs(cur + 1, nums);
        }

        private boolean isVSalid() {
            return true;
        }

        private boolean notVisited() {
            return true;
        }
    }

}
