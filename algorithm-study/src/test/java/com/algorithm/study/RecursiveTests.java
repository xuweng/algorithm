package com.algorithm.study;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.recursive.Recursive;
import org.junit.Test;

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
}
