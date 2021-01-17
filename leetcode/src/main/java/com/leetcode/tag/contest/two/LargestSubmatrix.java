package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5655. 重新排列后的最大子矩阵
 * <p>
 * 数学思维 问题转换 问题转换 问题转换 问题转换
 */
public class LargestSubmatrix {
    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int max = 0;
            int size = 0;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if (anInt == 0) {
                        size = 0;
                    } else {
                        size++;
                    }
                }
            }
            return 0;
        }
    }

    /**
     * 看不懂就debug
     * <p>
     * 作者：rational-irrationality
     * 链接：https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements/solution/java-yu-chu-li-shu-zu-bian-li-mei-xing-p-qpqu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution1 {
        public int largestSubmatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            //预处理数组，计算以这个点为结尾，上面有多少个连续的1，就是这一列以这个点为结尾的最大高度
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1) {
                        //记录向上连续1的个数
                        matrix[i][j] += matrix[i - 1][j];
                    }
                }
            }
            int res = 0;
            for (int[] ints : matrix) {
                //遍历每一行，对每一行进行排序
                // 排序作用，每行升序
                Arrays.sort(ints);
                for (int j = m - 1; j >= 0; j--) {
                    //更新矩形的最大高度
                    int height = ints[j];
                    // 面积=宽*高
                    //更新最大面积
                    res = Math.max(res, height * (m - j));
                }
            }
            return res;
        }
    }

}
