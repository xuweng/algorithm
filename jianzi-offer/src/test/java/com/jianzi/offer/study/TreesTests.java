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
}
