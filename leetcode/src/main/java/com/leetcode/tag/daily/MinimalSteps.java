package com.leetcode.tag.daily;

import java.util.*;

/**
 * LCP 13. 寻宝
 */
public class MinimalSteps {
  /**
   * 方法一：状态压缩动态规划
   *
   * <p>这道题是一个非常经典的状态压缩动态规划模型：有 n 个任务 {M1,M2⋯Mn}，每两个任务之间有一个
   *
   * <p>c(Mi,Mj) 表示在 Mi ​之后（下一个）做 Mj ​的花费，让你求解把 n 个任务都做完需要的最小花费
   *
   * <p>这类问题的状态设计一般都是f(mask,i) 表示当前任务完成的状态是 mask，当前位置是i，
   *
   * <p>考虑转移的时候我们只需要考虑当前任务的上一个任务即可
   *
   * <p>原问题：起点开始，我们最少需要多少步才能最后拿到宝藏呢？
   *
   * <p>抽取原问题的变量。f(i,j)?
   *
   * <p>最后拿到宝藏。不是简单的计数dp。
   *
   * <p>最优dp。区间dp。计数dp。是否dp。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/xun-bao/solution/xun-bao-bfs-dp-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m;

    public int minimalSteps(String[] maze) {
      n = maze.length;
      m = maze[0].length();
      // 机关 & 石头
      List<int[]> buttons = new ArrayList<>();
      List<int[]> stones = new ArrayList<>();
      // 起点 & 终点
      int sx = -1, sy = -1, tx = -1, ty = -1;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (maze[i].charAt(j) == 'M') {
            buttons.add(new int[]{i, j});
          }
          if (maze[i].charAt(j) == 'O') {
            stones.add(new int[]{i, j});
          }
          if (maze[i].charAt(j) == 'S') {
            sx = i;
            sy = j;
          }
          if (maze[i].charAt(j) == 'T') {
            tx = i;
            ty = j;
          }
        }
      }
      int nb = buttons.size();
      int ns = stones.size();
      int[][] startDist = bfs(sx, sy, maze);

      // 边界情况：没有机关
      if (nb == 0) {
        return startDist[tx][ty];
      }
      // 从某个机关到其他机关 / 起点与终点的最短距离。
      int[][] dist = new int[nb][nb + 2];
      for (int i = 0; i < nb; i++) {
        Arrays.fill(dist[i], -1);
      }
      // 中间结果
      int[][][] dd = new int[nb][][];
      for (int i = 0; i < nb; i++) {
        int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
        dd[i] = d;
        // 从某个点到终点不需要拿石头
        dist[i][nb + 1] = d[tx][ty];
      }

      for (int i = 0; i < nb; i++) {
        int tmp = -1;
        for (int[] stone : stones) {
          int midX = stone[0], midY = stone[1];
          if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {
            if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {
              tmp = dd[i][midX][midY] + startDist[midX][midY];
            }
          }
        }
        dist[i][nb] = tmp;
        for (int j = i + 1; j < nb; j++) {
          int mn = -1;
          for (int[] stone : stones) {
            int midX = stone[0], midY = stone[1];
            if (dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1) {
              if (mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY]) {
                mn = dd[i][midX][midY] + dd[j][midX][midY];
              }
            }
          }
          dist[i][j] = mn;
          dist[j][i] = mn;
        }
      }

      // 无法达成的情形
      for (int i = 0; i < nb; i++) {
        if (dist[i][nb] == -1 || dist[i][nb + 1] == -1) {
          return -1;
        }
      }

      // dp 数组， -1 代表没有遍历到
      int[][] dp = new int[1 << nb][nb];
      for (int i = 0; i < 1 << nb; i++) {
        Arrays.fill(dp[i], -1);
      }
      for (int i = 0; i < nb; i++) {
        dp[1 << i][i] = dist[i][nb];
      }

      // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
      for (int mask = 1; mask < (1 << nb); mask++) {
        for (int i = 0; i < nb; i++) {
          // 当前 dp 是合法的
          if ((mask & (1 << i)) != 0) {
            for (int j = 0; j < nb; j++) {
              // j 不在 mask 里
              if ((mask & (1 << j)) == 0) {
                int next = mask | (1 << j);
                if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
                  dp[next][j] = dp[mask][i] + dist[i][j];
                }
              }
            }
          }
        }
      }

      int ret = -1;
      int finalMask = (1 << nb) - 1;
      for (int i = 0; i < nb; i++) {
        if (ret == -1 || ret > dp[finalMask][i] + dist[i][nb + 1]) {
          ret = dp[finalMask][i] + dist[i][nb + 1];
        }
      }

      return ret;
    }

    public int[][] bfs(int x, int y, String[] maze) {
      int[][] ret = new int[n][m];
      for (int i = 0; i < n; i++) {
        Arrays.fill(ret[i], -1);
      }
      ret[x][y] = 0;
      Queue<int[]> queue = new LinkedList<int[]>();
      queue.offer(new int[]{x, y});
      while (!queue.isEmpty()) {
        int[] p = queue.poll();
        int curx = p[0], cury = p[1];
        for (int k = 0; k < 4; k++) {
          int nx = curx + dx[k], ny = cury + dy[k];
          if (inBound(nx, ny) && maze[nx].charAt(ny) != '#' && ret[nx][ny] == -1) {
            ret[nx][ny] = ret[curx][cury] + 1;
            queue.offer(new int[]{nx, ny});
          }
        }
      }
      return ret;
    }

    public boolean inBound(int x, int y) {
      return x >= 0 && x < n && y >= 0 && y < m;
    }
  }
}
