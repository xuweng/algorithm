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

    /**
     * 当前行第 i 项的计算只与上一行第 i−1 项及第 i 项有关
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add(0);
                for (int j = i; j > 0; --j) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
            return row;
        }
    }

    /**
     * 方法二：线性递推
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
            }
            return row;
        }
    }

}
