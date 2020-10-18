package com.leetcode.tag.dfs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. 通知所有员工所需的时间
 * <p>
 * 十分钟.十分钟.十分钟
 */
public class NumOfMinutes {
    /**
     * 算法错误
     */
    class Solution {
        int d;
        int result;
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            for (int i = 0; i < manager.length; i++) {
                map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }

            dfs(headID, informTime, 1);

            return result;
        }

        public void dfs(int headID, int[] informTime, int depth) {
            if (!map.containsKey(headID)) {
                return;
            }
            if (depth > d) {
                result += informTime[headID];
            }
            d = depth;
            for (Integer integer : map.get(headID)) {
                dfs(integer, informTime, depth + 1);
            }
        }
    }

    /**
     * 作者：yangfukang
     * 链接：https://leetcode-cn.com/problems/time-needed-to-inform-all-employees/solution/mei-you-dai-ma-you-hua-si-lu-qing-xi-by-yangfukang/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            //最终结果
            int res = 0;

            for (int i = 0; i < manager.length; i++) {
                //判断是否为结束点，剪枝
                if (informTime[i] == 0) {
                    //临时值
                    int temp = 0;
                    int index = i;
                    //向上遍历
                    while (index != -1) {
                        temp += informTime[index];
                        index = manager[index];
                    }
                    res = Math.max(res, temp);
                }
            }
            return res;
        }
    }

}
