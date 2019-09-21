package com.jianzi.offer.study.listnode;

import java.util.Objects;

/**
 * 链表
 * <p>
 * 特别注意条件范围
 * <p>
 * 抽取公共部分,比如查找等等
 */
public class ListNodes {
    /**
     * 尾插一个结点
     *
     * @param pHead
     * @param value
     * @return
     */
    public boolean addToTail(Node pHead, int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        //输入校验
        if (pHead == null) {
            pHead = node;
        } else {
            Node head = findLastNode(pHead);
            head.next = node;
        }

        return true;
    }

    /**
     * 根据值删除一个结点
     *
     * @param pHead
     * @param value
     * @return
     */
    public static boolean reMoveNode(Node pHead, int value) {
        //输入校验
        Objects.requireNonNull(pHead);
        Node pToBeDelete = pHead;
        if (pHead.value == value) {
            pToBeDelete = pHead;
            pHead = pHead.next;
        } else {
            Node preNode = findPreNode(pHead, value);
            if (preNode != null) {
                pToBeDelete = preNode.next;
                preNode.next = preNode.next.next;
            }
        }
        if (pToBeDelete != null) {
            pToBeDelete = null;
        }
        return true;
    }

    /**
     * 查找最后一个结点
     *
     * @param pHead 结点
     * @return 返回最后一个结点
     */
    public static Node findLastNode(Node pHead) {
        Objects.requireNonNull(pHead);
        Node pNode = pHead;

        while (pNode.next != null) {
            pNode = pNode.next;
        }

        return pNode;
    }

    /**
     * 根据value查找结点
     *
     * @param pHead 结点
     * @param value 值
     * @return 找到返回结点, 否则返回null
     */
    public static Node findNode(Node pHead, int value) {
        Objects.requireNonNull(pHead);
        Node pNode = pHead;

        while (pNode != null && pNode.value != value) {
            pNode = pNode.next;
        }

        return (pNode.value == value) ? pNode : null;
    }

    /**
     * 根据value查找前一个结点
     * <p>
     * 第一个结点没有头结点
     * 记录前一个结点
     *
     * @param pHead 结点
     * @param value 值
     * @return 找到返回前一个结点, 否则返回null
     */
    public static Node findPreNode(Node pHead, int value) {
        Objects.requireNonNull(pHead);
        Node pNode = pHead;
        Node pNodeNext = pHead.next;

        if (pNode.value == value) {
            return null;
        }
        while (pNodeNext != null && pNodeNext.value != value) {
            pNode = pNode.next;
            pNodeNext = pNodeNext.next;
        }

        return (pNodeNext.value == value) ? pNode : null;
    }

    /**
     * 链表结点
     */
    public static class Node {
        private int value;
        private Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
