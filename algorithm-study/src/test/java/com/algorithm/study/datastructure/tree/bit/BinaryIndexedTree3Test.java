package com.algorithm.study.datastructure.tree.bit;

import org.junit.jupiter.api.Test;

public class BinaryIndexedTree3Test {
  @Test
  public void test() {
    //    十进制转成十六进制：
    //    Integer.toHexString(int i)
    //    十进制转成八进制
    //    Integer.toOctalString(int i)
    //    十进制转成二进制
    //    Integer.toBinaryString(int i)
    //    十六进制转成十进制
    //    这3个函数都可以将十进制的整数转换成二、一六、八进制数   不过转换后的结果都是字符串的形式
    //
    //    Integer.valueOf("FFFF",16).toString()
    //    八进制转成十进制
    //    Integer.valueOf("876",8).toString()
    //    二进制转十进制
    //    Integer.valueOf("0101",2).toString()
    BinaryIndexedTree3 binaryIndexedTree3 = new BinaryIndexedTree3();

    for (int i = 0; i <= 10; i++) {
      System.out.println(Integer.toBinaryString(i) + "," + binaryIndexedTree3.lowbit(i));
    }
  }
}
