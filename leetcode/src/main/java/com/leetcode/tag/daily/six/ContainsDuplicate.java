package com.leetcode.tag.daily.six;

import java.util.*;

/**
 * 217. 存在重复元素
 */
public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (map.get(num) > 1) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * 方法一：排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 方法二：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/solution/cun-zai-zhong-fu-yuan-su-by-leetcode-sol-iedd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                if (!set.add(x)) {
                    return true;
                }
            }
            return false;
        }
    }


}
