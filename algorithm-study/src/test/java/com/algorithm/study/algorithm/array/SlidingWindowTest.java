package com.algorithm.study.algorithm.array;

import org.junit.Test;

import java.util.Arrays;

public class SlidingWindowTest {
    @Test
    public void getMaxTest() {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
        int[] nums = {1, -1};
        int k = 1;

        System.out.println(Arrays.toString(SlidingWindow.getMax(nums, k)));
    }
}
