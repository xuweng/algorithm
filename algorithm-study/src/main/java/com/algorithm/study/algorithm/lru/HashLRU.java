package com.algorithm.study.algorithm.lru;

import java.util.Objects;

/**
 * 散列表和链表两种数据结构组合使用
 */
public class HashLRU {
    //缓存容量
    private static Integer capacity = 100;
    //缓存大小
    private static Integer size = 0;
    //头结点
    private static Node<Integer> head = new Node<>(-1);
    //尾结点
    private static Node<Integer> tail = head;

    private static Node<Integer>[] table = new Node[capacity];

    public static int find(Integer date) {
        int index = hash(date);
        Node<Integer> node = getPrefix(table[index], date);
        if (node != null) {
            //当找到数据之后，我们还需要将它删除,然后插入到双向链表的尾部

        }

        return -1;
    }


    /**
     * 插入尾部
     *
     * @param date
     * @return
     */
    private static Node<Integer> insertTail(Integer date) {
        Node<Integer> node = new Node<>(date);
        tail.next = node;
        tail = node;

        return node;
    }

    /**
     * 返回date的前驱
     *
     * @return
     */
    private static Node<Integer> getPrefix(Node<Integer> node, Integer date) {
        Objects.requireNonNull(node);
        //没有头结点,第一个元素没有前缀,最后一个元素没有后缀
        Node<Integer> pre = node;

        while (pre.next != null) {
            if (date.equals(pre.next.date)) {
                return pre;
            }
            pre = pre.next;
        }

        return null;
    }

    /**
     * 返回找到的结点
     *
     * @param node
     * @param date
     * @return
     */
    private static Node<Integer> findNode(Node<Integer> node, Integer date) {
        Objects.requireNonNull(node);

        while (node != null) {
            if (date.equals(node.date)) {
                return node;
            }

            node = node.hNext;
        }
        return null;
    }

    /**
     * 简单hash
     *
     * @param date
     * @return
     */
    private static int hash(int date) {
        return date - 1;
    }

    private static class Node<T> {
        private T date;
        private Node<T> prev;
        private Node<T> next;
        //hnext 指针是为了将结点串在散列表的拉链中
        private Node<T> hNext;

        public Node() {
        }

        public Node(T date) {
            this.date = date;
        }
    }
}
