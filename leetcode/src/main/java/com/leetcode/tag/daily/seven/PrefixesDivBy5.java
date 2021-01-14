package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 */
public class PrefixesDivBy5 {
    /**
     * 溢出
     */
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            if (A == null || A.length == 0) {
                return null;
            }
            List<Boolean> result = new ArrayList<>();
            String s = "";
            for (int i : A) {
                s += i;
                result.add(Integer.parseInt(s, 2) % 5 == 0);
            }

            return result;
        }
    }

    /**
     * 方法一：模拟
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/solution/ke-bei-5-zheng-chu-de-er-jin-zhi-qian-zh-asih/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> list = new ArrayList<>();
            //考虑到数组 A 可能很长
            //只需要保留余数
            int prefix = 0;
            for (int j : A) {
                prefix = ((prefix << 1) + j) % 5;
                list.add(prefix == 0);
            }
            return list;
        }
    }

}
