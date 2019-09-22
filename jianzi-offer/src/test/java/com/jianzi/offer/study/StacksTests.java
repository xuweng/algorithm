package com.jianzi.offer.study;

import com.jianzi.offer.study.stacks.Stacks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StacksTests {
    @BeforeAll
    static void init() {
        Stacks.appendTail(1);
        Stacks.appendTail(2);
        Stacks.appendTail(3);
        Stacks.appendTail(4);
    }

    @Test
    public void deleteHead() {
        assertEquals(1, Stacks.deleteHead());
        assertEquals(2, Stacks.deleteHead());
        assertEquals(3, Stacks.deleteHead());
        assertEquals(4, Stacks.deleteHead());
    }
}
