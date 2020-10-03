package com.leetcode.tag.daily.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{
                            map.get(target - nums[i]), i
                    };
                } else {
                    map.put(nums[i], i);
                }
            }

            return null;
        }
    }

    /**
     * 方法一：暴力枚举
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }

    /**
     * 方法二：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }
    }

    /**
     * 与运算
     */
    class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            int volume = 2 << 10; //2的10次方
            int bitNum = volume - 1; //11111111111
            int[] res = new int[volume];
            for (int i = 0; i < nums.length; i++) {
                int c = (target - nums[i]) & bitNum;
                if (res[c] != 0) {
                    return new int[]{res[c] - 1, i};
                }
                res[nums[i] & bitNum] = i + 1;
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }


}
