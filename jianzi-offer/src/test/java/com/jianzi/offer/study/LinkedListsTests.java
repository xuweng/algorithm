package com.jianzi.offer.study;


import com.jianzi.offer.study.linkedlist.LinkedLists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListsTests {
    private static LinkedLists.Node<Integer> headNode;

    @BeforeAll
    static void init() {
        headNode = LinkedLists.generateLinkedList(20);
    }

    @Test
    public void findKthToTail() {
        LinkedLists.Node<Integer> node = LinkedLists.findKthToTail(headNode, 2);

        assertEquals(19, node.getData());
    }
}
