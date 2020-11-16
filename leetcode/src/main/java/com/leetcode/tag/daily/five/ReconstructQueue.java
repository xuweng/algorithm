package com.leetcode.tag.daily.five;

import java.util.Arrays;

/**
 * 406. 根据身高重建队列
 * <p>
 * 十分钟没有思路。十分钟没有思路。十分钟没有思路。
 * <p>
 * 十分钟没有思路。十分钟没有思路。十分钟没有思路。
 * <p>
 * 十分钟没有思路。十分钟没有思路。十分钟没有思路。
 * <p>
 * 特定算法。特定算法。特定算法。特定算法。特定算法。特定算法。
 * <p>
 * 特定算法。特定算法。特定算法。特定算法。特定算法。特定算法。
 */
public class ReconstructQueue {
    /**
     * 方法一：从低到高考虑
     * <p>
     * 按照数对的元素 1 降序排序，按照数对的元素 2 升序排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode-sol/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (person1, person2) -> {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            });
            int n = people.length;
            int[][] ans = new int[n][];
            for (int[] person : people) {
                int spaces = person[1] + 1;
                for (int i = 0; i < n; ++i) {
                    if (ans[i] == null) {
                        --spaces;
                        if (spaces == 0) {
                            ans[i] = person;
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }

}
