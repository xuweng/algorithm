package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 679. 24 点游戏
 * <p>
 * 这道题没意思
 * <p>
 * 没意思。没意思。没意思。没意思。没意思。没意思。没意思。没意思
 * <p>
 * 可以通过回溯的方法遍历所有不同的可能性
 */
public class JudgePoint24 {
    class Solution {
        public boolean judgePoint24(int[] nums) {
            return true;
        }
    }

    /**
     * 方法一：回溯
     * <p>
     * 因此，一共有 12×4×6×4×2×4=9216 种不同的可能性。
     * <p>
     * 时间复杂度：O(1)
     * <p>
     * 时间复杂度：O(1)。一共有216 种可能性，对于每种可能性，各项操作的时间复杂度都是 O(1)，因此总时间复杂度是 O(1)。
     *
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/24-game/solution/24-dian-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        static final int TARGET = 24;
        static final double EPSILON = 1e-6;
        static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

        public boolean judgePoint24(int[] nums) {
            List<Double> list = Arrays.stream(nums).mapToObj(num -> (double) num).collect(Collectors.toList());

            return solve(list);
        }

        public boolean solve(List<Double> list) {
            if (list.size() == 0) {
                return false;
            }
            if (list.size() == 1) {
                return Math.abs(list.get(0) - TARGET) < EPSILON;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i != j) {
                        List<Double> list2 = new ArrayList<>();
                        for (int k = 0; k < size; k++) {
                            if (k != i && k != j) {
                                list2.add(list.get(k));
                            }
                        }
                        for (int k = 0; k < 4; k++) {
                            if (k < 2 && i > j) {
                                continue;
                            }
                            if (k == ADD) {
                                list2.add(list.get(i) + list.get(j));
                            } else if (k == MULTIPLY) {
                                list2.add(list.get(i) * list.get(j));
                            } else if (k == SUBTRACT) {
                                list2.add(list.get(i) - list.get(j));
                            } else {
                                if (Math.abs(list.get(j)) < EPSILON) {
                                    continue;
                                } else {
                                    list2.add(list.get(i) / list.get(j));
                                }
                            }
                            if (solve(list2)) {
                                return true;
                            }
                            list2.remove(list2.size() - 1);
                        }
                    }
                }
            }
            return false;
        }
    }

}
