package com.algorithm.study.datastructure.graph;

/**
 * 数组
 */
public class Array {
    //容量
    private static int capacity = 16;
    //大小
    private static int size = 0;

    private static int[] table = new int[capacity];

    /**
     * 移动插入
     *
     * @param date 数据
     * @param k    插入到第k个位置 0<=k<=capacity-1
     * @return
     */
    public static int insertMove(int date, int k) {
        if (k < 0 || k >= capacity) {
            throw new IllegalArgumentException();
        }
        //扩容
        if (size >= capacity) {
            resize();
        }
        //在数组的末尾插入元素，那就不需要移动数据
        if (k == capacity - 1) {
            table[k] = date;
        } else {
            for (int i = k; i < size; i++) {
                table[i + 1] = table[i];
            }
            table[k] = date;
        }
        size++;
        return date;
    }

    /**
     * 不移动插入
     *
     * @param date 数据
     * @param k    下标.插入到第k个位置 0<=k<=capacity-1
     * @return
     */
    public static int insertNoMove(int date, int k) {
        if (k < 0 || k >= capacity) {
            throw new IllegalArgumentException();
        }
        //扩容
        if (size >= capacity) {
            resize();
        }
        //在数组的末尾插入元素，那就不需要移动数据
        if (k == capacity - 1) {
            table[k] = date;
        } else {
            table[size - 1] = table[k];
            table[k] = date;
        }
        size++;
        return date;
    }

    /**
     * 2倍扩容
     */
    private static void resize() {
        capacity = capacity * 2;
        int[] newTable = new int[capacity];

        for (int i = 0; i < size - 1; i++) {
            newTable[i] = table[i];
        }

        table = newTable;
    }

}
