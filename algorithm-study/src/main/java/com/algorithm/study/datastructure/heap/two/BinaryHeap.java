package com.algorithm.study.datastructure.heap.two;


import static com.algorithm.study.common.ArrayUtils.swap;

/**
 * 学习能力。方法。策略。不能盲目用时间去堆。
 * 告诉我结论我只能死记硬背。学习推理。学习推理。学习推理。记不住的。
 * 死记硬背记不住的。死记硬背记不住的。死记硬背记不住的。
 * <p>
 * 不能用时间去堆。不能用时间去堆。不能用时间去堆。
 * <p>
 * 完全二叉树。数组不能出现空洞。
 * <p>
 * 叶子结点在数组后面。第一个非叶子结点开始堆化。
 */
public class BinaryHeap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public BinaryHeap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (isFull()) {
            return; // 堆满了
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = i / 2;
        }
    }

    public int removeMax() {
        int top = a[1];
        if (isEmpty()) {
            return -1; // 堆中没有数据
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
        return top;
    }

    /**
     * 自上往下堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            //默认是左孩子
            int child = i * 2;
            if (child + 1 <= n && a[child] < a[child + 1]) {
                //右孩子
                child = child + 1;
            }
            if (child == i) {
                break;
            }
            swap(a, i, child);
            i = child;
        }
    }

    /**
     * 建堆。每个数据都是从上往下堆化。
     * 叶子节点往下堆化只能自己跟自己比较，所以我们直接从第一个非叶子节点开始，依次堆化就行了。
     * <p>
     * 堆的比较是结点与结点的父结点比较，是树的比较，不是普通数组的线性比较。
     *
     * @param a
     * @param n
     */
    private void buildHeap(int[] a, int n) {
        //直接从第一个非叶子节点开始
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 堆空
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 堆满
     *
     * @return
     */
    public boolean isFull() {
        return count >= n;
    }
}
