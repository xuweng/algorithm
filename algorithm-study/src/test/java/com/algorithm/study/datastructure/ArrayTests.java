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

    @Test
    public void insertNoMoveTest() {
        for (int i = 0; i < 100; i++) {
            Array.insertNoMove(i, 5);
        }
    }

    @Test
    public void removeTest() {
        for (int i = 0; i < 100; i++) {
            Array.remove(i);
        }
    }
}
