package com.algorithm.study;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.common.SortType;
import com.algorithm.study.sort.Sort;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SortTests {
    @Test
    public void selectSortTest() {
        Integer[] array = ArrayUtils.generateShuffleArray(1, 100);
        Sort.selectSort(array);

        assertTrue(ArrayUtils.isSorted(array, SortType.ASC));
        ArrayUtils.println(array);
    }
}
