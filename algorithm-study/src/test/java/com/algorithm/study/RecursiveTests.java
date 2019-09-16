package com.algorithm.study;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.recursive.Recursive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RecursiveTests {
    @Test
    public void factorialTest() {
        int value = Recursive.factorial(5);

        System.err.println(value);
    }

    @Test
    public void sumTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);
        int value = Recursive.sum(array, array.length - 1);

        System.err.println(value);
    }

    @Test
    public void maxValueTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);
        int value = Recursive.maxValue(array, array.length - 1);

        assertEquals(100, value);
    }
}
