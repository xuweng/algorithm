package com.algorithm.study.datastructure.stack;


import java.util.Objects;

/**
 * 基于数组实现的顺序栈
 */
public class ArrayStack {
    private String[] elementData;  // 数组
    private int elementCount;       // 栈中元素个数
    private int top;       // 栈顶指针,数组下标
    private int capacity;    //容量

    // 初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int capacity) {
        this.elementData = new String[capacity];
        this.capacity = capacity;
        this.elementCount = 0;
        this.top = -1;
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    public boolean push(String item) {
        Objects.requireNonNull(item);
        // 数组空间不够了，直接返回false，入栈失败。
        if (isFull()) {
            return false;
        }
        // 将item放到下标为top的位置
        elementData[++top] = item;
        ++elementCount;
        return true;
    }

    /**
     * 出栈操作,删除栈顶元素
     *
     * @return
     */
    public String pop() {
        // 栈为空，则直接返回null
        if (isEmpty()) {
            return null;
        }
        // 返回下标为top的数组元素，并且栈中元素个数减一
        String result = peek();
        removeElementAt(top);
        top--;
        return result;
    }

    /**
     * 获取栈顶元素,不删除栈顶元素
     *
     * @return
     */
    public String peek() {
        // 栈为空，则直接返回null
        if (isEmpty()) {
            return null;
        }

        return elementData[top];
    }

    /**
     * 删除元素
     *
     * @param index 数组下标 0<=index<size
     * @return
     */
    public void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        //j在中间
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        //清空最后一个元素
        elementData[--elementCount] = null; /* to let gc do its work */
    }

    /**
     * 栈空
     *
     * @return
     */
    private boolean isEmpty() {
        return elementCount == 0;
    }

    public boolean empty() {
        return size() == 0;
    }

    /**
     * 元素个数
     *
     * @return
     */
    public int size() {
        return elementCount;
    }

    /**
     * 容量
     *
     * @return
     */
    public int capacity() {
        return elementData.length;
    }

    /**
     * 栈满
     *
     * @return
     */
    private boolean isFull() {
        return elementCount >= capacity;
    }

    /**
     * 清空所有元素
     */
    public void clear() {
        removeAllElements();
    }

    public void removeAllElements() {
        // Let gc do its work
        for (int i = 0; i < elementCount; i++) {
            elementData[i] = null;
        }

        elementCount = 0;
        top = -1;
    }
}
