package com.leetcode.tag.daily.five;

import java.util.*;

/**
 * 621. 任务调度器
 * <p>
 * 贪心算法
 * <p>
 * 题感 题感 题感 题感 题感 题感 题感 题感 题感 题感 题感 题感
 */
public class LeastInterval {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode-solution-ur9w/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char ch : tasks) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

            // 任务总数
            int m = freq.size();
            List<Integer> nextValid = new ArrayList<>();
            List<Integer> rest = new ArrayList<>();
            Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                int value = entry.getValue();
                nextValid.add(1);
                rest.add(value);
            }

            int time = 0;
            for (int i = 0; i < tasks.length; ++i) {
                ++time;
                int minNextValid = Integer.MAX_VALUE;
                for (int j = 0; j < m; ++j) {
                    if (rest.get(j) != 0) {
                        minNextValid = Math.min(minNextValid, nextValid.get(j));
                    }
                }
                time = Math.max(time, minNextValid);
                int best = -1;
                for (int j = 0; j < m; ++j) {
                    if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                        if (best == -1 || rest.get(j) > rest.get(best)) {
                            best = j;
                        }
                    }
                }
                nextValid.set(best, time + n + 1);
                rest.set(best, rest.get(best) - 1);
            }

            return time;
        }
    }

    /**
     * 方法二：构造
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode-solution-ur9w/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> freq = new HashMap<>();
            // 最多的执行次数
            int maxExec = 0;
            for (char ch : tasks) {
                int exec = freq.getOrDefault(ch, 0) + 1;
                freq.put(ch, exec);
                maxExec = Math.max(maxExec, exec);
            }

            // 具有最多执行次数的任务数量
            int maxCount = 0;
            Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                int value = entry.getValue();
                if (value == maxExec) {
                    ++maxCount;
                }
            }

            return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
        }
    }

}
