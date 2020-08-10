package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 * <p>
 * 这类题学不到什么东西。这类题学不到什么东西。
 * <p>
 * 十分钟看答案。十分钟看答案。十分钟看答案。十分钟看答案。
 * <p>
 * 算法模板。算法模板。算法模板。
 */
public class CountBinarySubstrings {
    class Solution {
        public int countBinarySubstrings(String s) {
            return 0;
        }
    }

    /**
     * 想不到的。
     * <p>
     * 看答案。
     * <p>
     * 看答案。看答案。看答案。看答案。看答案。看答案。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings/solution/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 这里 counts 数组中两个相邻的数一定代表的是两种不同的字符。假设counts 数组中两个相邻的数字为 u 或者 v，
         * <p>
         * 它们对应着 u 个 0 和 v 个 1，或者 u 个 1 和 v 个 0。它们能组成的满足条件的子串数目为 min{u,v}，即一对相邻的数字对答案的贡献。
         *
         * @param s
         * @return
         */
        public int countBinarySubstrings(String s) {
            List<Integer> counts = new ArrayList<>();
            int ptr = 0, n = s.length();
            while (ptr < n) {
                char c = s.charAt(ptr);
                int count = 0;
                while (ptr < n && s.charAt(ptr) == c) {
                    ++ptr;
                    ++count;
                }
                counts.add(count);
            }
            int ans = 0;
            for (int i = 1; i < counts.size(); ++i) {
                ans += Math.min(counts.get(i), counts.get(i - 1));
            }
            return ans;
        }
    }

}
