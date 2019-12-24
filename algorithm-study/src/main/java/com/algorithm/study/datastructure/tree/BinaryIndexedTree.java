package com.algorithm.study.datastructure.tree;

/**
 * 树状数组的Java版本，created by 曹艳丰  2016.07.09
 * 原理参考：http://www.hawstein.com/posts/binary-indexed-trees.html
 * 或：https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 */
public class BinaryIndexedTree {
    public int length;
    private int[] tree;

    /**
     * 为了统一下标，所以tree[0]不被使用，数组有效范围1~length。
     */
    public BinaryIndexedTree(int length) {
        this.length = length;
        tree = new int[length + 1];
    }

    /**
     * 计算1~index范围内和
     * index一直减去lowBit(index)，直到index为0
     */
    public int sum(int index) {
        if (index < 1 && index > length) {
            throw new IllegalArgumentException("Out of Range!");
        }
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }

    /**
     * 计算start~end范围内和
     */
    public int sum(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    /**
     * index一直加上lowBit(index)，直到index为length。这些位置的值都加上value
     */
    public void put(int index, int value) {
        if (index < 1 && index > length) {
            throw new IllegalArgumentException("Out of Range!");
        }
        while (index <= length) {
            tree[index] += value;
            index += lowBit(index);
        }
    }

    /**
     * index一直减去lowBit(index)，直到index为length。这些位置的值都加上value
     */
    public int get(int index) {
        if (index < 1 && index > length) {
            throw new IllegalArgumentException("Out of Range!");
        }
        int sum = tree[index];
        int z = index - lowBit(index);
        index--;
        while (index != z) {
            sum -= tree[index];
            index -= lowBit(index);
        }
        return sum;
    }

    /**
     * 从a数组如何获得c数组呢？这里要借助lowBit(int K)函数。lowBit(int K)函数保留k的二进制最低位1的值。
     * 例如，1110保留最低位1即0010。
     * <p>
     * 保留k的二进制最低位1的值。例如，1110保留最低位1即0010.
     */
    private static int lowBit(int k) {
        return k & -k;
    }
}

