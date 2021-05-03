package com.leetcode.tag.must2.eight;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 溢出：最大值 / 10, 最值 / 10
 * <p>
 * 负数取模 负数取模 负数取模
 */
public class IsStraight {
    class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> repeat = new HashSet<>();
            int max = 0, min = 14;
            for (int num : nums) {
                if (num == 0) {
                    // 跳过大小王
                    continue;
                }
                // 最大牌
                max = Math.max(max, num);
                // 最小牌
                min = Math.min(min, num);
                if (repeat.contains(num)) {
                    // 除大小王外，所有牌 无重复
                    // 若有重复，提前返回 false
                    return false;
                }
                // 添加此牌至 Set
                repeat.add(num);
            }
            // 最大牌 - 最小牌 < 5 则可构成顺子
            return max - min < 5;
        }
    }

    class Solution1 {
        public boolean isStraight(int[] nums) {
            int joker = 0;
            // 数组排序
            Arrays.sort(nums);
            for (int i = 0; i < 4; i++) {
                if (nums[i] == 0) {
                    // 统计大小王数量
                    joker++;
                } else if (nums[i] == nums[i + 1]) {
                    // 除大小王外，所有牌 无重复
                    // 若有重复，提前返回 false
                    return false;
                }
            }
            return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
        }
    }
}
