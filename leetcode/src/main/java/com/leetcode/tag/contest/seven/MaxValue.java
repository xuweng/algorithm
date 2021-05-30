package com.leetcode.tag.contest.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 5773. 插入后的最大值
 */
public class MaxValue {
    class Solution {
        public String maxValue(String n, int x) {
            char[] chars = n.toCharArray();
            List<String> list1 = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n);
            if (chars[0] == '-') {
                stringBuilder.deleteCharAt(0);
                for (int i = 0; i < chars.length; i++) {
                    stringBuilder.insert(i, x);
                    list1.add(stringBuilder.toString());
                    stringBuilder.deleteCharAt(i);
                }
                Collections.sort(list1);

                return "-" + list1.get(0);
            }

            for (int i = 0; i <= chars.length; i++) {
                stringBuilder.insert(i, x);
                list1.add(stringBuilder.toString());
                stringBuilder.deleteCharAt(i);
            }
            Collections.sort(list1);

            return list1.get(list1.size() - 1);
        }
    }
}
