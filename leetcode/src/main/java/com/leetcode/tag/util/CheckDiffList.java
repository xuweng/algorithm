package com.leetcode.tag.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckDiffList {

  public static void main(String[] args) {
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      list1.add("test" + i);
      list2.add("test" + i * 2);
    }

    System.out.println(getDiffrent(list1, list2));
    System.out.println(getDiffrent2(list1, list2));
    System.out.println(getDiffrent3(list1, list2));
    System.out.println(getDiffrent4(list1, list2));

    //        判断两个List内的元素是否相同
    //        getDiffrent total times    2514359
    //        false
    //        getDiffrent2 total times      7563
    //        false
    //        getDiffrent3 total times  26976244
    //        false
    //        getDiffrent4 total times  37313357
    //        false
  }

  /**
   * 判断两个List内的元素是否相同
   *
   * @param list1
   * @param list2
   * @return
   */
  private static boolean getDiffrent4(List<String> list1, List<String> list2) {
    Map<String, Integer> map = new HashMap<>(list1.size() + list2.size());
    List<String> maxList = list1;
    List<String> minList = list2;
    if (list2.size() > list1.size()) {
      maxList = list2;
      minList = list1;
    }
    for (String string : maxList) {
      map.put(string, 1);
    }
    for (String string : minList) {
      Integer cc = map.get(string);
      if (cc != null) {
        map.put(string, ++cc);
        continue;
      }
      return false;
    }
    return true;
  }

  /**
   * 判断两个List内的元素是否相同
   *
   * @param list1
   * @param list2
   * @return
   */
  private static boolean getDiffrent3(List<String> list1, List<String> list2) {
    long st = System.nanoTime();
    Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
    for (String string : list1) {
      map.put(string, 1);
    }
    for (String string : list2) {
      Integer cc = map.get(string);
      if (cc != null) {
        map.put(string, ++cc);
        continue;
      }
      System.out.println("getDiffrent3 total times " + (System.nanoTime() - st));
      return false;
    }
    System.out.println("getDiffrent3 total times " + (System.nanoTime() - st));
    return true;
  }

  /**
   * 判断两个List内的元素是否相同
   *
   * <p>此方法有bug 见Food.class
   *
   * @param list1
   * @param list2
   * @return
   */
  private static boolean getDiffrent2(List<String> list1, List<String> list2) {
    // 判断两个集合是否有交集，有则返回false，无则返回true
    return !list1.retainAll(list2);
  }

  /**
   * 判断两个List内的元素是否相同
   *
   * @param list1
   * @param list2
   * @return
   */
  private static boolean getDiffrent(List<String> list1, List<String> list2) {
    long st = System.nanoTime();
    if (list1.size() != list2.size()) {
      System.out.println("getDiffrent total times " + (System.nanoTime() - st));
      return false;
    }
    for (String str : list1) {
      if (!list2.contains(str)) {
        System.out.println("getDiffrent total times " + (System.nanoTime() - st));
        return false;
      }
    }
    System.out.println("getDiffrent total times " + (System.nanoTime() - st));
    return true;
  }
}
