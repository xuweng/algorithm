package com.leetcode.tag;

import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        sum(6);
    }

    public void sum(int n) {
        int odd = 0;
        int even = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }

        System.out.println(odd);
        System.out.println(even);
    }
}
