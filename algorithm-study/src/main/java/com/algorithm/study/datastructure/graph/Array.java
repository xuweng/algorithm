package com.algorithm.study.datastructure.graph;

/**
 * 数组
 * <p>
 * 插入,删除最后一个元素不用移动元素
 */
public class Array {
    //容量
    private static int capacity = 16;
    //大小
    private static int size = 0;
    //加载因子
    private static double loadFactor = 0.75;
    //缩容因子
    private static double shrinkFactor = 0.25;

    private static int[] table = new int[capacity];

    /**
     * 移动插入
     * <p>
     * 在有数据区域插入需要移动,在没有数据区域插入不需要移动
     *
     * @param date 数据
     * @param k    数组下标.插入到第k个位置 0<=k<=capacity-1
     * @return
     */
    public static int insertMove(int date, int k) {
        checkIndexByCapacity(k);
        //扩容
        resize();
        //在数组的末尾插入元素，那就不需要移动数据
        if (k == capacity - 1) {
            table[k] = date;
        } else {
            //k后面没有数据不需要移动
            for (int i = k; i < capacity; i++) {
                table[i + 1] = table[i];
            }
            table[k] = date;
        }
        size++;
        return date;
    }

    /**
     * 不移动插入
     * <p>
     * 在有数据区域插入需要移动,在没有数据区域插入不需要移动
     *
     * @param date 数据
     * @param k    下标.插入到第k个位置 0<=k<=capacity-1
     * @return
     */
    public static int insertNoMove(int date, int k) {
        checkIndexByCapacity(k);
        //扩容
        resize();
        //在数组的末尾插入元素，那就不需要移动数据
        if (k == capacity - 1) {
            table[k] = date;
        } else {
            //k后面没有数据不需要移动
            table[capacity - 1] = table[k];
            table[k] = date;
        }
        size++;
        return date;
    }

    /**
     * 删除
     * <p>
     * 在有数据区域插入需要删除,在没有数据区域插入不需要删除
     *
     * @param k 数组下标.删除第k个位置
     * @return
     */
    public static int remove(int k) {
        checkIndexByCapacity(k);

        //在数组的末尾删除元素，那就不需要移动数据
        if (k == capacity - 1) {
            table[k] = 0;
        } else {
            //k后面没有数据不需要移动
            for (int i = k; i < capacity; i++) {
                table[i] = table[i + 1];
            }
        }
        size--;
        return k;
    }

    /**
     * 根据size检查index
     *
     * @param index
     * @return
     */
    private static void checkIndexBySize(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 根据capacity检查index
     *
     * @param index
     * @return
     */
    private static void checkIndexByCapacity(int index) {
        if (index < 0 || index >= capacity) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 2倍扩容
     */
    private static void resize() {
        if (!resizeStrategy()) {
            return;
        }
        int newCapacity = capacity * 2;
        int[] newTable = new int[newCapacity];

        for (int i = 0; i < capacity - 1; i++) {
            newTable[i] = table[i];
        }
        capacity = newCapacity;
        table = newTable;
    }

    /**
     * 2倍缩容
     */
    private static void shrink() {
        if (!shrinkStrategy()) {
            return;
        }
        int newCapacity = capacity / 2;
        int[] newTable = new int[newCapacity];

        for (int i = 0; i < capacity - 1; i++) {
            newTable[i] = table[i];
        }
        capacity = newCapacity;
        table = newTable;
    }

    /**
     * 扩容策略
     *
     * @return
     */
    private static boolean resizeStrategy() {
        //return size >= capacity;
        return size >= loadFactor * capacity;
    }

    /**
     * 缩容策略
     *
     * @return
     */
    private static boolean shrinkStrategy() {
        //return size >= capacity;
        return size <= shrinkFactor * capacity;
    }

}
