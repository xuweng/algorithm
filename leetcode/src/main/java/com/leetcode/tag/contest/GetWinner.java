package com.leetcode.tag.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * 5476. 找出数组游戏的赢家
 */
public class GetWinner {
    /**
     * 找规律。找规律。找规律。找规律。
     */
    class Solution {
        public int getWinner(int[] arr, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int result = 0;
            while (count < k) {
                int c = 0;
                if (arr[0] > arr[1]) {
                    map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
                    c = map.getOrDefault(arr[0], 0);
                    if (c >= k) {
                        result = arr[0];
                        break;
                    }
                    moveArr(arr, 2);
                    arr[arr.length - 1] = arr[1];
                } else {
                    map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
                    c = map.getOrDefault(arr[1], 0);
                    if (c >= k) {
                        result = arr[1];
                        break;
                    }
                    moveArr(arr, 1);
                    arr[arr.length - 1] = arr[0];
                }
                if (c > count) {
                    count = c;
                }
            }

            return result;
        }

        private void moveArr(int[] arr, int i) {
            System.arraycopy(arr, i, arr, i - 1, arr.length - i);
        }
    }
}
