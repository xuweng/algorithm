package com.leetcode.tag.daily.five;

import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 */
public class ReorganizeString {
    /**
     * 方法一：基于最大堆的贪心算法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reorganize-string/solution/zhong-gou-zi-fu-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public String reorganizeString(String S) {
            if (S.length() < 2) {
                return S;
            }
            //首先统计每个字母的出现次数
            int[] counts = new int[26];
            int maxCount = 0;
            int length = S.length();
            for (int i = 0; i < length; i++) {
                char c = S.charAt(i);
                counts[c - 'a']++;
                maxCount = Math.max(maxCount, counts[c - 'a']);
            }
            //如果存在一个字母的出现次数大于 (n+1)/2，则无法重新排布字母使得相邻的字母都不相同，返回空字符串
            if (maxCount > (length + 1) / 2) {
                return "";
            }
            //最大堆
            PriorityQueue<Character> queue = new PriorityQueue<>((letter1, letter2) -> counts[letter2 - 'a'] - counts[letter1 - 'a']);
            for (char c = 'a'; c <= 'z'; c++) {
                if (counts[c - 'a'] > 0) {
                    //然后将出现次数大于 0 的字母加入最大堆。
                    queue.offer(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (queue.size() > 1) {
                char letter1 = queue.poll();
                char letter2 = queue.poll();
                sb.append(letter1);
                sb.append(letter2);
                int index1 = letter1 - 'a', index2 = letter2 - 'a';
                counts[index1]--;
                counts[index2]--;
                // 重新入堆
                if (counts[index1] > 0) {
                    queue.offer(letter1);
                }
                // 重新入堆
                if (counts[index2] > 0) {
                    queue.offer(letter2);
                }
            }
            if (queue.size() > 0) {
                sb.append(queue.poll());
            }
            return sb.toString();
        }
    }

}
