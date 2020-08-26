package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 */
public class LetterCombinations {
    class Solution {
        public List<String> letterCombinations(String digits) {
            return null;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return combinations;
            }
            //Map<Character, List<String>>
            Map<Character, String> phoneMap = new HashMap<>(32);

            phoneMap.put('2', "abc");
            phoneMap.put('3', "def");
            phoneMap.put('4', "ghi");
            phoneMap.put('5', "jkl");
            phoneMap.put('6', "mno");
            phoneMap.put('7', "pqrs");
            phoneMap.put('8', "tuv");
            phoneMap.put('9', "wxyz");

            backtrack(combinations, phoneMap, digits, 0, "");
            return combinations;
        }

        /**
         * 模板
         *
         * @param combinations
         * @param phoneMap
         * @param digits
         * @param cur
         * @param temp
         */
        public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int cur, String temp) {
            //越界统计
            if (cur == digits.length()) {
                combinations.add(temp);
                return;
            }
            char digit = digits.charAt(cur);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backtrack(combinations, phoneMap, digits, cur + 1, temp + letters.charAt(i));
            }
        }
    }

}
