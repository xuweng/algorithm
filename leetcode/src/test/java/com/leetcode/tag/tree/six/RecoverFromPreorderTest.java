package com.leetcode.tag.tree.six;

import org.junit.Test;

public class RecoverFromPreorderTest {
    RecoverFromPreorder.Solution solution = new RecoverFromPreorder.Solution();

    @Test
    public void recoverFromPreorderTest() {
        String S = "1-2--3--4-5--6--7";

        solution.recoverFromPreorder(S);
    }

}