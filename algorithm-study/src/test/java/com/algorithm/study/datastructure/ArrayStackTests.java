package com.algorithm.study.datastructure;

import com.algorithm.study.datastructure.stack.ArrayStack;
import org.junit.Test;

public class ArrayStackTests {
    @Test
    public void arrayStackTest() {
        ArrayStack arrayStack = new ArrayStack(100);

        for (int i = 0; i < 100; i++) {
            arrayStack.push(String.valueOf(i));
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(arrayStack.pop());
        }
    }
}
