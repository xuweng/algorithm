package com.algorithm.study.datastructure;

import com.algorithm.study.datastructure.link.LinkedList;
import org.junit.Test;

public class LinkedListTests {
    @Test
    public void insertTest() {
        for (int i = 0; i < 100; i++) {
            LinkedList.insert(i, i);
        }
    }
}
