package com.leetcode.tag.contest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 5499. 重复至少 K 次且长度为 M 的模式
 * <p>
 * 模式 是由一个或多个值组成的子数组（连续的子序列）
 * <p>
 * 搞懂题目。搞懂题目。
 */
public class ContainsPattern {
    class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            if (arr == null || arr.length == 0) {
                return false;
            }
            Map<String, Integer> map = new HashMap<>(64);
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < arr.length; j++) {
                    String str = string(arr, i, j);
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            AtomicBoolean result = new AtomicBoolean(false);
            map.forEach((key, value) -> {
                if (key.length() == m && value >= k) {
                    result.set(true);
                }
            });

            return result.get();

        }

        private String string(int[] arr, int start, int end) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = start; i <= end; i++) {
                stringBuilder.append(arr[i]);
            }

            return stringBuilder.toString();
        }
    }
}
