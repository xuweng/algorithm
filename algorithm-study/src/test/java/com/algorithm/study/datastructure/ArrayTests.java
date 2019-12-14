package com.algorithm.study.datastructure;

import com.algorithm.study.datastructure.graph.Array;
import org.junit.Test;

public class ArrayTests {
    @Test
    public void insertMoveTest() {
        for (int i = 0; i < 100; i++) {
            Array.insertMove(i, 5);
        }
    }
}
