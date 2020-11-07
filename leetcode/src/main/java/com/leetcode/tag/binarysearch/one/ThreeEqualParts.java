package com.leetcode.tag.binarysearch.one;

import java.util.Arrays;

/**
 * 927. 三等分
 */
public class ThreeEqualParts {
    /**
     * 如果存在这种分法，那么最终每一部分 1 的数量一定是相等的
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/three-equal-parts/solution/san-deng-fen-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] threeEqualParts(int[] A) {
            int[] imp = new int[]{-1, -1};
            int n = A.length;

            //S 为 A 中 1 的个数
            int s = Arrays.stream(A).sum();
            if (s % 3 != 0) {
                //如果 S 不能被 3 整除，显然不存在这种分法
                return imp;
            }
            int t = s / 3;
            if (t == 0) {
                return new int[]{0, n - 1};
            }

            int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
            int su = 0;
            for (int i = 0; i < n; ++i) {
                if (A[i] == 1) {
                    su += 1;
                    if (su == 1) {
                        i1 = i;
                    }
                    if (su == t) {
                        j1 = i;
                    }
                    if (su == t + 1) {
                        i2 = i;
                    }
                    if (su == 2 * t) {
                        j2 = i;
                    }
                    if (su == 2 * t + 1) {
                        i3 = i;
                    }
                    if (su == 3 * t) {
                        j3 = i;
                    }
                }
            }

            // The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
            // where [i1, j1] is a block of 1s, etc.
            int[] part1 = Arrays.copyOfRange(A, i1, j1 + 1);
            int[] part2 = Arrays.copyOfRange(A, i2, j2 + 1);
            int[] part3 = Arrays.copyOfRange(A, i3, j3 + 1);

            if (!Arrays.equals(part1, part2)) {
                return imp;
            }
            if (!Arrays.equals(part1, part3)) {
                return imp;
            }

            // x, y, z: the number of zeros after part 1, 2, 3
            int x = i2 - j1 - 1;
            int y = i3 - j2 - 1;
            int z = A.length - j3 - 1;

            if (x < z || y < z) {
                return imp;
            }
            return new int[]{j1 + z, j2 + z + 1};
        }
    }
}
