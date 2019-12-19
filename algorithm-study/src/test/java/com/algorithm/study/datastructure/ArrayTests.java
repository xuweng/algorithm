package com.algorithm.study.datastructure;

import com.algorithm.study.datastructure.array.Array;
import org.junit.Test;

public class ArrayTests {
    @Test
    public void insertMoveTest() {
        for (int i = 0; i < 100; i++) {
            Array.insertMove(String.valueOf(i), 5);
        }
    }

    @Test
    public void insertNoMoveTest() {
        for (int i = 0; i < 100; i++) {
            Array.insertNoMove(String.valueOf(i), 5);
        }
    }

    @Test
    public void removeTest() {
        for (int i = 0; i < 100; i++) {
            Array.removeMove(i);
        }
    }
}
