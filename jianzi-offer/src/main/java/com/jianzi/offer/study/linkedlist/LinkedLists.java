package com.jianzi.offer.study.linkedlist;

import java.util.Objects;

/**
 * 链表
 * <p>
 * 考虑边界条件、特殊输入、错误处理
 */
public class LinkedLists {
    /**
     * 链表倒数第k个结点
     * k的取值就是链表的范围
     *
     * @param headNode 头结点
     * @param k        第k个
     * @param size     链表大小
     * @return 链表倒数第k个结点
     */
    public static Node<Integer> findKthToTail(Node<Integer> headNode, int k, int size) {
        Objects.requireNonNull(headNode);

        if (k > size || k <= 0) {
            throw new IllegalArgumentException();
        }
        //前指针
        Node<Integer> pAhead = headNode.next;
        //后指针
        Node<Integer> pBehind = headNode.next;

        for (int i = 0; i < k - 1; i++) {
            pAhead = pAhead.next;
        }

        while (pAhead.getNext() != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }

    /**
     * 顺序生成带头结点自然数链表,头结点时0
     *
     * @param size 个数
     * @return 头结点
     */
    public static Node<Integer> generateLinkedList(int size) {
        Node<Integer> head = new Node<>(0, null);
        Node<Integer> result = head;
        for (int i = 1; i <= size; i++) {
            Node<Integer> node = new Node<>(i, null);
            head.next = node;

            head = node;
        }

        return result;
    }

    public static class Node<T> {
        T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
