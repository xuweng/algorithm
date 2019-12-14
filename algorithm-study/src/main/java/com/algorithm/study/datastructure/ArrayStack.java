package com.algorithm.study.datastructure;


// 基于数组实现的顺序栈
public class ArrayStack {
    private String[] items;  // 数组
    private int size;       // 栈中元素个数
    private int top;       // 栈顶指针,数组下标
    private int capacity;    //容量

    // 初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.top = -1;
    }

    // 入栈操作
    public boolean push(String item) {
        // 数组空间不够了，直接返回false，入栈失败。
        if (isFull()) {
            return false;
        }
        // 将item放到下标为top的位置
        items[++top] = item;
        ++size;
        return true;
    }

    // 出栈操作
    public String pop() {
        // 栈为空，则直接返回null
        if (isEmpty()) {
            return null;
        }
        // 返回下标为count-1的数组元素，并且栈中元素个数count减一
        String tmp = items[top];
        --size;
        return tmp;
    }

    /**
     * 栈空
     *
     * @return
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * 栈满
     *
     * @return
     */
    private boolean isFull() {
        return size >= capacity;
    }
}
