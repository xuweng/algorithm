package com.algorithm.study.algorithm.greedy;

import java.util.Arrays;

/**
 * https://blog.csdn.net/seagal890/article/details/90614064
 * <p>
 * 贪心算法
 */
public class Greedy {
    /**
     * 最优装载问题
     * <p>
     * 优先选择装载重量最小的物品，这个选择策略就采用了贪心（Greedy）策略，从局部最优达到全局最优，
     * 从而产生最优装载问题的最优解。
     *
     * @param weight    每个古董重量
     * @param MAXWEIGHT 小船的载重量
     * @param AMOUNT    古董个数
     * @return
     */
    public static int ship(int[] weight, int MAXWEIGHT, int AMOUNT) {
        //计数器，用于记录装载到小船上古董的数量
        int counter = 0;
        // 对weight数组进行从小到大排序
        Arrays.sort(weight);
        // 统计装载到船上的古董重量
        int sum = 0;
        //简洁代码。条件放在循环表达式里面。简洁代码。简洁代码。
        for (int i = 0; i < AMOUNT && sum <= MAXWEIGHT; i++) {
            // 贪心策略：每次装入最轻者
            sum += weight[i];
            counter++;
        }
        //返回装载的古董的数量
        return counter;
    }
}
