package com.leetcode.tag.contest.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 5737. 所有数对按位与结果的异或和
 */
public class GetXORSum {
    class Solution {
        public int getXORSum(int[] arr1, int[] arr2) {
            List<Integer> list = new ArrayList<>();
            for (int i : arr1) {
                for (int j : arr2) {
                    list.add(i & j);
                }
            }

            int result = 0;
            for (Integer i : list) {
                result = result ^ i;
            }

            return result;
        }
    }
}
