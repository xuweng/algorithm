package com.leetcode.tag.contest.two;

import org.junit.Test;

public class SlowestKeyTest {
    SlowestKey.Solution solution = new SlowestKey.Solution();

    @Test
    public void slowestKey() {
        int[] releaseTimes = {19, 22, 28, 29, 66, 81, 93, 97};
        String keysPressed = "fnfaaxha";

        solution.slowestKey(releaseTimes, keysPressed);
    }

}