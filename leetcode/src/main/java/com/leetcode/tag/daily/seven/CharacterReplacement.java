package com.leetcode.tag.daily.seven;

/**
 * 424. 替换后的最长重复字符
 */
public class CharacterReplacement {
    /**
     * 方法一：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-n6aza/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] num = new int[26];
            int n = s.length();
            //重复字符出现次数的历史最大值
            int maxn = 0;
            int left = 0, right = 0;
            // 枚举字符串中的每一个位置作为右端点
            // 找到其最远的左端点的位置，满足该区间内除了出现次数最多的那一类字符之外，剩余的字符（即非最长重复字符）数量不超过 k 个
            while (right < n) {
                num[s.charAt(right) - 'A']++;
                maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
                if (right - left + 1 - maxn > k) {
                    num[s.charAt(left) - 'A']--;

                    // 收缩窗口 直到不满足条件
                    left++;
                }
                // 扩大窗口
                right++;
            }
            return right - left;
        }
    }

    class Solution1 {
        public int characterReplacement(String s, int k) {
            int[] record = new int[26];
            int len = s.length();
            char[] arr = s.toCharArray();
            int left = 0;
            int right = 0;
            int historyMax = 0;
            while (right < len) {
                record[arr[right] - 'A']++;
                historyMax = Math.max(historyMax, record[arr[right] - 'A']);
                right++;
                while (right - left > historyMax + k) {
                    record[arr[left] - 'A']--;
                    left++;
                }
            }
            return right - left;
        }
    }

}
