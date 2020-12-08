package com.leetcode.tag.daily.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 */
public class SplitIntoFibonacci {
    /**
     * 方法一：回溯 + 剪枝
     * <p>
     * 递归树 递归树 递归树 递归树
     * <p>
     * dp矩阵 dp矩阵 dp矩阵 dp矩阵
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/jiang-shu-zu-chai-fen-cheng-fei-bo-na-qi-ts6c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> list = new ArrayList<>();
            backtrack(list, S, S.length(), 0, 0, 0);
            return list;
        }

        public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
            if (index == length) {
                return list.size() >= 3;
            }
            long currLong = 0;
            for (int i = index; i < length; i++) {
                if (i > index && S.charAt(index) == '0') {
                    break;
                }
                currLong = currLong * 10 + S.charAt(i) - '0';
                if (currLong > Integer.MAX_VALUE) {
                    break;
                }
                int curr = (int) currLong;
                if (list.size() >= 2) {
                    if (curr < sum) {
                        continue;
                    } else if (curr > sum) {
                        break;
                    }
                }
                list.add(curr);
                if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
            return false;
        }
    }

    /**
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/javahui-su-suan-fa-tu-wen-xiang-jie-ji-b-vg5z/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> res = new ArrayList<>();
            backtrack(S.toCharArray(), res, 0);
            return res;
        }

        public boolean backtrack(char[] digit, List<Integer> res, int index) {
            //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
            // 这里用&&
            if (index == digit.length && res.size() >= 3) {
                return true;
            }
            for (int i = index; i < digit.length; i++) {
                //两位以上的数字不能以0开头
                if (digit[index] == '0' && i > index) {
                    break;
                }
                // 截取字符串转化为数字
                // 这里是index到i+1
                // index是第一个字符
                long num = subDigit(digit, index, i + 1);
                //如果截取的数字大于int的最大值，则终止截取
                if (num > Integer.MAX_VALUE) {
                    break;
                }
                int size = res.size();
                // res有两个以上的数字
                // 如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
                if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                    break;
                }
                if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                    // res只有一个数字或者满足条件
                    // 把数字num添加到集合res中
                    res.add((int) num);
                    //如果找到了就直接返回
                    if (backtrack(digit, res, i + 1)) {
                        return true;
                    }
                    //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
                    res.remove(res.size() - 1);
                }
            }
            return false;
        }

        /**
         * 相当于截取字符串S中的子串然后转换为十进制数字
         *
         * @param digit
         * @param start
         * @param end
         * @return
         */
        private long subDigit(char[] digit, int start, int end) {
            long res = 0;
            for (int i = start; i < end; i++) {
                res = res * 10 + digit[i] - '0';
            }
            return res;
        }
    }

}
