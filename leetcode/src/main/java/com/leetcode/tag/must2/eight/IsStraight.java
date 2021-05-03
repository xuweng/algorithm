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
 * <p>
 * 判断重复
 */
public class IsStraight {
    /**
     * 方法一： 集合 Set + 遍历
     */
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

    /**
     * 方法二：排序 + 遍历
     */
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

    /**
     * 1.假如没有大小王的情况下，只需要这5个数字不能有重复的，并且这5个数字中的最大值减去最小值等于4就行了。类似于[a,a+1,a+2,a+3,a+4]。
     * <p>
     * 2.假如有大小王的情况下，无论有一个还是有两个，我们只需要让大小王替换上面数组[a,a+1,a+2,a+3,a+4]中的任意元素，
     * <p>
     * 也能构成顺子。比如替换a,类似于[0，a+1,a+2,a+3,a+4]，那么这个数组中的最大值减去最小值就是3了。
     * <p>
     * 所以我们可以得出结论
     * <p>
     * 只要数组中的最大值减去最小值小于等于4
     * 数组中的元素除了大小王不能有重复的
     */
    class Solution2 {
        public boolean isStraight(int[] nums) {
            //先对数组进行排序
            Arrays.sort(nums);
            //记录大小王的数量
            int zero = 0;
            for (int i = 0; i < 4; i++) {
                //统计大小王的数量
                if (nums[i] == 0) {
                    zero++;
                    continue;
                }
                //如果不是大小王，不能有重复的
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
            }
            //最大牌和最小牌的差值小于5（这里zero是大小王是数量，
            // nums[zero]表示排序后第一个非大小王的牌）
            return nums[nums.length - 1] - nums[zero] < 5;
        }
    }
}
