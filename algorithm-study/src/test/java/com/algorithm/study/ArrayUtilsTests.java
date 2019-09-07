package com.algorithm.study;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.common.SortType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayUtilsTests {
    @Test
    public void randomArrayHasRepetitionTest() {
        Integer[] array = ArrayUtils.randomArrayHasRepetition(1, 100, 100);

        Assert.assertEquals(100, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void isSortedTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);

        Assert.assertTrue(ArrayUtils.isSorted(array, SortType.ASC));
        ArrayUtils.println(array);
    }

    @Test
    public void sortArrayWithoutRepetitionTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);

        Assert.assertEquals(100, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void shuffleTest() {
        Integer[] array = ArrayUtils.generateSortArray(1, 100);
        ArrayUtils.shuffle(array);

        Assert.assertEquals(100, array.length);
        ArrayUtils.println(array);
    }

    @Test
    public void randomArrayWithoutRepetitionTest() {
        Integer[] array = ArrayUtils.randomArrayWithoutRepetition(1, 100, 90);

        Assert.assertEquals(90, array.length);
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
