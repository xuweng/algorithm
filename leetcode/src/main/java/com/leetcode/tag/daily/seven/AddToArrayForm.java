package com.leetcode.tag.daily.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 */
public class AddToArrayForm {
    /**
     * 方法一：逐位相加
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/shu-zu-xing-shi-de-zheng-shu-jia-fa-by-l-jljp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> res = new ArrayList<>();
            int n = A.length;
            for (int i = n - 1; i >= 0; --i) {
                int sum = A[i] + K % 10;
                K /= 10;
                if (sum >= 10) {
                    K++;
                    sum -= 10;
                }
                res.add(sum);
            }
            for (; K > 0; K /= 10) {
                res.add(K % 10);
            }
            Collections.reverse(res);
            return res;
        }
    }

    /**
     * 大数溢出
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/shu-zu-xing-shi-de-zheng-shu-jia-fa-by-l-jljp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> res = new ArrayList<>();
            int n = A.length;
            for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
                if (i >= 0) {
                    K += A[i];
                }
                res.add(K % 10);
            }
            Collections.reverse(res);
            return res;
        }
    }

}
