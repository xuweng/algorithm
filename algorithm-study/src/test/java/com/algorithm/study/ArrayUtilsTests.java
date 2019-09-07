package com.algorithm.study;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.common.SortType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ArrayUtilsTests {
    @Test
    public void randomArrayHasRepetitionTest() {
        Integer[] array = ArrayUtils.randomArrayHasRepetition(1, 100, 100);

        assertEquals(100, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void isSortedTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);

        assertTrue(ArrayUtils.isSorted(array, SortType.ASC));
        ArrayUtils.println(array);
    }

    @Test
    public void findMinValueIndexTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);
//        int minIndex = ArrayUtils.findMinValueIndex(array, 0, array.length);
        int minIndex = ArrayUtils.findMinValueIndex(array, 50, array.length);
        int maxIndex = ArrayUtils.findMaxValueIndex(array, 0, array.length);

        assertEquals((Integer) 51, array[minIndex]);
        assertEquals(50, minIndex);
        assertEquals(99, maxIndex);
        ArrayUtils.println(array);
    }

    @Test
    public void sortArrayWithoutRepetitionTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);

        assertEquals(100, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void generateShuffleArrayTest() {
        Integer[] array = ArrayUtils.generateShuffleArray(1, 100);

        assertEquals(100, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void randomArrayWithoutRepetitionTest() {
        Integer[] array = ArrayUtils.randomArrayWithoutRepetition(1, 100, 90);

        assertEquals(90, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void shuffle() {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List list = new ArrayList();
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ", ");
            list.add(x[i]);
        }
        System.out.println();

        Collections.shuffle(list);

        Iterator ite = list.iterator();
        while (ite.hasNext()) {
            System.out.print(ite.next().toString() + ", ");
        }
    }

}
