package com.jianzi.offer.study;

import com.jianzi.offer.study.tree.Trees;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TreesTests {
    private static Trees.TreeNode treeNode;

    @BeforeAll
    static void init() {
        treeNode = Trees.generateTree(1, 3);
    }

    @Test
    public void printfPre() {
        Trees.printfPre(treeNode);
    }

    @Test
    public void constructBinaryTree() {
        int[] preArray = {1, 2, 4, 7, 3, 5, 6, 8};
        int preStart = 0;
        int preEnd = preArray.length - 1;
        int[] middleArray = {4, 7, 2, 1, 5, 3, 8, 6};
        int middleStart = 0;
        int middleEnd = middleArray.length - 1;
        Trees.TreeNode node = Trees.constructBinaryTree(preArray, preStart, preEnd, middleArray, middleStart, middleEnd);

        Trees.printfPre(node);
    }
}
