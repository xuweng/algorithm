package com.leetcode.tag.daily.four;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. 两个数组的交集
 */
public class Intersection {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

            List<Integer> result = set1.stream().filter(set2::contains).collect(Collectors.toList());

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    /**
     * 方法一：两个集合
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

            return getIntersection(set1, set2);
        }

        /**
         * @param set1 小集合
         * @param set2 大集合
         * @return
         */
        public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
            if (set1.size() > set2.size()) {
                // 厉害
                return getIntersection(set2, set1);
            }
            Set<Integer> intersectionSet = set1.stream().mapToInt(num -> num)
                    .filter(set2::contains).boxed().collect(Collectors.toSet());
            // 遍历小集合
            int[] intersection = new int[intersectionSet.size()];
            int index = 0;
            for (int num : intersectionSet) {
                intersection[index++] = num;
            }
            return intersection;
        }
    }

}
