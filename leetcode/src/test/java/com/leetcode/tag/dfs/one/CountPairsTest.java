package com.leetcode.tag.dfs.one;

import org.junit.Test;

public class CountPairsTest {
    CountPairs.Solution solution = new CountPairs.Solution();

    @Test
    public void countPairsTest() {
        CountPairs.TreeNode treeNode = new CountPairs.TreeNode(1);
        CountPairs.TreeNode left = new CountPairs.TreeNode(2);

        treeNode.left = left;

        int distance = 3;
        solution.countPairs(treeNode, distance);
    }

}