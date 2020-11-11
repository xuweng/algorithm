package com.leetcode.tag.binarysearch.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 710. 黑名单中的随机数
 */
public class RandomPick {
    /**
     * 方法一：维护白名单 [超出时间限制，超出空间限制]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist/solution/hei-ming-dan-zhong-de-sui-ji-shu-by-leetcode-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        //维护白名单
        List<Integer> w;
        Random r;

        public Solution(int n, int[] b) {
            w = new ArrayList<>();
            r = new Random();
            //维护白名单
            Set<Integer> w = IntStream.range(0, n).boxed().collect(Collectors.toSet());
            for (int x : b) {
                w.remove(x);
            }
            this.w.addAll(w);
        }

        public int pick() {
            return w.get(r.nextInt(w.size()));
        }
    }

}
