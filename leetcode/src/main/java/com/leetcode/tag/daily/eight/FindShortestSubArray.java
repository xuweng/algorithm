package com.leetcode.tag.daily.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 */
public class FindShortestSubArray {
    /**
     * 方法一：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/degree-of-an-array/solution/shu-zu-de-du-by-leetcode-solution-ig97/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findShortestSubArray(int[] nums) {
            //数组中的三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置和这个数在原数组中最后一次出现的位置
            Map<Integer, int[]> map = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    //这个数出现的次数
                    map.get(nums[i])[0]++;
                    //这个数在原数组中最后一次出现的位置
                    map.get(nums[i])[2] = i;
                } else {
                    //这个数在原数组中第一次出现的位置
                    map.put(nums[i], new int[]{1, i, i});
                }
            }
            //找到元素出现次数最多，且前后位置差最小的数
            int maxNum = 0, minLen = 0;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] arr = entry.getValue();
                if (maxNum < arr[0]) {
                    // 更新
                    maxNum = arr[0];
                    minLen = arr[2] - arr[1] + 1;
                } else if (maxNum == arr[0]) {
                    if (minLen > arr[2] - arr[1] + 1) {
                        minLen = arr[2] - arr[1] + 1;
                    }
                }
            }
            return minLen;
        }
    }

}
