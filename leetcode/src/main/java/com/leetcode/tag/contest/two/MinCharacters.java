package com.leetcode.tag.contest.two;

/**
 * 1737. 满足三条件之一需改变的最少字符数
 * <p>
 * 5662. 满足三条件之一需改变的最少字符数
 */
public class MinCharacters {
    /**
     * 作者：shixin_billy
     * 链接：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/solution/javajie-jue-jie-ti-si-lu-qing-xi-by-shix-9hyf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minCharacters(String a, String b) {
            int[] ac = new int[26];
            int[] bc = new int[26];
            // 计数 计数 计数
            for (char c : a.toCharArray()) {
                ac[c - 'a']++;
            }
            for (char c : b.toCharArray()) {
                bc[c - 'a']++;
            }
            // 输入：a = "aba", b = "caa"
            // 3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
            //第三个条件，修改字符最少，改成同一个字符
            int ans = a.length() + b.length();
            for (int i = 0; i < 26; i++) {
                // 模拟 模拟 模拟
                ans = Math.min(ans, a.length() + b.length() - ac[i] - bc[i]);
            }
            return Math.min(ans, Math.min(smaller(ac, bc), smaller(bc, ac)));
        }

        private int smaller(int[] a, int[] b) {
            //第一个第二个条件类似，封装到一个方法
            //因为字母总共就26个，所以枚举所有可能， 依次判断a中所有元素小于等于字符k,b中所有元素大于字符k，然后求出最小值即可
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 25; i++) {//因为z是最大的元素，所以不能让a中所有元素小于等于z，这一点需要排除，所以只循环到24
                int total = 0;//需要修改的元素的总数
                for (int j = i + 1; j < 26; j++) {//把a中素有大于i的元素统计起来，保证a中所有元素小于等于i，需要遍历a中所有元素
                    total += a[j];
                }
                for (int j = 0; j <= i; j++) {//把b中所有小于等于元素i的都统计起来，使调整后所有元素都大于i
                    total += b[j];
                }
                ans = Math.min(ans, total);
            }
            return ans;
        }

    }
}
