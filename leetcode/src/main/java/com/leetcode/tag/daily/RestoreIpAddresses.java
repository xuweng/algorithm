package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 * <p>
 * 十分钟看答案
 */
public class RestoreIpAddresses {
    /**
     * 方法一：递归
     * <p>
     * 回溯
     * <p>
     * 题解的思路与算法。
     * <p>
     * 看思路后看代码。
     * <p>
     * 递归函数。递归函数。递归函数。递归函数。递归函数。递归函数。递归函数
     * <p>
     * 递归函数dfs(segId,segStart) 表示我们正在从s[segStart] 的位置开始，搜索 IP 地址中的第 segId 段，
     * <p>
     * 其中segId∈{0,1,2,3}。最多3段。最多3段。最多3段。最多3段。最多3段。
     * <p>
     * 由于 IP 地址的每一段必须是 [0,255] 中的整数，因此我们从 segStart 开始，从小到大依次枚举当前这一段 IP 地址的结束位置segEnd
     * <p>
     * 如果满足要求，就递归地进行下一段搜索，调用递归函数 dfs(segId+1,segEnd+1)。
     * <p>
     * 分段搜索。搜索完一段再搜索下一段。分段搜索。分段搜索。分段搜索。分段搜索。分段搜索。分段搜索。分段搜索。分段搜索。
     */
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            return null;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        static final int SEG_COUNT = 4;
        List<String> ans = new ArrayList<>();
        int[] segments = new int[SEG_COUNT];

        public List<String> restoreIpAddresses(String s) {
            segments = new int[SEG_COUNT];
            dfs(s, 0, 0);
            return ans;
        }

        /**
         * 回溯。
         * <p>
         * 第几段。搜索开始位置。两者都有了。
         * <p>
         * 学会回溯搜索字符串
         *
         * @param s
         * @param segId    第 segId 段
         * @param segStart 搜索开始位置
         */
        public void dfs(String s, int segId, int segStart) {
            // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
            if (segId == SEG_COUNT) {
                if (segStart == s.length()) {
                    //搜索位置到最后一个位置
                    //遍历完所有字符串。就是答案。
                    StringBuffer ipAddr = new StringBuffer();
                    for (int i = 0; i < SEG_COUNT; ++i) {
                        ipAddr.append(segments[i]);
                        if (i != SEG_COUNT - 1) {
                            ipAddr.append('.');
                        }
                    }
                    ans.add(ipAddr.toString());
                }
                return;
            }

            // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
            if (segStart == s.length()) {
                return;
            }

            // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
            if (s.charAt(segStart) == '0') {
                segments[segId] = 0;
                dfs(s, segId + 1, segStart + 1);
            }

            // 一般情况，枚举每一种可能性并递归
            int addr = 0;
            for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
                addr = addr * 10 + (s.charAt(segEnd) - '0');
                if (addr > 0 && addr <= 0xFF) {
                    //保存第几段
                    segments[segId] = addr;
                    //搜索下一段。注意下一段的搜索开始位置。
                    dfs(s, segId + 1, segEnd + 1);
                } else {
                    break;
                }
            }
        }
    }

}
