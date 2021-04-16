package com.leetcode.tag.must.ten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 */
public class AddToArrayForm {
    /**
     * 方法一：逐位相加 末尾相加
     */
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> res = new ArrayList<>();
            int n = A.length;
            int jin = 0;
            for (int i = n - 1; i >= 0; --i) {
                //末尾相加
                int sum = A[i] + K % 10 + jin;
                K /= 10;
                res.add(sum % 10);
                jin = sum / 10;
            }
            // k有剩余
            while (K > 0) {
                int sum = K % 10 + jin;
                res.add(sum % 10);
                K /= 10;
                jin = sum / 10;
            }
            // 有进位
            if (jin > 0) {
                res.add(jin);
            }

            Collections.reverse(res);
            return res;
        }
    }
}
