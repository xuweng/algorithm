package com.leetcode.tag.daily;

import org.junit.Test;

public class StringTest {
  @Test
  public void test() {
    String str = "1-2--3--4-5--6--7";

    System.out.println(str.indexOf("-"));
    System.out.println(str.indexOf("--"));
    System.out.println(str.lastIndexOf("-"));
    System.out.println(str.lastIndexOf("--"));
  }
}
