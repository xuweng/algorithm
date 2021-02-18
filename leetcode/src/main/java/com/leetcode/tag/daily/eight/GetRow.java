package com.leetcode.tag.daily.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 滑动窗口 滑动窗口 滑动窗口
 * <p>
 * 计数 计数 计数 topk
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
                        // 边界
                        row.add(1);
                    } else {
                        // 非边界
                        row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                    }
                }
                C.add(row);
            }
            return C.get(rowIndex);
        }
    }

    /**
     * 优化
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 第 i+1 行的计算仅用到了第 i 行的数据，因此可以使用滚动数组的思想优化空间复杂度
         *
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow(int rowIndex) {
            List<Integer> pre = new ArrayList<>();
            for (int i = 0; i <= rowIndex; ++i) {
                List<Integer> cur = new ArrayList<>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        cur.add(1);
                    } else {
                        cur.add(pre.get(j - 1) + pre.get(j));
                    }
                }
                pre = cur;
            }
            return pre;
        }
    }

}
