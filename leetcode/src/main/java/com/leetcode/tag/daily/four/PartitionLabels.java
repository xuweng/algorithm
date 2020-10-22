package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * <p>
 * 十分钟.十分钟.十分钟.十分钟
 */
public class PartitionLabels {
    /**
     * 方法一：贪心算法 + 双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。
         * <p>
         * 因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
         * <p>
         * 使用贪心的思想寻找每个片段可能的最小结束下标，因此可以保证每个片段的长度一定是符合要求的最短长度，
         * <p>
         * 如果取更短的片段，则一定会出现同一个字母出现在多个片段中的情况。由于每次取的片段都是符合要求的最短的片段，因此得到的片段数也是最多的。
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param S
         * @return
         */
        public List<Integer> partitionLabels(String S) {
            // 每个字母最后一次出现的下标位置
            int[] last = new int[26];
            int length = S.length();
            for (int i = 0; i < length; i++) {
                last[S.charAt(i) - 'a'] = i;
            }
            List<Integer> partition = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                end = Math.max(end, last[S.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return partition;
        }
    }

}
