package com.leetcode.tag.util;

import java.util.*;

public class CollectionUtils {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("c");
    list.add("c");
    list.add("a");
    list.add("a");
    list.add("b");
    // 1.set集合去重，不改变原有的顺序
    pastLeep1(list);
    // 2.遍历后判断赋给另一个list集合  不改变原有的顺序
    pastLeep2(list);
    // 3.set去重  并按自然顺序排序
    pastLeep3(list);
    // 4.set去重（缩减为一行）
    pastLeep4(list);
    // 5.去重并按自然顺序排序
    pastLeep5(list);
  }

  // 1.set集合去重，不改变原有的顺序
  public static void pastLeep1(List<String> list) {
    System.out.println("list = [" + list.toString() + "]");
    List<String> listNew = new ArrayList<>();
    Set set = new HashSet();
    for (String str : list) {
      if (set.add(str)) {
        listNew.add(str);
      }
    }
    System.out.println("listNew = [" + listNew.toString() + "]");
  }

  // 2.遍历后判断赋给另一个list集合 不改变原有的顺序
  public static void pastLeep2(List<String> list) {
    System.out.println("list = [" + list.toString() + "]");
    List<String> listNew = new ArrayList<>();
    for (String str : list) {
      if (!listNew.contains(str)) {
        listNew.add(str);
      }
    }
    System.out.println("listNew = [" + listNew.toString() + "]");
  }

  // 3.set去重  并按自然顺序排序
  public static void pastLeep3(List<String> list) {
    System.out.println("list = [" + list + "]");
    Set set = new HashSet();
    List<String> listNew = new ArrayList<>();
    set.addAll(list);
    listNew.addAll(set);
    System.out.println("listNew = [" + listNew + "]");
  }

  // 4.set去重（缩减为一行） 并按自然顺序排序
  public static void pastLeep4(List<String> list) {
    System.out.println("list = [" + list + "]");
    List<String> listNew = new ArrayList<>(new HashSet(list));
    System.out.println("listNew = [" + listNew + "]");
  }

  // 5.去重并按自然顺序排序
  public static void pastLeep5(List<String> list) {
    System.out.println("list = [" + list + "]");
    List<String> listNew = new ArrayList<>(new TreeSet<>(list));
    System.out.println("listNew = [" + listNew + "]");
  }
}
