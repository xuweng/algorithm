package com.leetcode.tag.daily.three;

import org.junit.Test;

public class NumJewelsInStonesTest {
    NumJewelsInStones.Solution solution = new NumJewelsInStones.Solution();

    @Test
    public void numJewelsInStonesTest() {
        String J = "aA";
        String S = "aAAbbbb";

        solution.numJewelsInStones(J, S);
    }

    @Test
    public void test() {
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isUpperCase('a'));

        System.out.println('a' - 'a');
        System.out.println('b' - 'a');
        System.out.println('z' - 'a');
        System.out.println('z' - 'A');
        System.out.println('z' - 'Z');
        System.out.println('B' - 'A');

        System.out.println('a' - '0');
        System.out.println('z' - '0');
        System.out.println('A' - '0');
        System.out.println('Z' - '0');

    }

}