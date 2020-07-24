package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 1025. 除数博弈
 *
 * <p>爱丽丝和鲍勃一起玩游戏，他们轮流行动
 *
 * <p>两个人都想赢,谁都想赢
 *
 * <p>没有思路看题解
 *
 * <p>算法肯定错了，不要浪费时间
 */
public class DivisorGame {
  /**
   * 1 <= N <= 1000
   */
  static class Solution {
    public boolean divisorGame(int N) {
      return backTrack(N, 0);
    }

    private boolean backTrack(int N, int count) {
      List<Integer> list = getCandidate(N);
      if (list.isEmpty()) {
        return count % 2 != 0;
      }

      for (int i : list) {
        if (backTrack(N - i, ++count)) {
          return true;
        }
      }

      return false;
    }

    /**
     * 选出任一 x，满足 0 < x < N 且 N % x == 0
     *
     * @param n
     * @return
     */
    private List<Integer> getCandidate(int n) {
      List<Integer> result = new ArrayList<>();

      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          result.add(i);
        }
      }

      return result;
    }
  }

  /**
   * 方法一：找规律
   *
   * <p>N 为奇数的时候 Alice（先手）必败，N 为偶数的时候 Alice 必胜
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/divisor-game/solution/chu-shu-bo-yi-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public boolean divisorGame(int N) {
      return N % 2 == 0;
    }
  }

  /**
   * 方法二：递推
   *
   * <p>注意:先手是相对的，谁都可以是先手
   *
   * <p>因此我们只要看是否存在一个 m 是必败的状态，那么 Alice 直接执行对应的操作让当前的数字变成 m，
   *
   * <p>Alice 就必胜了，如果没有任何一个是必败的状态的话，说明 Alice
   *
   * <p>无论怎么进行操作，最后都会让 Bob 处于必胜的状态，此时 Alice 是必败的。
   *
   * <p>定义 f[i] 表示当前数字 i 的时候先手是处于必胜态还是必败态，true 表示先手必胜，false表示先手必败，
   *
   * <p>从前往后递推，根据我们上文的分析，枚举 i 在 (0,i) 中 i 的因数 j，看是否存在 f[i−j] 为必败态即可。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/divisor-game/solution/chu-shu-bo-yi-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution2 {
    public boolean divisorGame(int N) {
      boolean[] f = new boolean[N + 5];

      f[1] = false;
      f[2] = true;
      for (int i = 3; i <= N; ++i) {
        for (int j = 1; j < i; ++j) {
          if ((i % j) == 0 && !f[i - j]) {
            f[i] = true;
            break;
          }
        }
      }

      return f[N];
    }
  }
}
