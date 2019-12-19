package com.algorithm.study.datastructure.array;

import java.util.Arrays;

/**
 * 有索引的插入和删除,索引控制在有数据区域,即0<index<size
 * <p>
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

    private static String[] elementData = new String[capacity];
    /**
     * 空数组
     * <p>
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * 默认初始容量
     * <p>
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    //最大容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 根据下标查找
     *
     * @param k 数组下标
     * @return
     */
    public static String find(int k) {
        checkIndexByCapacity(k);
        return elementData[k];
    }

    /**
     * 查找k前缀
     *
     * @param k 数组下标
     * @return
     */
    public static String findPrefix(int k) {
        checkIndexByCapacity(k);

        if (k == 0) {
            return elementData[k];
        } else {
            return elementData[k - 1];
        }
    }

    /**
     * 查找k后缀
     *
     * @param k 数组下标
     * @return
     */
    public static String findSuffix(int k) {
        checkIndexByCapacity(k);

        if (k == capacity - 1) {
            return elementData[k];
        } else {
            return elementData[k + 1];
        }
    }

    /**
     * 移动插入
     * <p>
     * 在有数据区域插入需要移动,在没有数据区域插入不需要移动
     *
     * @param date 数据
     * @param k    数组下标.插入到第k个位置 0<=k<=capacity-1
     * @return
     */
    public static String insertMove(String date, int k) {
        checkIndexByCapacity(k);
        //扩容
        resize();
        //在数组的末尾插入元素，那就不需要移动数据
        if (k == capacity - 1) {
            elementData[k] = date;
        } else {
            //k后面没有数据不需要移动
            for (int i = k; i < capacity; i++) {
                elementData[i + 1] = elementData[i];
            }
            elementData[k] = date;
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
    public static String insertNoMove(String date, int k) {
        checkIndexByCapacity(k);
        //扩容
        resize();
        //在数组的末尾插入元素，那就不需要移动数据
        if (k == capacity - 1) {
            elementData[k] = date;
        } else {
            //k后面没有数据不需要移动
            elementData[capacity - 1] = elementData[k];
            elementData[k] = date;
        }
        size++;
        return date;
    }

    /**
     * 删除
     * <p>
     * 在有数据区域插入需要移动,在没有数据区域插入不需要移动
     *
     * @param k 数组下标.删除第k个位置
     * @return
     */
    public static String removeMove(int k) {
        checkIndexByCapacity(k);

        //在数组的末尾删除元素，那就不需要移动数据
        if (k == capacity - 1) {
            elementData[k] = null;
        } else {
            //k后面没有数据不需要移动
            for (int i = k; i < capacity; i++) {
                elementData[i] = elementData[i + 1];
            }
        }
        size--;
        return null;
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
        String[] newTable = new String[newCapacity];

        for (int i = 0; i < capacity - 1; i++) {
            newTable[i] = elementData[i];
        }
        capacity = newCapacity;
        elementData = newTable;
    }

    /**
     * 2倍缩容
     */
    private static void shrink() {
        if (!shrinkStrategy()) {
            return;
        }
        int newCapacity = capacity / 2;
        String[] newTable = new String[newCapacity];

        for (int i = 0; i < capacity - 1; i++) {
            newTable[i] = elementData[i];
        }
        capacity = newCapacity;
        elementData = newTable;
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

    /**
     * 元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 索引检查
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 可能扩容
     * <p>
     * 新增一个对象
     *
     * @param e
     * @return
     */
    public boolean add(String e) {
        //是否扩容
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //尾插
        elementData[size++] = e;
        return true;
    }

    /**
     * 可能扩容,一定移动元素
     * <p>
     * 在索引新增一个对象
     *
     * @param index   0 <= index <= size 有数据区域
     * @param element
     */
    public void add(int index, String element) {
        //索引检查 0 <= index <= size
        rangeCheckForAdd(index);

        //确保容量内置 size + 1 > oldCapacity 是否扩容
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //移动元素
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * 确保容量内置
     *
     * @param minCapacity 最小容量 (size + 1)
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 计算容量
     *
     * @param elementData
     * @param minCapacity 最小容量
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    /**
     * 当前容量是否大于实际容量,是就扩容
     *
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        // overflow-conscious code
        //有溢出意识的代码
        //size+1>elementData.length?
        if (minCapacity - elementData.length > 0) {
            //旧数组的数据搬到新数组
            grow(minCapacity);
        }
    }

    /**
     * 旧数组的数据搬到新数组
     * <p>
     * 扩容,新容量计算比较复杂
     * <p>
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        //旧容量
        int oldCapacity = elementData.length;
        //新容量,旧容量2倍扩容
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        //新容量<最大容量
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            //最大容量
            newCapacity = hugeCapacity(minCapacity);
        }
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 巨大的容量,最大容量
     *
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
        {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public String remove(int index) {
        //检查索引
        rangeCheck(index);

        String oldValue = elementData(index);
        //index是否在中间,index可能在最后
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            //index在中间,移动元素
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        }
        //删除一般清空元素
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    String elementData(int index) {
        return elementData[index];
    }

    /**
     * 删除给定元素
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        }
        //删除一般清空元素
        elementData[--size] = null; // clear to let GC do its work
    }

    /**
     * 清空
     * <p>
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {

        // clear to let GC do its work
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;
    }
}
