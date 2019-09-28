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
}
