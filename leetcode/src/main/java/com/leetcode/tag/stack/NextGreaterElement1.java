package com.leetcode.tag.stack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 556. 下一个更大元素 III
 */
public class NextGreaterElement1 {
    /**
     * 方法 1：暴力
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/xia-yi-ge-geng-da-yuan-su-iii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public String swap(String s, int i0, int i1) {
            if (i0 == i1) {
                return s;
            }
            String s1 = s.substring(0, i0);
            String s2 = s.substring(i0 + 1, i1);
            String s3 = s.substring(i1 + 1);
            return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
        }

        ArrayList<String> list = new ArrayList<>();

        void permute(String a, int l, int r) {
            int i;
            if (l == r) {
                list.add(a);
            } else {
                for (i = l; i <= r; i++) {
                    a = swap(a, l, i);
                    permute(a, l + 1, r);
                    a = swap(a, l, i);
                }
            }
        }

        public int nextGreaterElement(int n) {
            String s = "" + n;
            permute(s, 0, s.length() - 1);
            Collections.sort(list);
            int i;
            for (i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).equals("" + n)) {
                    break;
                }
            }
            return i == list.size() - 1 ? -1 : Integer.parseInt(list.get(i + 1));
        }
    }

    /**
     * 方法 2：线性解法
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/xia-yi-ge-geng-da-yuan-su-iii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int nextGreaterElement(int n) {
            char[] a = ("" + n).toCharArray();
            int i = a.length - 2;
            while (i >= 0 && a[i + 1] <= a[i]) {
                i--;
            }
            if (i < 0) {
                return -1;
            }
            int j = a.length - 1;
            while (j >= 0 && a[j] <= a[i]) {
                j--;
            }
            swap(a, i, j);
            reverse(a, i + 1);
            try {
                return Integer.parseInt(new String(a));
            } catch (Exception e) {
                return -1;
            }
        }

        /**
         * 反转
         *
         * @param a
         * @param start
         */
        private void reverse(char[] a, int start) {
            int i = start, j = a.length - 1;
            while (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

}
