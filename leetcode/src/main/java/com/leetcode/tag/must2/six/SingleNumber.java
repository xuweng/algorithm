package com.leetcode.tag.must2.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int ones = 0, twos = 0;
            for (int num : nums) {
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }

    class Solution1 {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            //先把数字存储到map中，其中key存储的是当前数字，value是
            //数字的出现的次数
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            //最后在遍历map中的所有元素，返回value值等于1的
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}
