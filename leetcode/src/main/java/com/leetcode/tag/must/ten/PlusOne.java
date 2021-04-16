package com.leetcode.tag.must.ten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 66. 加一
 */
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            boolean first = true;
            int jin = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = digits.length - 1; i >= 0; i--) {
                int sum = first ? digits[i] + 1 + jin : digits[i] + jin;
                first = false;

                result.add(sum % 10);
                jin = sum / 10;
            }
            if (jin > 0) {
                // 最后有进位
                result.add(jin);
            }
            Collections.reverse(result);

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
