package com.algorithm.study.algorithm.lru;

import java.util.Objects;

/**
 * 缓存淘汰算法
 * <p>
 * 越靠近链表尾部的结点是越早之前访问的,最新数据保存在头部
 */
public class LRU {
    //头结点
    private static Node<Integer> head = new Node<>(-1);
    //尾结点
    private static Node<Integer> tail = head;
    //缓存容量
    private static Integer capacity = 100;
    //缓存大小
    private static Integer size = 0;

    /**
     * 插入
     *
     * @param date
     * @return
     */
    public static int insert(Integer date) {
        Node<Integer> pre = getPrefix(date);
        //如果此数据之前已经被缓存在链表中了,这时缓存大小没变
        if (pre != null) {
            //并将其从原来的位置删除
            //如果删除尾结点,更新尾指针
            if (pre.next == tail) {
                tail = pre;
            }
            pre.next = pre.next.next;
            //然后再插入到链表的头部
            insertHead(date);
        } else {
            //缓存未满
            if (size < capacity) {
                //此结点直接插入到链表的头部
                insertHead(date);
                size++;
            } else {
                //缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部
                Node<Integer> preT = getPrefix(tail);
                //更新尾指针
                tail = preT;
                preT.next = preT.next.next;
                insertHead(date);
            }
        }

        return date;

    }

    public static int getSize() {
        return size;
    }

    /**
     * 返回date的前缀
     *
     * @return
     */
    private static Node<Integer> getPrefix(Integer date) {
        Node<Integer> pre = head;

        while (pre.next != null) {
            if (date.equals(pre.next.date)) {
                return pre;
            }
            pre = pre.next;
        }

        return null;
    }

    /**
     * 返回结点的前缀
     *
     * @return
     */
    private static Node<Integer> getPrefix(Node<Integer> node) {
        Node<Integer> pre = head;

        while (pre.next != null) {
            if (node == pre.next) {
                return pre;
            }
            pre = pre.next;
        }

        return null;
    }

    /**
     * 头部插入结点
     *
     * @param date
     * @return
     */
    private static Node<Integer> insertHead(Integer date) {
        Node<Integer> node = new Node<>(date);
        node.next = head.next;
        head.next = node;

        return node;
    }

    /**
     * 头部插入结点
     *
     * @param node
     * @return
     */
    private static Node<Integer> insertHead(Node<Integer> node) {
        Objects.requireNonNull(node);

        node.next = head.next;
        head.next = node;

        return node;
    }

    /**
     * 结点
     *
     * @param <T>
     */
    private static class Node<T> {
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

