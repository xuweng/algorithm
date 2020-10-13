package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 638. 大礼包
 * <p>
 * 十分钟.十分钟.十分钟.十分钟
 */
public class ShoppingOffers {
    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/shopping-offers/solution/da-li-bao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            return shopping(price, special, needs);
        }

        public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int j, res = dot(needs, price);
            for (List<Integer> s : special) {
                ArrayList<Integer> clone = new ArrayList<>(needs);
                for (j = 0; j < needs.size(); j++) {
                    int diff = clone.get(j) - s.get(j);
                    if (diff < 0) {
                        break;
                    }
                    clone.set(j, diff);
                }
                if (j == needs.size()) {
                    res = Math.min(res, s.get(j) + shopping(price, special, clone));
                }
            }
            return res;
        }

        public int dot(List<Integer> a, List<Integer> b) {
            return IntStream.range(0, a.size()).map(i -> a.get(i) * b.get(i)).sum();
        }
    }

    /**
     * 方法二：记忆化搜索
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/shopping-offers/solution/da-li-bao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        Map<List<Integer>, Integer> map = new HashMap<>();

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            return shopping(price, special, needs);
        }

        public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            if (map.containsKey(needs)) {
                return map.get(needs);
            }
            int j, result = dot(needs, price);
            for (List<Integer> s : special) {
                ArrayList<Integer> clone = new ArrayList<>(needs);
                for (j = 0; j < needs.size(); j++) {
                    int diff = clone.get(j) - s.get(j);
                    if (diff < 0) {
                        break;
                    }
                    clone.set(j, diff);
                }
                if (j == needs.size()) {
                    result = Math.min(result, s.get(j) + shopping(price, special, clone));
                }
            }
            map.put(needs, result);
            return result;
        }

        public int dot(List<Integer> a, List<Integer> b) {
            return IntStream.range(0, a.size()).map(i -> a.get(i) * b.get(i)).sum();
        }
    }
}
