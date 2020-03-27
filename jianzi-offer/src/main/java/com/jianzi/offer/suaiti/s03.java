package com.jianzi.offer.suaiti;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 面试题03. 数组中重复的数字
 */
public class s03 {
    public int findRepeatNumber(int[] nums) {
        AtomicInteger result = new AtomicInteger();
        if (nums.length <= 0) {
            return result.get();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        map.forEach((k, v) -> {
            if (v > 1) {
                result.set(k);
            }
        });
        return result.get();
    }
}
