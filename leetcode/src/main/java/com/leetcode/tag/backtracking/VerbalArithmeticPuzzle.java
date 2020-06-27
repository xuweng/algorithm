package com.leetcode.tag.backtracking;

import com.leetcode.tag.util.StringUtils;

import java.util.*;

/**
 * 经典题目
 *
 * <p>简单实用
 *
 * <p>十分钟
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>1307. 口算难题
 */
public class VerbalArithmeticPuzzle {
  public boolean isSolvable(String[] words, String result) {
    Set<Character> set = new TreeSet<>();
    for (String word : words) {
      for (char c : word.toCharArray()) {
        set.add(c);
      }
    }
    for (char c : result.toCharArray()) {
      set.add(c);
    }
    StringBuilder stringBuilder = new StringBuilder();
    set.forEach(stringBuilder::append);

    return backTrack(stringBuilder.toString(), 0, words, result, new HashMap<>());
  }

  /**
   * 我们必须枚举所有字母与数字的映射情况，并判断它们是否满足要求
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * @param result
   * @return
   */
  public boolean backTrack(
          String word, int start, String[] words, String result, Map<Character, Integer> map) {
    if (start >= word.length()) {
      // 被解码成一个没有前导零的数字
      if (result.charAt(0) == '0') {
        return false;
      }
      int sum = 0;
      for (String s : words) {
        if (s.charAt(0) == '0') {
          return false;
        }
        sum += Integer.parseInt(s);
      }

      return sum == Integer.parseInt(result);
    }
    // 每个start的候选集。9个候选集肯定会超出时间限制。
    for (int i = 0; i <= 9; i++) {
      char c = word.charAt(start);
      if (map.containsKey(c) || map.containsValue(i)) {
        continue;
      }
      // 剪枝
      // root时判断。第一个数不能选择0.。被解码成一个没有前导零的数字
      if (i == 0) {
        boolean flag = true;
        for (String s : words) {
          flag = flag && !StringUtils.hasDigit(s);
        }
        if (!StringUtils.hasDigit(result) && flag) {
          continue;
        }
      }
      map.put(c, i);
      String[] newWords = new String[words.length];
      for (int i1 = 0; i1 < words.length; i1++) {
        String w = words[i1];
        newWords[i1] = w.replace(String.valueOf(c), String.valueOf(i));
      }
      String newResult = result.replace(String.valueOf(c), String.valueOf(i));
      if (backTrack(word, start + 1, newWords, newResult, map)) {
        // 搜索到一个答案就返回。不用继续搜索后面的分支。只需要一个答案。
        return true;
      }
      map.remove(c);
    }

    return false;
  }

  /**
   * 作者：4261
   * 链接：https://leetcode-cn.com/problems/verbal-arithmetic-puzzle/solution/java-7mscheng-gong-100guan-fang-er-quan-zhi-si-lu-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class S {
    private Map<Character, Integer> weights = new HashMap<>(10); // 字符映射到权值

    private char[] minusWeights = new char[7]; // 负权值排序

    private char[] plusWeights = new char[10]; // 正权值排序

    private char[] absWeights = new char[10]; // 绝对权值排序

    private boolean[] zeroUnable = new boolean[26]; // 为true代表不可为0

    private Map<Character, Integer> minNumber = new HashMap<>(10); // 最小可能数

    private Map<Character, Integer> maxNumber = new HashMap<>(10); // 最大可能数

    /**
     * @param words
     * @param result
     * @return
     */
    public boolean isSolvable(String[] words, String result) {
      // 基本权值计算与初始数据校验
      int maxLen = 0;
      for (String word : words) {
        if (word.length() > maxLen) {
          maxLen = word.length();
        }
        zeroUnable[word.charAt(0) - 'A'] = true;
        int weight = 1;
        int len = word.length();
        for (int i = 0; i < len; i++) {
          char c = word.charAt(len - i - 1);
          weights.put(c, weights.getOrDefault(c, 0) + weight);
          weight *= 10;
        }
      }

      int weight = 1;
      int resLen = result.length();
      for (int i = 0; i < resLen; i++) {
        char c = result.charAt(resLen - i - 1);
        weights.put(c, weights.getOrDefault(c, 0) - weight);
        weight *= 10;
      }

      // 有一点点晚的判断
      if (maxLen > result.length() || result.length() - maxLen > 1) {
        return false;
      }

      // 权值排序（顺带进行权值系数大小检测，正负差值达到十倍则不可能有解）
      int minusWeight = 0;
      int plusWeight = 0;
      for (Map.Entry entry : weights.entrySet()) {
        char c = (char) entry.getKey();
        int wei = (int) entry.getValue();
        if (wei < 0) {
          minusWeight += wei;
          for (int i = 0; i < minusWeights.length; i++) {
            if (minusWeights[i] == 0) {
              minusWeights[i] = c;
              break;
            } else if (wei < weights.get(minusWeights[i])) {
              if (minusWeights.length - 1 - i >= 0) {
                System.arraycopy(minusWeights, i, minusWeights, i + 1, minusWeights.length - 1 - i);
              }
              minusWeights[i] = c;
              break;
            }
          }
        } else {
          plusWeight += wei;
          for (int i = 0; i < plusWeights.length; i++) {
            if (plusWeights[i] == 0) {
              plusWeights[i] = c;
              break;
            } else if (wei > weights.get(plusWeights[i])) {
              if (plusWeights.length - 1 - i >= 0) {
                System.arraycopy(plusWeights, i, plusWeights, i + 1, plusWeights.length - 1 - i);
              }
              plusWeights[i] = c;
              break;
            }
          }
        }

        int absWei = Math.abs(wei);
        for (int i = 0; i < absWeights.length; i++) {
          if (absWeights[i] == 0) {
            absWeights[i] = c;
            break;
          }
          if (absWei > Math.abs(weights.get(absWeights[i]))) {
            if (absWeights.length - 1 - i >= 0) {
              System.arraycopy(absWeights, i, absWeights, i + 1, absWeights.length - 1 - i);
            }
            absWeights[i] = c;
            break;
          }
        }
      }

      if (minusWeight == 0 && plusWeight == 0) {
        return true;
      }
      if (minusWeight == 0 || plusWeight == 0) {
        return false;
      }
      if (-minusWeight / plusWeight >= 10 || plusWeight / -minusWeight >= 10) {
        return false;
      }

      int[] arr = new int[26];
      Arrays.fill(arr, -1);
      return dfs(new char[10], arr, 0);
    }

    /**
     * @param numberMapToChar
     * @param absIdx
     * @return
     */
    private boolean dfs(char[] numberMapToChar, int[] charMapToNumber, int absIdx) {
      if (absIdx >= absWeights.length || absWeights[absIdx] == 0) {
        int sum = 0;
        for (Map.Entry entry : weights.entrySet()) {
          int num = charMapToNumber[(char) entry.getKey() - 'A'];
          sum += num * (int) entry.getValue();
        }
        return sum == 0;
      }
      char[] minTempMap = new char[10];
      char[] maxTempMap = new char[10];
      char c = absWeights[absIdx];
      int wei = weights.get(c);
      if (wei == 0) {
        return dfs(numberMapToChar, charMapToNumber, absIdx + 1);
      }
      int max = 0;
      int min = 0;

      // 在此处，对当前递归的权值做了区间判断
      for (int i = 0; i < absWeights.length && absWeights[i] != 0; i++) {
        char cc = absWeights[i];
        if (cc == c) {
          continue;
        }
        int w = weights.get(cc);
        if (charMapToNumber[cc - 'A'] != -1) {
          max += charMapToNumber[cc - 'A'] * w;
          min += charMapToNumber[cc - 'A'] * w;
          continue;
        }

        Integer ccMax = maxNumber.getOrDefault(cc, 9);
        Integer ccMin;
        if (zeroUnable[cc - 'A']) {
          ccMin = minNumber.getOrDefault(cc, 1);
        } else {
          ccMin = minNumber.getOrDefault(cc, 0);
        }
        int maxL = -1;
        int minL = -1;

        boolean o = ((wei >>> 31) ^ (w >>> 31)) == 0;
        if (o) {
          for (int j = ccMin; j <= ccMax; j++) {
            if (maxTempMap[j] == 0 && numberMapToChar[j] == 0) {
              maxTempMap[j] = cc;
              maxL = j;
              break;
            }
          }
          for (int j = ccMax; j >= ccMin; j--) {
            if (minTempMap[j] == 0 && numberMapToChar[j] == 0) {
              minTempMap[j] = cc;
              minL = j;
              break;
            }
          }
        } else {
          for (int j = ccMax; j >= ccMin; j--) {
            if (maxTempMap[j] == 0 && numberMapToChar[j] == 0) {
              maxTempMap[j] = cc;
              maxL = j;
              break;
            }
          }
          for (int j = ccMin; j <= ccMax; j++) {
            if (minTempMap[j] == 0 && numberMapToChar[j] == 0) {
              minTempMap[j] = cc;
              minL = j;
              break;
            }
          }
        }

        if (maxL == -1 || minL == -1) {
          return false;
        }

        max += maxL * w;
        min += minL * w;
      }
      maxNumber.put(c, Math.min(-max / wei, 9));
      if (zeroUnable[c - 'A']) {
        minNumber.put(c, Math.max((int) Math.ceil(-min / wei), 1));
      } else {
        minNumber.put(c, Math.max((int) Math.ceil(-min / wei), 0));
      }

      int begin = minNumber.get(c);
      int end = maxNumber.get(c);
      for (int i = begin; i <= end; i++) {
        if (numberMapToChar[i] != 0) {
          continue;
        }
        numberMapToChar[i] = c;
        charMapToNumber[c - 'A'] = i;
        if (dfs(numberMapToChar, charMapToNumber, absIdx + 1)) {
          return true;
        }
        numberMapToChar[i] = 0;
        charMapToNumber[c - 'A'] = -1;
      }

      maxNumber.remove(c);
      minNumber.remove(c);
      return false;
    }
  }
}
