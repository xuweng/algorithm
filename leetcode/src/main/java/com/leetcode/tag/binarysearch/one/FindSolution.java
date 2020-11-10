package com.leetcode.tag.binarysearch.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 1237. 找出给定方程的正整数解
 */
public class FindSolution {
    /**
     * 方法一：暴力法
     * <p>
     * 作者：已注销
     * 链接：https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/solution/gei-ding-fang-cheng-de-zheng-zheng-shu-jie-bao-li-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                if (customfunction.f(i, 1) > z) {
                    break;
                }
                for (int j = 1; j <= 1000; j++) {
                    if (customfunction.f(i, j) == z) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                        break;
                    } else if (customfunction.f(i, j) > z) {
                        break;
                    }
                }
            }
            return res;
        }
    }

    /**
     * 方法二：二分查找
     * <p>
     * 作者：已注销
     * 链接：https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/solution/gei-ding-fang-cheng-de-zheng-zheng-shu-jie-bao-li-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                if (customfunction.f(i, 1) > z) {
                    break;
                }
                // 值二分
                int left = 1;
                int right = 1000;
                while (left <= right) {
                    int mid = (right + left) / 2;
                    int temp = customfunction.f(i, mid);
                    if (temp == z) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(mid);
                        res.add(list);
                        break;
                    } else if (temp > z) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return res;
        }
    }

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 0;
        }
    }
}
