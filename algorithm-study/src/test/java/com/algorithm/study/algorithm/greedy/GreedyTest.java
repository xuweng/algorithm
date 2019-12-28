package com.algorithm.study.algorithm.greedy;

import org.junit.Test;

import java.util.List;

public class GreedyTest {
    @Test
    public void shipTest() {
        int MAXWEIGHT = 30;// 小船的载重量
        int AMOUNT = 8;// 古董个数
        int[] weight = {4, 10, 7, 11, 3, 5, 14, 2};

        System.out.println("能装入的古董最大数量为: " + Greedy.ship(weight, MAXWEIGHT, AMOUNT));
    }

    @Test
    public void arrangeActivityTest() {
        int[] start = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] end = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        List<Integer> results = Greedy.arrangeActivity(start, end);
        for (int index : results) {
            System.out.println("开始时间:" + start[index] + ",结束时间:" + end[index]);
        }
    }
}
