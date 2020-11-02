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

    /**
     * 方法二：排序 + 双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length, length2 = nums2.length;
            int[] intersection = new int[length1 + length2];
            //pre 表示上一次加入答案数组的元素
            int pre = 0;
            int index1 = 0, index2 = 0;
            while (index1 < length1 && index2 < length2) {
                int num1 = nums1[index1], num2 = nums2[index2];
                if (num1 == num2) {
                    // 如果两个数字相等
                    // 且该数字不等于 pre

                    // 去重
                    // 保证加入元素的唯一性
                    if (pre == 0 || num1 != intersection[pre - 1]) {
                        intersection[pre++] = num1;
                    }
                    // 一起移动
                    index1++;
                    index2++;
                } else if (num1 < num2) {
                    // 如果两个数字不相等，则将指向较小数字的指针右移一位
                    index1++;
                } else {
                    // 如果两个数字不相等，则将指向较小数字的指针右移一位
                    index2++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, pre);
        }
    }

}
