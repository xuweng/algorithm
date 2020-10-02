package com.leetcode.tag.daily.three;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 */
public class NumJewelsInStones {
    static class Solution {
        public int numJewelsInStones(String J, String S) {
            //默认为false
            boolean[] Jb = new boolean[100];
            int sum = 0;
            for (char c : J.toCharArray()) {
                Jb[c - '0'] = true;
            }
            for (char c : S.toCharArray()) {
                if (Jb[c - '0']) {
                    sum++;
                }
            }
            return sum;
        }
    }

    /**
     * 方法一：暴力
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jewels-and-stones/solution/bao-shi-yu-shi-tou-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int numJewelsInStones(String J, String S) {
            int jewelsCount = 0;
            int jewelsLength = J.length(), stonesLength = S.length();
            for (int i = 0; i < stonesLength; i++) {
                char stone = S.charAt(i);
                for (int j = 0; j < jewelsLength; j++) {
                    char jewel = J.charAt(j);
                    if (stone == jewel) {
                        jewelsCount++;
                        break;
                    }
                }
            }
            return jewelsCount;
        }
    }

    /**
     * 方法二：哈希集合
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jewels-and-stones/solution/bao-shi-yu-shi-tou-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int numJewelsInStones(String J, String S) {
            int jewelsCount = 0;
            Set<Character> jewelsSet = new HashSet<>();
            int jewelsLength = J.length(), stonesLength = S.length();
            for (int i = 0; i < jewelsLength; i++) {
                char jewel = J.charAt(i);
                jewelsSet.add(jewel);
            }
            for (int i = 0; i < stonesLength; i++) {
                char stone = S.charAt(i);
                if (jewelsSet.contains(stone)) {
                    jewelsCount++;
                }
            }
            return jewelsCount;
        }
    }

}
