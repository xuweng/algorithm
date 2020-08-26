package com.leetcode.tag.tree;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class ListOfDepthTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    ListOfDepth.Solution solution = new ListOfDepth.Solution();

    @Test
    public void listOfDepthTest() {
        ListOfDepth.TreeNode tree = new ListOfDepth.TreeNode(1);
        ListOfDepth.TreeNode tree1 = new ListOfDepth.TreeNode(2);
        ListOfDepth.TreeNode tree2 = new ListOfDepth.TreeNode(3);
        ListOfDepth.TreeNode tree3 = new ListOfDepth.TreeNode(4);
        ListOfDepth.TreeNode tree4 = new ListOfDepth.TreeNode(5);
        ListOfDepth.TreeNode tree5 = new ListOfDepth.TreeNode(7);
        ListOfDepth.TreeNode tree6 = new ListOfDepth.TreeNode(8);

        tree.left = tree1;
        tree.right = tree2;

        tree1.left = tree3;
        tree1.right = tree4;

        tree2.left = tree5;

        tree3.left = tree6;

        solution.listOfDepth(tree);
    }
}