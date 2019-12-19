package com.algorithm.study.datastructure.queue;

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

    /**
     * 实际上，我们在出队时可以不用搬移数据。如果没有空闲空间了，我们只需要在入队时，再集中触发一次数据的搬移操作
     * <p>
     * 当队列的 tail 指针移动到数组的最右边后，如果有新的数据入队，我们可以将 head 到 tail 之间的数据，
     * 整体搬移到数组中 0 到 tail-head 的位置。
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // tail == n表示队列末尾没有空间了
        if (isFull()) {
            // tail ==n && head==0，表示整个队列都占满了,不用搬移
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
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