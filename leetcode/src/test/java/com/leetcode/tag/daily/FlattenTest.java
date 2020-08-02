package com.leetcode.tag.daily;

import org.junit.Test;

public class FlattenTest {
    Flatten flatten = new Flatten();

    @Test
    public void flattenTest() {
        Flatten.Solution solution = flatten.new Solution();

        Flatten.TreeNode root = new Flatten.TreeNode(1);

        Flatten.TreeNode root1 = new Flatten.TreeNode(2);
        Flatten.TreeNode root2 = new Flatten.TreeNode(5);
        Flatten.TreeNode root3 = new Flatten.TreeNode(3);
        Flatten.TreeNode root4 = new Flatten.TreeNode(4);
        Flatten.TreeNode root5 = new Flatten.TreeNode(6);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.right = root5;

        solution.flatten(root);
    }
}
