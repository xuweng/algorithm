package com.algorithm.study.datastructure;

/**
 * 用数组实现的队列
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = head;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已经满了
        if (isFull()) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (isEmpty()) {
            return null;
        }
        // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
        String ret = items[head];
        ++head;
        return ret;
    }


    /**
     * 队满
     *
     * @return
     */
    private boolean isFull() {
        return tail >= n;
    }

    /**
     * 队空
     *
     * @return
     */
    private boolean isEmpty() {
        return head == tail;
    }
}