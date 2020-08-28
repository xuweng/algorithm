package com.leetcode.tag.daily.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 657. 机器人能否返回原点
 */
public class JudgeCircle {
    class Solution {
        public boolean judgeCircle(String moves) {
            if (moves == null) {
                return false;
            }

            Map<Character, Integer> map = new HashMap<>(32);

            for (int i = 0; i < moves.length(); i++) {
                map.put(moves.charAt(i), map.getOrDefault(moves.charAt(i), 0) + 1);
            }
            boolean result = false;
            if (map.containsKey('R') || map.containsKey('L')) {
                result = Objects.equals(map.getOrDefault('R', -1), map.getOrDefault('L', -2));
            }
            if (map.containsKey('U') || map.containsKey('D')) {
                result = result || Objects.equals(map.getOrDefault('U', -1), map.getOrDefault('D', -2));
            }

            return result;
        }
    }

    /**
     * 方法一： 模拟
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/robot-return-to-origin/solution/ji-qi-ren-neng-fou-fan-hui-yuan-dian-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean judgeCircle(String moves) {
            int x = 0, y = 0;
            int length = moves.length();
            for (int i = 0; i < length; i++) {
                char move = moves.charAt(i);
                if (move == 'U') {
                    y++;
                } else if (move == 'D') {
                    y--;
                } else if (move == 'L') {
                    x--;
                } else if (move == 'R') {
                    x++;
                }
            }
            return x == 0 && y == 0;
        }
    }

}
