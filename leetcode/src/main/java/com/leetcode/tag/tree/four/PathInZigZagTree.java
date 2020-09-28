package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * <p>
 * 完全二叉树.
 * <p>
 * 十分钟看答案.十分钟看答案.
 */
public class PathInZigZagTree {
    /**
     * 简单易懂的公式
     * <p>
     * 作者：gre-z
     * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/jian-dan-yi-dong-de-gong-shi-shi-jian-guo-100-by-a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            ArrayList<Integer> integers = new ArrayList<>();//0.初始化存放结果的变量
            int a = (int) (Math.log(label) / Math.log(2));//2.计算label所在的层
            while (label > 1) {//5.循环直到遇到特殊情况1
                integers.add(label);//3.将label的结果添加到数组中
                label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);//4.计算下一个label的值
            }
            integers.add(1);//6.添加特殊情况 1
            Collections.reverse(integers); //7.翻转数组
            return integers;//1.返回结果
        }
    }

    /**
     * 位运算
     */
    class Solution1 {
        public List<Integer> pathInZigZagTree(int l) {
            if (l == 1) {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                return list;
            }
            int i = 1;
            while (l >= i) {
                i = i << 1;
            }
            int pin = (l - (i >> 1)) / 2 + 1;
            int resnow = (i >> 1) - pin;
            List<Integer> res = pathInZigZagTree(resnow);
            res.add(l);
            return res;
        }
    }
}
