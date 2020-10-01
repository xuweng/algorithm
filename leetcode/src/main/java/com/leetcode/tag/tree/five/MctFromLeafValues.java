package com.leetcode.tag.tree.five;

import java.util.Stack;

/**
 * 1130. 叶值的最小代价生成树
 */
public class MctFromLeafValues {
    /**
     * 单调递减栈.栈顶存的一直是当时能找到的最小值
     * <p>
     * 作者：zhanglintc
     * 链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/wei-shi-yao-dan-diao-di-jian-zhan-de-suan-fa-ke-xi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            Stack<Integer> st = new Stack<>();
            st.push(Integer.MAX_VALUE);
            int mct = 0;
            for (int j : arr) {
                while (j >= st.peek()) {
                    mct += st.pop() * Math.min(st.peek(), j);
                }
                st.push(j);
            }
            while (st.size() > 2) {
                mct += st.pop() * st.peek();
            }
            return mct;
        }
    }

}
