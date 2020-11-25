package com.leetcode.tag.daily.five;

/**
 * 1370. 上升下降字符串
 */
public class SortString {
    /**
     * 方法一：桶计数
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string/solution/shang-sheng-xia-jiang-zi-fu-chuan-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public String sortString(String s) {
            int[] num = new int[26];
            //计数
            for (int i = 0; i < s.length(); i++) {
                num[s.charAt(i) - 'a']++;
            }

            StringBuilder ret = new StringBuilder();
            while (ret.length() < s.length()) {
                for (int i = 0; i < 26; i++) {
                    if (num[i] > 0) {
                        ret.append((char) (i + 'a'));
                        num[i]--;
                    }
                }
                for (int i = 25; i >= 0; i--) {
                    if (num[i] > 0) {
                        ret.append((char) (i + 'a'));
                        num[i]--;
                    }
                }
            }
            return ret.toString();
        }
    }

}
