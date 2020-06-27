package com.leetcode.tag.backtracking;

import org.junit.Test;

public class VerbalArithmeticPuzzleTest {
  VerbalArithmeticPuzzle verbalArithmeticPuzzle = new VerbalArithmeticPuzzle();

  @Test
  public void test() {
    String[] words = {"SEND", "MORE"};
    String result = "MONEY";

    System.out.println(verbalArithmeticPuzzle.isSolvable(words, result));
  }
}
