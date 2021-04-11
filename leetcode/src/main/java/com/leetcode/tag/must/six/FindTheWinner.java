package com.leetcode.tag.must.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 5727. 找出游戏的获胜者
 */
public class FindTheWinner {
    class Solution {
        public int findTheWinner(int n, int k) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int start = 0;
            while (list.size() > 1) {
                int id = (start + k - 1) % list.size();
                list.remove(id);
                start = id;
            }

            return list.get(0);
        }
    }
}
