package com.leetcode.tag.contest.two;

import org.junit.Test;

public class InterpretTest {
    Interpret.Solution solution = new Interpret.Solution();

    @Test
    public void interpretTest() {
        String command = "G()()()()(al)";
        solution.interpret(command);
    }
}