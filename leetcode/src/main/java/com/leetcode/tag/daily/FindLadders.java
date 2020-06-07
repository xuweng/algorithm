package com.leetcode.tag.daily;

import java.util.*;

/**
 * 126. 单词接龙 II
 */
public class FindLadders {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    return null;
  }

  /**
   * 方法一：广度优先搜索 思路
   *
   * <p>本题要求的是最短转换序列，看到最短首先想到的就是 BFS。想到 BFS 自然而然的就能想到图，但是本题并没有直截了当的给出图的模型，
   *
   * <p>因此我们需要把它抽象成图的模型。
   *
   * <p>我们可以把每个单词都抽象为一个点，如果两个单词可以只改变一个字母进行转换，那么说明他们之间有一条双向边
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/word-ladder-ii/solution/dan-ci-jie-long-ii-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId; // 单词到id的映射
    private ArrayList<String> idWord; // id到单词的映射
    private ArrayList<Integer>[] edges; // 图的边

    public Solution() {
      wordId = new HashMap<>();
      idWord = new ArrayList<>();
    }

    /**
     * 建图+bfs
     *
     * <p>建图+bfs
     *
     * <p>建图+bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      int id = 0;
      // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
      for (String word : wordList) {
        if (!wordId.containsKey(word)) {
          wordId.put(word, id++);
          idWord.add(word);
        }
      }
      // 若endWord不在wordList中 则无解
      if (!wordId.containsKey(endWord)) {
        return new ArrayList<>();
      }
      // 把beginWord也加入wordId中
      if (!wordId.containsKey(beginWord)) {
        wordId.put(beginWord, id++);
        idWord.add(beginWord);
      }

      // 初始化存边用的数组
      edges = new ArrayList[idWord.size()];
      for (int i = 0; i < idWord.size(); i++) {
        edges[i] = new ArrayList<>();
      }
      // 添加边
      for (int i = 0; i < idWord.size(); i++) {
        for (int j = i + 1; j < idWord.size(); j++) {
          // 若两者可以通过转换得到 则在它们间建一条无向边
          if (transformCheck(idWord.get(i), idWord.get(j))) {
            edges[i].add(j);
            edges[j].add(i);
          }
        }
      }

      int dest = wordId.get(endWord); // 目的ID
      List<List<String>> res = new ArrayList<>(); // 存答案
      int[] cost = new int[id]; // 到每个点的代价
      for (int i = 0; i < id; i++) {
        cost[i] = INF; // 每个点的代价初始化为无穷大
      }

      // 将起点加入队列 并将其cost设为0
      Queue<ArrayList<Integer>> q = new LinkedList<>();
      ArrayList<Integer> tmpBegin = new ArrayList<>();
      tmpBegin.add(wordId.get(beginWord));
      q.add(tmpBegin);
      cost[wordId.get(beginWord)] = 0;

      // 开始广度优先搜索
      while (!q.isEmpty()) {
        ArrayList<Integer> now = q.poll();
        int last = now.get(now.size() - 1); // 最近访问的点
        if (last == dest) { // 若该点为终点则将其存入答案res中
          ArrayList<String> tmp = new ArrayList<>();
          for (int index : now) {
            tmp.add(idWord.get(index)); // 转换为对应的word
          }
          res.add(tmp);
        } else { // 该点不为终点 继续搜索
          for (int i = 0; i < edges[last].size(); i++) {
            int to = edges[last].get(i);
            // 此处<=目的在于把代价相同的不同路径全部保留下来
            if (cost[last] + 1 <= cost[to]) {
              cost[to] = cost[last] + 1;
              // 把to加入路径中
              ArrayList<Integer> tmp = new ArrayList<>(now);
              tmp.add(to);
              q.add(tmp); // 把这个路径加入队列
            }
          }
        }
      }
      return res;
    }

    // 两个字符串是否可以通过改变一个字母后相等
    boolean transformCheck(String str1, String str2) {
      int differences = 0;
      for (int i = 0; i < str1.length() && differences < 2; i++) {
        if (str1.charAt(i) != str2.charAt(i)) {
          ++differences;
        }
      }
      return differences == 1;
    }
  }
}
