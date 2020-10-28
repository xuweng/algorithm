package com.leetcode.tag.daily.four;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 */
public class UniqueOccurrences {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr == null || arr.length == 0) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            Set<Integer> set = new HashSet<>(map.values());
            return set.size() == map.size();
        }
    }

    /**
     * 方法一：哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/du-yi-wu-er-de-chu-xian-ci-shu-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> occur = new HashMap<>();
            for (int x : arr) {
                occur.put(x, occur.getOrDefault(x, 0) + 1);
            }
            Set<Integer> times = new HashSet<>();
            for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
                times.add(x.getValue());
            }
            return times.size() == occur.size();
        }
    }

    /**
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/3chong-jie-jue-fang-shi-by-sdwwld-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j : arr) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
            return map.size() == new HashSet<>(map.values()).size();
        }
    }

}
