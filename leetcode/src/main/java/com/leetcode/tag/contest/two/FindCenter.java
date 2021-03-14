package com.leetcode.tag.contest.two;

/**
 * 5702. 找出星型图的中心节点
 */
public class FindCenter {
    class Solution {
        public int findCenter(int[][] edges) {
            if (edges == null || edges.length == 0) {
                return -1;
            }
            if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
                return edges[0][0];
            }
            if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]) {
                return edges[0][1];
            }

            return -1;
        }
    }
}
