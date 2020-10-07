package com.leetcode.tag.dfs.one;

import org.junit.Test;

public class UpdateMatrixTest {
    UpdateMatrix.Solution solution = new UpdateMatrix.Solution();

    @Test
    public void updateMatrixTest() {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        solution.updateMatrix(matrix);
    }

}