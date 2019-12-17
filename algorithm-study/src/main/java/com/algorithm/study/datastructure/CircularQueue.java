package com.algorithm.study.datastructure;

/**
 * 环形队列
 */

public class CircularQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 队列满了
        if (isFull()) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (isEmpty()) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    /**
     * 判空
     *
     * @return
     */
    private boolean isEmpty() {
        return head == tail;
    }

    /**
     * 判满
     *
     * @return
     */
    private boolean isFull() {
        return (tail + 1) % n == head;
    }
}
