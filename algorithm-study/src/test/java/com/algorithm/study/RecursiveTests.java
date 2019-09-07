package com.algorithm.study;

import com.algorithm.study.recursive.Recursive;
import org.junit.Test;

public class RecursiveTests {
    @Test
    public void factorial() {
        int value = Recursive.factorial(5);

        System.err.println(value);
    }
}
