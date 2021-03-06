package com.algorithm.study.common;

import java.util.*;

/**
 * 需要特别注意边界问题,特别是索引
 */
public class ArrayUtils {
    /**
     * 判断数组是否排序
     * 复杂度：O(n)
     *
     * @param array    数组
     * @param sortType 排序类型
     */
    public static boolean isSorted(Integer[] array, SortType sortType) {
        Objects.requireNonNull(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (sortType == SortType.ASC) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            } else {
                if (array[i] < array[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 打乱一个顺序的数组
     *
     * @param array 顺序的数组
     */
    public static void shuffle(Integer[] array) {
        Objects.requireNonNull(array);

        //这种方法已经排好序
//        Collections.shuffle(Arrays.stream(array).collect(Collectors.toList()));
        Collections.shuffle(Arrays.asList(array));
    }

    /**
     * 顺序生成不重复的数组
     * 复杂度：O(n)
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @return
     */
    public static Integer[] generateSortArray(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException();
        }
        Integer[] array = new Integer[max - min + 1];
        int index = 0;
        while (min <= max) {
            array[index] = min;
            min++;
            index++;
        }

        return array;
    }

    /**
     * 随机生成不重复的数组
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @return
     */
    public static Integer[] generateShuffleArray(int min, int max) {
        Integer[] array = generateSortArray(min, max);
        ArrayUtils.shuffle(array);

        return array;
    }

    /**
     * 随机指定范围内N个不重复的数
     *
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param size 随机数个数
     * @return
     */
    public static Integer[] randomArrayWithoutRepetition(int min, int max, int size) {
        return randomArray(min, max, size, new HashSet<Integer>());
    }

    /**
     * 随机指定范围内N个可能重复的数
     *
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param size 随机数个数
     * @return
     */
    public static Integer[] randomArrayHasRepetition(int min, int max, int size) {
        return randomArray(min, max, size, new ArrayList<Integer>());
    }

    public static void println(Integer[] array) {
        Objects.requireNonNull(array);

        Arrays.stream(array).forEach(System.out::println);
    }

    public static void print(Integer[] array) {
        Objects.requireNonNull(array);

        Arrays.stream(array).forEach(System.out::print);
    }

    /**
     * 随机指定范围内N个数
     * 复杂度：O(n)
     *
     * @param min  指定范围最小值
     * @param max  指定范围最大值
     * @param size 随机数个数
     * @param list 集合
     * @return
     */
    private static Integer[] randomArray(int min, int max, int size, Collection<Integer> list) {
        Objects.requireNonNull(list);

        if (size > (max - min + 1) || max < min) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            int num = (int) (Math.random() * (max - min)) + min;
            list.add(num);
        }
        while (list.size() < size) {
            int num = (int) (Math.random() * (max - min)) + min;
            list.add(num);
        }

        return list.toArray(new Integer[0]);

    }

    /**
     * 空
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Integer[] array) {
        return !isNonEmpty(array);
    }

    /**
     * 非空
     *
     * @param array
     * @return
     */
    public static boolean isNonEmpty(Integer[] array) {
        Objects.requireNonNull(array);

        return array.length > 0;
    }

    /**
     * 非空
     *
     * @param array
     * @return
     */
    public static void requireNonEmpty(Integer[] array) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 校验索引范围
     *
     * @param index  索引
     * @param length
     */
    public static void checkIndexRange(Integer index, Integer length) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 校验开始索引范围
     *
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     */
    public static void checkStartIndexRange(Integer startIndex, Integer endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 从数组中查找最小值索引
     * 复杂度：O(n)
     *
     * @param array      数组
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     * @return 最小值索引
     */
    public static Integer findMinValueIndex(Integer[] array, Integer startIndex, Integer endIndex) {
        requireNonEmpty(array);
        checkStartIndexRange(startIndex, endIndex);

        int minIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * 从数组中查找最大值索引
     * 复杂度：O(n)
     *
     * @param array      数组
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     * @return 最大值索引
     */
    public static Integer findMaxValueIndex(Integer[] array, Integer startIndex, Integer endIndex) {
        requireNonEmpty(array);
        checkStartIndexRange(startIndex, endIndex);

        int maxIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (array[maxIndex] < array[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * 交换值
     * 复杂度：O(1)
     *
     * @param array
     * @param index1 索引1
     * @param index2 索引2
     */
    public static void swapValue(Integer[] array, Integer index1, Integer index2) {
        checkIndexRange(index1, array.length);
        checkIndexRange(index2, array.length);

        Integer temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * 设置第一个小于目标值的值并且移动元素
     * 复杂度：O(n)
     *
     * @param array
     * @param startIndex  开始索引
     * @param targetIndex 目标值索引,1<=targetIndex<array.length
     */
    public static void setFirstSmallValue(Integer[] array, Integer startIndex, Integer targetIndex) {
        requireNonEmpty(array);
        if (array.length == 1) {
            return;
        }
        checkIndexRange(targetIndex, array.length);

        Integer index = targetIndex;
        Integer targetValue = array[targetIndex];
        for (int i = targetIndex - 1; i >= startIndex; i--) {
            if (targetValue < array[i]) {
                array[i + 1] = array[i];
                index = i;
            }
        }

        //数据有移动
        if (!index.equals(targetIndex)) {
            array[index] = targetValue;
        }
    }

    /**
     * 编写涉及数组的递归函数时，基线条件通常是数组为空或只包含一个元素。陷入困境时，
     * 请检查基线条件是不是这样的。
     *
     * @param array
     * @return
     */
    public static boolean isBaselineCondition(int[] array) {
        Objects.requireNonNull(array);
        return array.length == 0 || array.length == 1;
    }

    /**
     * 分区函数
     *
     * @param array
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     * @return 分区索引
     */
    public static Integer partition(Integer[] array, Integer startIndex, Integer endIndex) {
        requireNonEmpty(array);
        checkStartIndexRange(startIndex, endIndex);

        Integer pivotIndex = getPivot(array, startIndex, endIndex);

        while (startIndex <= endIndex) {
            //左边第一个大于基准
            while (array[startIndex] <= array[pivotIndex] && startIndex <= endIndex) {
                startIndex++;
            }
            //右边第一个小于基准
            while (array[endIndex] >= array[pivotIndex] && startIndex <= endIndex) {
                endIndex--;
            }
            if (startIndex < endIndex) {
                swapValue(array, startIndex, endIndex);
            }
        }

        swapValue(array, startIndex - 1, pivotIndex);

        return startIndex - 1;
    }

    /**
     * 简单的,默认基准索引
     *
     * @param array
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     * @return 默认基准索引
     */
    public static Integer getPivot(Integer[] array, Integer startIndex, Integer endIndex) {
        return startIndex;
    }

    /**
     * 合并两个有序数组
     * 特别注意边界问题
     *
     * @param array
     * @param middle     中间索引
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     * @return 一个有序数组
     */
    public static Integer[] merge(Integer[] array, Integer middle, Integer startIndex, Integer endIndex) {
        requireNonEmpty(array);
        checkIndexRange(middle, array.length);
        checkStartIndexRange(startIndex, endIndex);

        //左有序左数组
        Integer[] left = new Integer[middle - startIndex + 1];
        //右有序数组
        Integer[] right = new Integer[endIndex - middle + 1];

        Integer[] result = new Integer[left.length + right.length];
        //左数组赋值
        Integer leftIndex = 0;
        for (int i = startIndex; i <= middle; i++) {
            left[leftIndex++] = array[i];
        }
        //右数组赋值
        Integer rightIndex = 0;
        for (int i = middle + 1; i <= endIndex; i++) {
            left[rightIndex++] = array[i];
        }
        //左数组：指针是i,范围
        //右数组:指针是j,范围


        return result;
    }

    /**
     * 交换
     *
     * @param array
     * @param i     数组下标
     * @param j     数组下标
     */
    public static void swap(int[] array, int i, int j) {
        checkIndex(array.length, i);
        checkIndex(array.length, j);

        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 检查下标
     *
     * @param length
     * @param index
     */
    public static void checkIndex(int length, int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
    }
}
