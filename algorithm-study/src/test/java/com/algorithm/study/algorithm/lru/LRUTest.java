package com.algorithm.study.algorithm.lru;

import org.junit.Assert;
import org.junit.Test;

public class LRUTest {
    @Test
    public void cacheTest() {
        int[] date = {1, 2, 3, 4, 5, 6, 2, 3};
        for (int d : date) {
            LRU.insert(d);
        }

        Assert.assertEquals(6, LRU.getSize());
    }
}
