package com.leetcode.tag.contest.two;

/**
 * 5642. 大餐计数
 */
public class CountPairs {
    class Solution {
        public int countPairs(int[] deliciousness) {
            if (deliciousness == null || deliciousness.length == 0) {
                return 0;
            }

            int result = 0;
            for (int i = 0; i < deliciousness.length - 1; i++) {
                for (int j = i + 1; j < deliciousness.length; j++) {
                    if (checkPowerOf2(deliciousness[i] + deliciousness[j])) {
                        result++;
                    }
                }
            }

            return result % (int) (Math.pow(10, 9) + 7);
        }

        /**
         * 是否是2的幂
         *
         * @param num
         * @return
         */
        private boolean checkPowerOf2(int num) {
            if (num <= 0) {
                return false;
            }

            return (num & (num - 1)) == 0;
        }
    }
}
