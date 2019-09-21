package com.jianzi.offer.study;

import com.jianzi.offer.study.listnode.ListNodes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListNodesTests {
    private static ListNodes.Node headNode;

    @BeforeAll
    static void init() {
        headNode = ListNodes.generateLinkedList(20);
    }

    @Test
    public void addToTailTest() {
        ListNodes.addToTail(headNode, 21);

        ListNodes.printf(headNode);
    }

    @Test
    public void findLastNode() {
        ListNodes.Node node = ListNodes.findLastNode(headNode);
        assertEquals(20, node.getValue());
    }

    @Test
    public void findPreNode() {
        ListNodes.Node node = ListNodes.findPreNode(headNode, 2);
        assert node != null;
        assertEquals(1, node.getValue());
    }

    @Test
    public void findPreNode2() {
        ListNodes.Node node = ListNodes.findPreNode(headNode, 1);
        assertNull(node);
    }

    @Test
    public void findNode() {
        ListNodes.Node node = ListNodes.findNode(headNode, 10);
        assert node != null;
        assertEquals(10, node.getValue());
    }

    @Test
    public void reMoveNode() {
        ListNodes.reMoveNode(headNode, 2);
        ListNodes.printf(headNode);
    }

    @Test
    public void printfReversingTest() {
        ListNodes.printfReversing(headNode);
    }

    @Test
    public void printfReversingUseStack() {
        ListNodes.printfReversingUseStack(headNode);
    }
}
