package com.leetcode.tag.daily.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 看图 看图 看图 看图 看图 看图 看图 看图 看图
 * <p>
 * 看图 看图 看图 看图 看图 看图 看图 看图 看图
 */
public class Generate {
    /**
     * 可以一行一行地计算杨辉三角。每当我们计算出第 i 行的值，我们就可以在线性时间复杂度内计算出第 i+1 行的值。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/pascals-triangle/solution/yang-hui-san-jiao-by-leetcode-solution-lew9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        // 左边界和右边界为1
                        row.add(1);
                    } else {
                        // 左上角+右上角
                        row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }
    }
    //
    //    class Solution1 {
    //        public List<List<Integer>> generate(int numRows) {
    //            List<List<Integer>> res = new ArrayList<>();
    //            if (numRows == 0) {
    //                return res;
    //            }
    //            res.add(new ArrayList<>() {{
    //                add(1);
    //            }});
    //            if (numRows == 1) {
    //                return res;
    //            }
    //            res.add(new ArrayList<>() {{
    //                add(1);
    //                add(1);
    //            }});
    //            if (numRows == 2) {
    //                return res;
    //            }
    //            List<Integer> preRow = res.get(1);
    //            for (int i = 3; i <= numRows; i++) {
    //                List<Integer> list = new ArrayList<>() {{
    //                    add(1);
    //                }};
    //                for (int j = 1; j < i - 1; j++) {
    //                    list.add(preRow.get(j) + preRow.get(j - 1));
    //                }
    //                list.add(1);
    //                preRow = list;
    //                res.add(list);
    //            }
    //            return res;
    //        }
    //    }

}
