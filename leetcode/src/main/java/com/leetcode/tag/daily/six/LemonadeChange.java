package com.leetcode.tag.daily.six;

/**
 * 860. 柠檬水找零
 */
public class LemonadeChange {
    /**
     * 方法一：模拟 + 贪心
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/lemonade-change/solution/ning-meng-shui-zhao-ling-by-leetcode-sol-nvp7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 分类讨论
         *
         * @param bills
         * @return
         */
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    //5 美元，由于柠檬水的价格也为 5 美元，因此我们直接收下即可。
                    five++;
                } else if (bill == 10) {
                    //10 美元，我们需要找回 5 美元，如果没有 5 美元面值的钞票，则无法正确找零。
                    if (five == 0) {
                        return false;
                    }
                    five--;
                    ten++;
                } else {
                    //20 美元，我们需要找回 15 美元，此时有两种组合方式，一种是一张 10 美元和 5 美元的钞票，一种是 3 张 5 美元的钞票
                    //当可以正确找零时，两种找零的方式中我们更倾向于第一种
                    //因为需要使用 5 美元的找零场景会比需要使用 10 美元的找零场景多，我们需要尽可能保留 5 美元的钞票
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
