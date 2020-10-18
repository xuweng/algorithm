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
     * 所有从根到叶子（或从叶子到根）的最大的路径和
     */
    class Solution {
        int result;
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            for (int i = 0; i < manager.length; i++) {
                map.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }

            dfs(headID, informTime, 0);

            return result;
        }

        public void dfs(int headID, int[] informTime, int sum) {
            if (!map.containsKey(headID)) {
                //叶子结点
                result = Math.max(result, sum + informTime[headID]);
                return;
            }
            for (Integer integer : map.get(headID)) {
                dfs(integer, informTime, sum + informTime[headID]);
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

    /**
     * 所有从根到叶子（或从叶子到根）的最大的路径和
     * <p>
     * 作者：yuruiyin
     * 链接：https://leetcode-cn.com/problems/time-needed-to-inform-all-employees/solution/java-liang-chong-jie-fa-zi-ding-xiang-xia-he-zi-di/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        private List<Integer>[] adj;
        private int ansMax = 0;
        private int[] informTime;

        private void dfs(int idx, int sum) {
            if (adj[idx] == null) {
                ansMax = Math.max(ansMax, sum);
                return;
            }

            List<Integer> nextList = adj[idx];
            for (Integer next : nextList) {
                dfs(next, sum + informTime[idx]);
            }
        }

        public int numOfMinutes(int n, int headID, int[] managers, int[] informTime) {
            adj = new ArrayList[n];
            this.informTime = informTime;

            for (int i = 0; i < n; i++) {
                int manager = managers[i];
                if (manager == -1) {
                    continue;
                }
                if (adj[manager] == null) {
                    adj[manager] = new ArrayList<>();
                }
                adj[manager].add(i);
            }

            dfs(headID, 0);
            return ansMax;
        }
    }

}
