package com.leetcode.tag.daily.one;

/**
 * 十分钟没思路就看题解
 *
 * <p>十分钟没有思路就看题解
 *
 * <p>十分钟没有思路就看题解
 *
 * <p>十分钟没有思路就看题解
 *
 * <p>记住题解。记住题解。记住题解。记住题解。记住题解。记住题解。记住题解。记住题解。记住题解。记住题解。记住题解。记住题解
 *
 * <p>考数据结构。考数据结构。考数据结构。考数据结构。考数据结构。考数据结构。考数据结构。考数据结构。考数据结构
 *
 * <p>把示例看完。看完示例。看完示例。看完示例。看完示例。看完示例。看完示例。看完示例。看完示例。
 *
 * <p>搞懂示例。搞懂示例。搞懂示例。搞懂示例。搞懂示例。搞懂示例。搞懂示例。搞懂示例。搞懂示例。搞懂示例
 *
 * <p>并查集。并查集。并查集。并查集。并查集。并查集
 *
 * <p>并查集相关题目。并查集相关题目。
 *
 * <p>990. 等式方程的可满足性
 */
public class EquationsPossible {
  public boolean equationsPossible(String[] equations) {
    return false;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations/solution/deng-shi-fang-cheng-de-ke-man-zu-xing-by-leetcode-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean equationsPossible(String[] equations) {
      int length = equations.length;
      // 初始化
      int[] parent = new int[26];
      for (int i = 0; i < 26; i++) {
        parent[i] = i;
      }
      // 构建并查集
      for (String str : equations) {
        if (str.charAt(1) == '=') {
          int index1 = str.charAt(0) - 'a';
          int index2 = str.charAt(3) - 'a';
          union(parent, index1, index2);
        }
      }
      for (String str : equations) {
        if (str.charAt(1) == '!') {
          int index1 = str.charAt(0) - 'a';
          int index2 = str.charAt(3) - 'a';
          if (connected(parent, index1, index2)) {
            return false;
          }
        }
      }
      return true;
    }

    /**
     * 是否连通
     *
     * @param parent
     * @param index1
     * @param index2
     * @return
     */
    public boolean connected(int[] parent, int index1, int index2) {
      return find(parent, index1) == find(parent, index2);
    }

    public void union(int[] parent, int index1, int index2) {
      parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
      while (parent[index] != index) {
        parent[index] = parent[parent[index]];
        index = parent[index];
      }
      return index;
    }
  }
}
