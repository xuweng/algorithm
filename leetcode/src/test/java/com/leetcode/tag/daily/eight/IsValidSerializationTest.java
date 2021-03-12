package com.leetcode.tag.daily.eight;

import org.junit.jupiter.api.Test;

class IsValidSerializationTest {
    IsValidSerialization.Solution solution = new IsValidSerialization.Solution();

    @Test
    void test() {
        //        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        String preorder = "9,#,#,1";

        boolean validSerialization = solution.isValidSerialization(preorder);

        System.out.println(validSerialization);
    }
}