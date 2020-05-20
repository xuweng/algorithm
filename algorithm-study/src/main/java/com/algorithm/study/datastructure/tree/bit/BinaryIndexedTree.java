package com.algorithm.study.datastructure.tree.bit;

/**
 * C[1] = C[0001] = A[1];
 * <p>
 *         C[2] = C[0010] = A[1]+A[2];
 * <p>
 *         C[3] = C[0011] = A[3];
 * <p>
 *         C[4] = C[0100] = A[1]+A[2]+A[3]+A[4];
 * <p>
 *         C[5] = C[0101] = A[5];
 * <p>
 *         C[6] = C[0110] = A[5]+A[6];
 * <p>
 *         C[7] = C[0111] = A[7];
 * <p>
 *         C[8] = C[1000] = A[1]+A[2]+A[3]+A[4]+A[5]+A[6]+A[7]+A[8];
 * <p>
 * 对照式子可以发现  C[i]=A[i-2^k+1]+A[i-2^k+2]+......A[i]; （k为i的二进制中从最低位到高位连续零的长度）例如i=8(1000)时，k=3;
 * <p>
 * C[8] = A[8-2^3+1]+A[8-2^3+2]+......+A[8]
 * ————————————————
 * 版权声明：本文为CSDN博主「bestsort」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/bestsort/article/details/80796531
 * <p>
 * <p>
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

