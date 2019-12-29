package com.algorithm.study.datastructure.heap.one;


import java.util.Arrays;

/**
 * https://blog.csdn.net/lcore/article/details/9100073
 * <p>
 * 只看优秀代码
 * 只看优秀代码
 * 只看优秀代码
 * 不看垃圾代码
 * 不看垃圾代码
 */
public class BinaryHeap {

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(Comparable[] items) {
        currentSize = items.length;
        array = new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (Comparable item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Comparable[capacity + 1];
    }

    /**
     * 向上移动。
     * <p>
     * 边界条件
     * 边界条件
     * 代码简洁。
     * 代码简洁。
     *
     * @param x
     */
    public void insert(Comparable x) {
        // Percolate up
        //最后一个位置
        int hole = ++currentSize;
        //当前结点与父结点比较
        //类似数组移动后插入
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }


    public Comparable findMin() {
        if (isEmpty()) {
            return null;
        }
        return array[1];
    }


    public Comparable deleteMin() {
        if (isEmpty()) {
            return null;
        }

        Comparable minItem = findMin();
        //最后一个元素赋值。
        array[1] = array[currentSize--];
        //下沉
        percolateDown(1);

        return minItem;
    }


    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }


    public boolean isEmpty() {
        return currentSize == 0;
    }


    public boolean isFull() {
        return currentSize == array.length - 1;
    }


    public void makeEmpty() {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 100;

    private int currentSize;      // Number of elements in heap
    private Comparable[] array; // The heap array

    /**
     * 向下移动
     *
     * @param hole
     */
    private void percolateDown(int hole) {
        int child;
        Comparable tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            //当前结点孩子。选择较小孩子。
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                //选择右孩子。
                child++;
            }
            //开始下沉
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }

    // Test program
    public static void main(String[] args) {
        int numItems = 50;
        BinaryHeap h = new BinaryHeap(numItems);
        int i = 37;

        try {
            for (i = 37; i != 0; i = (i + 37) % numItems) {
                h.insert(new Integer(i));
            }
            System.out.println(Arrays.toString(h.array));
            System.out.println(h.findMin());
            h.deleteMin();
            System.out.println(Arrays.toString(h.array));
        } catch (Exception e) {
            System.out.println("Overflow (expected)! " + i);
        }
    }
}