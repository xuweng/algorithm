package com.leetcode.tag.daily.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 */
public class SplitIntoFibonacci {
    /**
     * 方法一：回溯 + 剪枝
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/jiang-shu-zu-chai-fen-cheng-fei-bo-na-qi-ts6c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> list = new ArrayList<>();
            backtrack(list, S, S.length(), 0, 0, 0);
            return list;
        }

        public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
            if (index == length) {
                return list.size() >= 3;
            }
            long currLong = 0;
            for (int i = index; i < length; i++) {
                if (i > index && S.charAt(index) == '0') {
                    break;
                }
                currLong = currLong * 10 + S.charAt(i) - '0';
                if (currLong > Integer.MAX_VALUE) {
                    break;
                }
                int curr = (int) currLong;
                if (list.size() >= 2) {
                    if (curr < sum) {
                        continue;
                    } else if (curr > sum) {
                        break;
                    }
                }
                list.add(curr);
                if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
            return false;
        }
    }

}
