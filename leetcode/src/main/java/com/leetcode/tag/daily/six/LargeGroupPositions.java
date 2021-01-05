package com.leetcode.tag.daily.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置
 */
public class LargeGroupPositions {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            if (s == null || s.isEmpty()) {
                return null;
            }

            List<List<Integer>> result = new ArrayList<>();
            int preIndex = 0;
            s += "#";
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(preIndex)) {
                    int count = i - preIndex;
                    if (count >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(preIndex);
                        list.add(i - 1);

                        result.add(list);
                    }
                    preIndex = i;
                }
            }

            return result;
        }
    }

    /**
     * 方法一：一次遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/positions-of-large-groups/solution/jiao-da-fen-zu-de-wei-zhi-by-leetcode-so-fi3n/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> ret = new ArrayList<>();
            int n = s.length();
            int num = 1;
            for (int i = 0; i < n; i++) {
                if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    if (num >= 3) {
                        ret.add(Arrays.asList(i - num + 1, i));
                    }
                    num = 1;
                } else {
                    num++;
                }
            }
            return ret;
        }
    }
}
