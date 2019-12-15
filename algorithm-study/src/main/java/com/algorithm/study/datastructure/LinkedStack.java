package com.algorithm.study.datastructure;

import java.util.Objects;

/**
 * 基于链表实现的顺序栈,尾指针是栈顶
 */
public class LinkedStack {
    private static Node<String> head = new Node<>();
    private static Node<String> tail = head;

    public static boolean push(String item) {
        Objects.requireNonNull(item);

        Node<String> node = new Node<>(item);
        tail.next = node;
        tail = node;

        return true;
    }

    public static String pop() {
        // 栈为空，则直接返回null
        if (isEmpty()) {
            return null;
        }

        String value = tail.date;
        Node<String> prev = findPrefix(tail);
        //删除最后一个结点
        tail = null;
        prev.next = null;
        tail = prev;
        return value;
    }

    private static boolean isEmpty() {
        return head == tail;
    }

    /**
     * 查找结点前缀
     *
     * @param node
     * @return
     */
    public static Node<String> findPrefix(Node<String> node) {
        Objects.requireNonNull(node);

        Node<String> prev = head, cur = head.next;
        while (cur != null && node != cur) {
            prev = prev.next;
            cur = cur.next;
        }

        return (cur == null) ? null : prev;
    }

    /**
     * 单链表
     *
     * @param <T>
     */
    static class Node<T> {
        private T date;
        private Node<T> next;

        public Node() {
        }

        public Node(T date) {
            this.date = date;
        }

        public Node(T date, Node<T> next) {
            this.date = date;
            this.next = next;
        }
    }

}
