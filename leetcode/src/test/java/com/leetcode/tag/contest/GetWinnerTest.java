package com.leetcode.tag.contest;

import com.leetcode.tag.contest.one.GetWinner;
import org.junit.Test;

public class GetWinnerTest {
    GetWinner getWinner = new GetWinner();

    @Test
    public void getWinnerTest() {
        GetWinner.Solution solution = getWinner.new Solution();

        int[] arr = new int[]{
                2, 1, 3, 5, 4, 6, 7
        };
        solution.getWinner(arr, 2);
    }
}
