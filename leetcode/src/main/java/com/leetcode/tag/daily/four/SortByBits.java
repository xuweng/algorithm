package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 */
public class SortByBits {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/solution/gen-ju-shu-zi-er-jin-zhi-xia-1-de-shu-mu-pai-xu-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] sortByBits(int[] arr) {
            int[] bit = new int[10001];
            List<Integer> list = new ArrayList<>();
            for (int x : arr) {
                list.add(x);
                bit[x] = get(x);
            }
            list.sort((x, y) -> {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            });
            Arrays.setAll(arr, list::get);
            return arr;
        }

        /**
         * 对每个十进制的数转二进制的时候统计一下 1 的个数
         *
         * @param x
         * @return
         */
        public int get(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 2;
                x /= 2;
            }
            return res;
        }
    }

}
