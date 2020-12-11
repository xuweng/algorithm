package com.leetcode.tag.daily.six;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 参议院
 * <p>
 * 经典题目 经典题目 经典题目 经典题目 经典题目
 */
public class PredictPartyVictory {
    /**
     * 方法一：「循环」队列
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/dota2-senate/solution/dota2-can-yi-yuan-by-leetcode-solution-jb7l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public String predictPartyVictory(String senate) {
            int n = senate.length();
            Queue<Integer> radiant = new LinkedList<>();
            Queue<Integer> dire = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                if (senate.charAt(i) == 'R') {
                    radiant.offer(i);
                } else {
                    dire.offer(i);
                }
            }
            while (!radiant.isEmpty() && !dire.isEmpty()) {
                int radiantIndex = radiant.poll(), direIndex = dire.poll();
                if (radiantIndex < direIndex) {
                    radiant.offer(radiantIndex + n);
                } else {
                    dire.offer(direIndex + n);
                }
            }
            return !radiant.isEmpty() ? "Radiant" : "Dire";
        }
    }

}
