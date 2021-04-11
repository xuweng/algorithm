package com.leetcode.tag.must.five;

import java.util.ArrayList;

/**
 * 5727. 找出游戏的获胜者
 */
public class FindTheWinner {
    /**
     * 方法：模拟
     * <p>
     * 作者：hu-li-hu-wai
     * 链接：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/mo-ni-by-hu-li-hu-wai-d1i7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findTheWinner(int n, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            //初始化：把 n 个数字填到 list 中；
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            //循环删除：删去间隔 k 位置的元素，并更新下一次的起点 start
            //直到只剩一个元素，返回结果
            //注意：
            //更新下次起点时，由于 id 位置的元素已删除，所以 start 不是 id+1 ，而是 id
            //对 id 需要取 size 的模，防止越界
            int start = 0;
            while (list.size() > 1) {
                //模size防止越界
                int id = (start + k - 1) % list.size();
                list.remove(id);
                //更新下次起点时，由于 id 位置的元素已删除，所以 start 不是 id+1 ，而是 id
                start = id;
            }
            return list.get(0);
        }
    }
}
