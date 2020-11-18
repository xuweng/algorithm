package com.leetcode.tag.daily.five;

/**
 * 134. 加油站
 * <p>
 * 数组环形计算
 */
public class CanCompleteCircuit {
    /**
     * 方法一：一次遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int i = 0;

            // 从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
            while (i < n) {
                int sumOfGas = 0; // 总共加的油
                int SumOfCost = 0; // 总共消费的油
                int count = 0;     // 记录能走过几个站点
                while (count < n) {  // 退出循环的条件是走过所有的站点
                    int j = (i + count) % n; // 加油站是环形的
                    sumOfGas += gas[j];
                    SumOfCost += cost[j];
                    if (SumOfCost > sumOfGas) { // 如果这个站点发现油不够了
                        break;
                    }
                    count++; // 这个站点满足情况
                }

                if (count == n) {  // 如果能环绕一圈
                    return i;
                } else { // 不行的话 从下一个站点开始 检查
                    i = i + count + 1;
                }
            }
            // 所有加油站作为起点都不满足
            return -1;
        }
    }

    /**
     * 脑里跑代码
     * <p>
     * 看图。看图。看图。
     * <p>
     * 解法一 暴力解法
     * <p>
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            //考虑从每一个点出发
            for (int i = 0; i < n; i++) {
                int j = i;
                int remain = gas[i];
                //当前剩余的油能否到达下一个点
                while (remain - cost[j] >= 0) {
                    //减去花费的加上新的点的补给
                    remain = remain - cost[j] + gas[(j + 1) % n];
                    j = (j + 1) % n;
                    //j 回到了 i
                    if (j == i) {
                        return i;
                    }
                }
            }
            //任何点都不可以
            return -1;
        }

    }

}
