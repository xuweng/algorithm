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
        Set<Integer> set = new HashSet<>();
        int n;

        public List<List<Integer>> findSubsequences(int[] nums) {
            n = nums.length;
            for (int i = 0; i < (1 << n); ++i) {
                findSubsequences(i, nums);
                int hashValue = getHash(263, (int) 1E9 + 7);
                if (check() && !set.contains(hashValue)) {
                    ans.add(new ArrayList<Integer>(temp));
                    set.add(hashValue);
                }
            }
            return ans;
        }

        public void findSubsequences(int mask, int[] nums) {
            temp.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & 1) != 0) {
                    temp.add(nums[i]);
                }
                mask >>= 1;
            }
        }

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

}
