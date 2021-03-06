package com.algorithm.study.datastructure.link;

import java.util.Objects;

/**
 * 链表
 */
public class LinkedList {
    private static SingleNode<Integer> singleHead = new SingleNode<>();
    private static SingleNode<Integer> singleTail = singleHead;

    private static DoubleNode<Integer> doubleHead = new DoubleNode<>();
    private static DoubleNode<Integer> doubleTail = doubleHead;

    //大小
    private static int size = 0;

    /**
     * 查找数据是否存在
     *
     * @param date 数据
     * @return
     */
    public static boolean exist(Integer date) {
        SingleNode<Integer> cur = singleHead.next;
        while (cur != null) {
            if (date.equals(cur.date)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 随机访问第 k 个元素
     *
     * @param k 不是下标
     * @return
     */
    public static Integer find(int k) {
        checkIndex(k);

        SingleNode<Integer> cur = singleHead;

        for (int i = 1; i <= k && cur != null; i++) {
            cur = cur.next;
        }
        return (cur == null) ? null : cur.date;
    }

    /**
     * 查找k前缀
     * <p>
     * 条件判断很麻烦
     * <p>
     * 三指针:prev,cur,next.
     * <p>
     * 前一个指针,当前指针,后一个指针
     *
     * @param k 不是下标
     * @return
     */
    public static SingleNode<Integer> findPrefix(int k) {
        checkIndex(k);

        SingleNode<Integer> prev = singleHead, cur = singleHead.next;
        for (int i = 1; i < k && cur != null && cur.next != null; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        return prev;

    }

    /**
     * 查找值前缀
     *
     * @param date 值
     * @return
     */
    public static SingleNode<Integer> findPrefix(Integer date) {
        SingleNode<Integer> prev = singleHead, cur = singleHead.next;
        while (cur != null && !date.equals(cur.date)) {
            prev = prev.next;
            cur = cur.next;
        }

        return (cur == null) ? null : prev;
    }

    /**
     * 查找结点前缀
     *
     * @param node
     * @return
     */
    public static SingleNode<Integer> findPrefix(SingleNode<Integer> node) {
        Objects.requireNonNull(node);

        SingleNode<Integer> prev = singleHead, cur = singleHead.next;
        while (cur != null && node != cur) {
            prev = prev.next;
            cur = cur.next;
        }

        return (cur == null) ? null : prev;
    }

    /**
     * 查找值后缀
     *
     * @param date 值
     * @return
     */
    public static SingleNode<Integer> findSuffix(Integer date) {
        SingleNode<Integer> cur = singleHead.next;
        while (cur != null && !date.equals(cur.date)) {
            cur = cur.next;
        }

        return (cur == null) ? null : cur.next;
    }

    /**
     * 查找结点后缀
     *
     * @param node
     * @return
     */
    public static SingleNode<Integer> findSuffix(SingleNode<Integer> node) {
        Objects.requireNonNull(node);

        SingleNode<Integer> cur = singleHead.next;
        while (cur != null && node != cur) {
            cur = cur.next;
        }

        return (cur == null) ? null : cur.next;
    }

    /**
     * 在date后面插入value
     *
     * @param date
     * @param value
     * @return
     */
    public static Integer insert(Integer date, Integer value) {
        SingleNode<Integer> prev = findPrefix(date);
        if (prev == null) {
            return value;
        }
        SingleNode<Integer> node = new SingleNode<>(value);
        node.next = prev.next;
        prev.next = node;

        singleTail = node;
        return value;
    }

    /**
     * 删除date结点
     *
     * @param date
     * @return
     */
    public static Integer remove(Integer date) {
        SingleNode<Integer> prev = findPrefix(date);
        if (prev == null) {
            return date;
        }
        if (singleTail.date.equals(date)) {
            singleTail = prev;
        }
        prev.next = prev.next.next;

        return date;
    }

    /**
     * 在node后面插入value
     *
     * @param node
     * @param value
     * @return
     */
    public static Integer insert(SingleNode<Integer> node, Integer value) {
        Objects.requireNonNull(node);

        SingleNode<Integer> prev = findPrefix(node);
        if (prev == null) {
            return value;
        }
        SingleNode<Integer> newNode = new SingleNode<>(value);
        newNode.next = prev.next;
        prev.next = newNode;

        singleTail = newNode;
        return value;
    }

    /**
     * 删除node结点
     *
     * @param node
     * @return
     */
    public static SingleNode<Integer> remove(SingleNode<Integer> node) {
        Objects.requireNonNull(node);

        SingleNode<Integer> prev = findPrefix(node);
        if (prev == null) {
            return node;
        }
        if (singleTail == node) {
            singleTail = prev;
        }
        prev.next = prev.next.next;
        return node;
    }

    /**
     * 在node后面插入value
     *
     * @param node
     * @param value
     * @return
     */
    public static Integer insertDoubleNode(DoubleNode<Integer> node, Integer value) {
        Objects.requireNonNull(node);

        //直接获取前缀
        DoubleNode<Integer> prev = node.prev;
        if (prev == null) {
            return value;
        }
        DoubleNode<Integer> newNode = new DoubleNode<>(value);
        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next.prev = newNode;
        prev.next = newNode;

        doubleTail = newNode;
        return value;
    }

    /**
     * 删除node结点
     *
     * @param node
     * @return
     */
    public static DoubleNode<Integer> removeDoubleNode(DoubleNode<Integer> node) {
        Objects.requireNonNull(node);

        //直接获取前缀
        DoubleNode<Integer> prev = node.prev;
        if (prev == null) {
            return node;
        }
        if (node == doubleTail) {
            doubleTail = prev;
        }
        DoubleNode<Integer> next = prev.next.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }

        return node;
    }

    /**
     * 检查index
     *
     * @param index
     * @return
     */
    private static void checkIndex(int index) {
        if (index <= 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 单链表
     *
     * @param <T>
     */
    static class SingleNode<T> {
        private T date;
        private SingleNode<T> next;

        public SingleNode() {
        }

        public SingleNode(T date) {
            this.date = date;
        }

        public SingleNode(T date, SingleNode<T> next) {
            this.date = date;
            this.next = next;
        }
    }

    /**
     * 双链表
     *
     * @param <T>
     */
    static class DoubleNode<T> {
        private T date;
        private DoubleNode<T> prev;
        private DoubleNode<T> next;

        public DoubleNode() {
        }

        public DoubleNode(T date) {
            this.date = date;
        }

        public DoubleNode(T date, DoubleNode<T> prev, DoubleNode<T> next) {
            this.date = date;
            this.prev = prev;
            this.next = next;
        }
    }
}
