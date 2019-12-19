package com.algorithm.study.algorithm.recursive;

import org.junit.Test;

public class PermutationTests {
    @Test
    public void permutationTest() {
        int[] array = {1, 2, 3};
        int n = array.length - 1;

        Permutation.permutation(array, n);
        System.out.println(Permutation.size);
    }
}
