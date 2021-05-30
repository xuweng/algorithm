package com.leetcode.tag.contest.seven;

import java.util.Arrays;
import java.util.Collections;

/**
 * 5773. 插入后的最大值
 */
public class MaxValue {
    class Solution {
        public String maxValue(String n, int x) {
            char[] chars = n.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            boolean is = true;
            if (chars[0] == '-') {
                stringBuilder.append('-');
                Arrays.sort(chars);
                for (int i = 1, charsLength = chars.length; i < charsLength; i++) {
                    char aChar = chars[i];
                    if (Integer.parseInt(String.valueOf(aChar)) < x) {
                        stringBuilder.append(aChar);
                    } else {
                        if (is) {
                            stringBuilder.append(x);
                            is = false;
                        }
                        stringBuilder.append(aChar);
                    }
                }

                return stringBuilder.toString();
            }
            Character[] characters = new Character[chars.length];
            for (int i = 0; i < chars.length; i++) {
                characters[i] = chars[i];
            }
            Arrays.sort(characters, Collections.reverseOrder());

            for (Character character : characters) {
                if (Integer.parseInt(String.valueOf(character)) > x) {
                    stringBuilder.append(character);
                } else {
                    if (is) {
                        stringBuilder.append(x);
                        is = false;
                    }
                    stringBuilder.append(character);
                }
            }

            return stringBuilder.toString();
        }
    }
}
