package com.leetcode.tag.daily.two;

import org.junit.Test;

public class LevelOrderBottomTest {
    LevelOrderBottom.Solution2 solution2 = new LevelOrderBottom.Solution2();

    @Test
    public void levelOrderBottomTest() {
        LevelOrderBottom.TreeNode treeNode3 = new LevelOrderBottom.TreeNode(3);
        LevelOrderBottom.TreeNode treeNode9 = new LevelOrderBottom.TreeNode(9);
        LevelOrderBottom.TreeNode treeNode20 = new LevelOrderBottom.TreeNode(20);
        LevelOrderBottom.TreeNode treeNode15 = new LevelOrderBottom.TreeNode(15);
        LevelOrderBottom.TreeNode treeNode7 = new LevelOrderBottom.TreeNode(7);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        solution2.levelOrderBottom(treeNode3);
    }
}