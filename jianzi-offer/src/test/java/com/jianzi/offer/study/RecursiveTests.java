package com.jianzi.offer.study;

import com.jianzi.offer.study.recursive.Recursive;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveTests {
    @BeforeAll
    public static void init() {
    }

    @Test
    public void addToNRecursiveTest() {
        assertEquals(5050, Recursive.addToNRecursive(100));
    }

    @Test
    public void addToNForTest() {
        assertEquals(5050, Recursive.addToNFor(100));
    }

    @Test
    public void fibonacciTest() {
//        assertEquals(-811192543, Recursive.fibonacci(100));
        //结果太大，使用int会发生溢出
        System.out.println(Recursive.fibonacci(100));
        assertEquals(Recursive.fibonacciFor(100), Recursive.fibonacci(100));
    }
}
