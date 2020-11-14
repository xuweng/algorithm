package com.leetcode.tag.daily.five;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1122. 数组的相对排序
 */
public class RelativeSortArray {
    /**
     * 自定义排序
     */
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
            Map<Integer, Integer> map = IntStream.range(0, arr2.length).boxed().collect(Collectors.toMap(i -> arr2[i], i -> i, (a, b) -> b));
            list.sort((x, y) -> {
                if (map.containsKey(x) || map.containsKey(y)) {
                    return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
                }
                return x - y;
            });
            Arrays.setAll(arr1, list::get);
            return arr1;
        }
    }

    /**
     * 方法二：计数排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/relative-sort-array/solution/shu-zu-de-xiang-dui-pai-xu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            // 数组最大值
            int upper = Arrays.stream(arr1).max().orElse(0);
            //记录每一个元素在数组arr1中出现的次数。
            int[] frequency = new int[upper + 1];
            for (int x : arr1) {
                ++frequency[x];
            }
            int[] ans = new int[arr1.length];
            int index = 0;
            for (int x : arr2) {
                for (int i = 0; i < frequency[x]; ++i) {
                    //遍历次数
                    ans[index++] = x;
                }
                // 清零
                frequency[x] = 0;
            }
            for (int x = 0; x <= upper; ++x) {
                for (int i = 0; i < frequency[x]; ++i) {
                    //还剩下没有在arr2中出现过的元素,放入数组末尾
                    ans[index++] = x;
                }
            }
            return ans;
        }
    }

}
