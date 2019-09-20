package com.jianzi.offer.study;

import com.jianzi.offer.study.arrays.Array;
import com.jianzi.offer.study.common.ArrayUtils;
import com.jianzi.offer.study.common.annotation.ExceptionUserCase;
import com.jianzi.offer.study.common.annotation.NormalUserCase;
import com.jianzi.offer.study.linkedlist.LinkedLists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTests {
    private static int[][] array;

    @BeforeAll
    public static void init() {
        array = Array.getTwoArray();
    }

    @NormalUserCase
    @Test
    public void findTwoArraySuccess() {
        boolean isFound = Array.findTwoArray(array, 3, 3, 7);

        assertTrue(isFound);
    }

    @NormalUserCase
    @Test
    public void findTwoArrayFail() {
        boolean isFound = Array.findTwoArray(array, 3, 3, 70);

        assertFalse(isFound);
    }

    /**
     *
     */
    @ExceptionUserCase
    @Test
    public void findTwoArrayFail1() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            boolean isFound = Array.findTwoArray(array, -3, 3, 7);

            assertTrue(isFound);
        });
    }

    @NormalUserCase
    @Test
    public void mergeArraySuccess() {
        Integer[] array1 = new Integer[20];
        Integer[] array2 = new Integer[2];
        Arrays.fill(array1, 0);
        for (int i = 1; i <= 10; i++) {
            array1[i - 1] = i;
        }
        array1[10] = 0;
        array2[0] = 11;
        array2[1] = 12;

        Integer[] array = Array.mergeArray(array1, array2);

        ArrayUtils.println(array);
    }
}
