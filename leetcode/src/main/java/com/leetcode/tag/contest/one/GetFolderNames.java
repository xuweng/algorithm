package com.leetcode.tag.contest.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 搞懂题目
 *
 * <p>搞懂示例。
 *
 * <p>搞懂题目。
 *
 * <p>搞懂示例。
 *
 * <p>搞懂题目
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>5441. 保证文件名唯一
 */
public class GetFolderNames {
  public String[] getFolderNames(String[] names) {
    String[] result = new String[names.length];
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < names.length; i++) {
      String s = names[i];
      if (!map.containsKey(s)) {
        result[i] = s;
      } else {
        String s1 = s + "(" + map.get(s) + ")";
        if (!map.containsKey(s1)) {
          map.put(s1, 1);
          result[i] = s1;
        } else {
          int size = map.size();
          for (int j = 1; j <= size; j++) {
            String s2 = s + "(" + (map.get(s) + j) + ")";
            if (!map.containsKey(s2)) {
              map.put(s2, 1);
              result[i] = s2;
              break;
            }
          }
        }
      }

      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    return result;
  }
}
