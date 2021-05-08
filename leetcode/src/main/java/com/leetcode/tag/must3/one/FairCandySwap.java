package com.leetcode.tag.must3.one;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 888. 公平的糖果棒交换
 * <p>
 * 并查集 环 连通分量
 * <p>
 * 滑动窗口 固定长度
 * <p>
 * 哨兵 合并
 */
public class FairCandySwap {
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            // sumA-a+b=sumB-b+a
            // sumA-sumB=2a-2b
            // (sumA-sumB)/2=a-b
            int sumA = Arrays.stream(A).sum();
            int sumB = Arrays.stream(B).sum();
            int cha = (sumA - sumB) / 2;
            Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());

            for (int b : B) {
                int a = b + cha;
                if (set.contains(a)) {
                    return new int[]{a, b};
                }
            }

            return A;
        }
    }
}
