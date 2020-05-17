package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * n 门课需要选，记为 0 到 n-1
 *
 * <p>给定一个包含 n 个节点的有向图 G，我们给出它的节点编号的一种排列，如果满足：
 *
 * <p>对于图 G 中的任意一条有向边 (u,v)，u 在排列中都出现在 v 的前面。
 *
 * <p>那么称该排列是图 G 的「拓扑排序」
 *
 * <p>如果图 G 中存在环（即图 G 不是「有向无环图」），那么图 G 不存在拓扑排序
 *
 * <p>如果图 G 是有向无环图，那么它的拓扑排序可能不止一种
 *
 * <p>作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请
 *
 * <p>注明出处。210. 课程表 II
 */
public class CourseSchedule {
  /**
   * 有了上述的简单分析，我们就可以将本题建模成一个求拓扑排序的问题了：
   *
   * <p>我们将每一门课看成一个节点；
   *
   * <p>如果想要学习课程 A 之前必须完成课程 B，那么我们从 B 到 A 连接一条有向边。
   *
   * <p>这样以来，在拓扑排序中，B一定出现在 A 的前面。
   *
   * <p>求出该图的拓扑排序，就可以得到一种符合要求的课程学习顺序
   *
   * @param numCourses
   * @param prerequisites
   * @return
   */
  List<Integer> list = new ArrayList<>();
  // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
  boolean[] visited;
  // 判断有向图中是否有环
  boolean invalid;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    visited = new boolean[numCourses];
    // 存储有向图.邻接矩阵
    int[][] edges = new int[numCourses][numCourses];
    for (int[] edge : prerequisites) {
      edges[edge[1]][edge[0]] = 1;
    }
    for (int i = 0; i < numCourses; i++) {
      if (!visited[i]) {
        dfs(i, edges);
      }
    }
    if (invalid) {
      return new int[]{};
    }
    int[] result = new int[numCourses];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }

  public void dfs(int root, int[][] edges) {
    list.add(root);
    visited[root] = true;
    // root的邻接结点
    int[] ling = edges[root];
    for (int i = 0; i < ling.length; i++) {
      if (ling[i] == 1) {
        // i是root的邻接结点
        if (visited[i]) {
          invalid = true;
          return;
        }
        dfs(i, edges);
      }
    }
  }

  class Solution {
    /**
     * 算法
     *
     * <p>关键是求结点的邻接结点
     *
     * <p>存在环.则环中每个结点的入度至少为1,不为0.环中每个结点都不会入队
     *
     * <p>算法模板.算法模板.算法模板
     *
     * <p>颜色标记结点,容易理解
     *
     * <p>颜色标记结点,容易理解
     *
     * <p>我们使用一个队列来进行广度优先搜索。初始时，所有入度为 0 的节点都被放入队列中，
     *
     * <p>它们就是可以作为拓扑排序最前面的节点，并且它们之间的相对顺序是无关紧要的。
     *
     * <p>在广度优先搜索的每一步中，我们取出队首的节点 u：
     *
     * <p>我们将 u 放入答案中；
     *
     * <p>我们移除 u 的所有出边，也就是将 u 的所有相邻节点的入度减少 1。如果某个相邻节点 v 的入度变为 0，那么我们就将 v 放入队列中。
     *
     * <p>在广度优先搜索的过程结束后。如果答案中包含了这 n 个节点，那么我们就找到了一种拓扑排序，否则说明图中存在环，也就不存在拓扑排序了。
     *
     * <p>代码模板.代码模板.代码模板.代码模板
     *
     * <p>BFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      // 存储有向图.邻接矩阵
      int[][] edges = new int[numCourses][numCourses];
      // 存储每个节点的入度
      // 引用计数法
      int[] input = new int[numCourses];
      // 保存入度为0的结点
      Queue<Integer> queue = new LinkedList<>();
      // 统计节点的入度
      for (int[] edge : prerequisites) {
        input[edge[0]]++;
        // edge[1]--------->edge[0]
        // row-------------->cou
        edges[edge[1]][edge[0]] = 1;
      }
      // 将入度为0的点入队
      for (int i = 0; i < numCourses; i++) {
        if (input[i] == 0) {
          queue.offer(i);
        }
      }
      int index = 0;
      // 存储答案
      int[] result = new int[numCourses];
      while (!queue.isEmpty()) {
        int node = queue.poll();
        result[index++] = node;
        // 修改node的邻接结点入度
        int[] ints = edges[node];
        for (int i = 0; i < ints.length; i++) {
          // 找到node的邻接结点
          if (ints[i] == 1) {
            // i是node的邻接结点
            // 擦掉边
            // node---------->edge
            ints[i] = 0;
            input[i]--;
            // 如果相邻节点 v 的入度为 0,v入队
            if (input[i] == 0) {
              queue.offer(i);
            }
          }
        }
      }
      // 出现环.环中所有结点入度至少为1.环中所有结点不会进入队列
      return index != numCourses ? new int[]{} : result;
    }
  }
}
