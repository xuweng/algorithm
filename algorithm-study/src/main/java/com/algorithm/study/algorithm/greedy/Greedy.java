package com.algorithm.study.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/seagal890/article/details/90614064
 * <p>
 * 贪心算法。先排序。
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

    /**
     * 循环一定要注意索引。当前索引，上一个索引，下一个索引等等
     * <p>
     * 活动安排问题就是要在所给的活动集合中选出最大的相容活动子集合。活动按结束时间升序。
     * <p>
     * 优先选择结束时间最小的活动
     *
     * @param start 活动的起始时间
     * @param end   活动的结束时间
     * @return
     */
    public static List<Integer> arrangeActivity(int[] start, int[] end) {
        int total = start.length;
        int endFlag = end[0];
        List<Integer> results = new ArrayList<>();
        //先选择最小结束时间
        results.add(0);
        //选择当前开始时间大于上一个结束时间的活动。注意循环表达式里面的条件。一开始写错了。
        for (int i = 1; i < total; i++) {
            if (start[i] >= endFlag) {
                results.add(i);
                endFlag = end[i];
            }
        }
        return results;
    }
}
