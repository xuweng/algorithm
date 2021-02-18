package com.leetcode.tag.daily.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 滑动窗口 滑动窗口 滑动窗口
 */
public class GetRow {
    /**
     * 方法一：递推
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> C = new ArrayList<>();
            for (int i = 0; i <= rowIndex; ++i) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                    }
                }
                C.add(row);
            }
            return C.get(rowIndex);
        }
    }

}
