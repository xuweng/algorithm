package com.leetcode.tag.dfs.one;

import java.util.*;
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
        //List作为map的key
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

    /**
     * 状压dp
     */
    class Solution2 {
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int[] decinal = {1, 7, 49, 343, 2401, 16807, 117649}; // 7的一次方，7的二次方....用于算7进制数转10进制数。
            int goods = price.size(); // 物品的总数量。
            for (int i = 0; i < goods; i++) { // 把每一个物品各买一个的情况放入大礼包中，因为大礼包不可能正好等于needs，还要添加单个买的数量。
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < goods; j++) {
                    tmp.add(0);
                }
                tmp.set(i, 1);
                tmp.add(price.get(i));
                special.add(tmp);
            }
            int tol = change(needs, goods, decinal); // 算出总量,比如needs是[1,2,1],那么就会算出64，也就是说有0-64个情况。[0,0,0]-[1,2,1](7进制)
            long[] dp = new long[tol + 1]; // 每一种情况放在数组的相应位置。注意这里类型必须是long或以上，否则等会比大小的时候会因为过大而溢出。
            Arrays.fill(dp, Integer.MAX_VALUE); // 初始化为最大值。
            dp[0] = 0; // base case 0。
            for (List<Integer> integers : special) {
                for (int j = 0; j <= tol; j++) {
                    if (!check(integers, needs, j)) {
                        continue; // 检查加上这个大礼包后是不是多出去了。
                    }
                    int state = change(integers, goods, decinal) + j; // 算出加上大礼包后在dp中对应的位置。
                    dp[state] = Math.min(dp[state], dp[j] + integers.get(goods)); // 更新dp，取最小的情况。
                }
            }
            return (int) dp[tol]; // 返回，注意强转回int类型。
        }

        // 把7进制数变为10进制数。
        public int change(List<Integer> sp, int n, int[] deci) {
            // 7变10公式,sp[i] * 7 ** i,i从0开始。
            return IntStream.range(0, n).map(i -> sp.get(i) * deci[i]).sum();
        }

        public boolean check(List<Integer> sp, List<Integer> needs, int cur) { // 检查数量是否小于needs。
            for (int i = 0; i < sp.size() - 1; i++) {
                if (cur % 7 + sp.get(i) > needs.get(i)) {
                    return false;//7进制最左边一位就是a物品的数量，加上当前大礼包后和needs的a物品数量进行比较
                }
                cur /= 7; // 相当于向右移一位，那么a物品就没了，最左边的变成了b物品。
            }
            return true;
        }

    }
}
