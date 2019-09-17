package com.jianzi.offer.study;


import com.jianzi.offer.study.common.annotation.ExceptionUserCase;
import com.jianzi.offer.study.common.annotation.NormalUserCase;
import com.jianzi.offer.study.linkedlist.LinkedLists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListsTests {
    private static LinkedLists.Node<Integer> headNode;

    @BeforeAll
    static void init() {
        headNode = LinkedLists.generateLinkedList(20);
    }

    @NormalUserCase
    @Test
    public void findKthToTailSuccess() {
        //k是正常值
        LinkedLists.Node<Integer> node = LinkedLists.findKthToTail(headNode, 2);

        assertEquals(19, node.getData());
    }

    /**
     * 链表中的结点数小于k时
     */
    @ExceptionUserCase
    @Test
    public void findKthToTailFail1() {
        //链表中的结点数小于k时

        Throwable exception = assertThrows(NullPointerException.class, () -> {
            LinkedLists.Node<Integer> node = LinkedLists.findKthToTail(headNode, 30);
        });
    }

    /**
     * k<=0
     */
    @ExceptionUserCase
    @Test
    public void findKthToTailFail2() {
        //k<=0
        LinkedLists.Node<Integer> node = LinkedLists.findKthToTail(headNode, 0);

        assertEquals(20, node.getData());
    }
}
