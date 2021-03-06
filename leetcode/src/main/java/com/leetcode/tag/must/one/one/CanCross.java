package com.leetcode.tag.must.one.one;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 403. 青蛙过河
 */
public class CanCross {
    /**
     * 不能计数i-j，不能判断后部分，只能从0到j推导，只能判断前部分
     * <p>
     * 方法五 动态规划 【通过】
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/frog-jump/solution/qing-wa-guo-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean canCross(int[] stones) {
            // key是石头 value是跳到石头的步数
            HashMap<Integer, Set<Integer>> map = new HashMap<>();
            for (int stone : stones) {
                map.put(stone, new HashSet<>());
            }
            map.get(0).add(0);
            for (int stone : stones) {
                // 枚举跳到stone的步数
                for (int k : map.get(stone)) {
                    // 枚举stone可以跳到下一个石头的位置
                    for (int step = k - 1; step <= k + 1; step++) {
                        if (step > 0 && map.containsKey(stone + step)) {
                            // 存在stone + step这个石头
                            // 跳到stone + step这个石头的步数是step
                            // 可以有多个石头跳到stone + step，用set去重
                            map.get(stone + step).add(step);
                        }
                    }
                }
            }
            return map.get(stones[stones.length - 1]).size() > 0;
        }
    }

}
