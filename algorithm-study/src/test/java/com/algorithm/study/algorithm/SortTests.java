package com.algorithm.study.algorithm;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.common.SortType;
import com.algorithm.study.algorithm.sort.Sort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SortTests {
    @Test
    public void selectSortTest() {
        Integer[] array = ArrayUtils.generateShuffleArray(1, 100);
        Sort.selectSort(array);

        assertTrue(ArrayUtils.isSorted(array, SortType.ASC));
        ArrayUtils.println(array);
    }

    @Test
    public void insertSortTest() {
        Integer[] array = ArrayUtils.generateShuffleArray(1, 100);
        Sort.insertSort(array);

        assertTrue(ArrayUtils.isSorted(array, SortType.ASC));
        ArrayUtils.println(array);
    }

    @Test
    public void quickSort() {
        Integer[] array = ArrayUtils.generateShuffleArray(1, 100);
        Sort.quickSort(array, 0, array.length - 1);

        assertTrue(ArrayUtils.isSorted(array, SortType.ASC));
        ArrayUtils.println(array);
    }
}
