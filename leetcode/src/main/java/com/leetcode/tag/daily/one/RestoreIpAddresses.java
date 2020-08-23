package com.leetcode.tag.daily.one;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
         * 搞懂入参和返回。
         * <p>
         * 算法是一种思维。不用死记硬背。
         * <p>
         * 第几段。搜索开始位置。两者都有了。
         * <p>
         * 学会回溯搜索字符串
         * <p>
         * 这两个入参很不错
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
                    //回溯不用重置。数组的数据会被覆盖。
                } else {
                    break;
                }
            }
        }
    }

    class Solution2 {
        public List<String> restoreIpAddresses(String s) {
            int len = s.length();
            List<String> res = new ArrayList<>();
            // 如果长度不够，不搜索
            if (len < 4 || len > 12) {
                return res;
            }

            Deque<String> path = new ArrayDeque<>(4);
            int splitTimes = 0;
            dfs(s, len, splitTimes, 0, path, res);
            return res;
        }

        /**
         * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段 判断的同时顺便把类型转了
         *
         * @param s
         * @param left
         * @param right
         * @return
         */
        private int judgeIfIpSegment(String s, int left, int right) {
            int len = right - left + 1;

            // 大于 1 位的时候，不能以 0 开头
            if (len > 1 && s.charAt(left) == '0') {
                return -1;
            }

            // 转成 int 类型
            int res = 0;
            for (int i = left; i <= right; i++) {
                res = res * 10 + s.charAt(i) - '0';
            }

            if (res > 255) {
                return -1;
            }
            return res;
        }

        private void dfs(
                String s, int len, int split, int begin, Deque<String> path, List<String> res) {
            if (begin == len) {
                if (split == 4) {
                    res.add(String.join(".", path));
                }
                return;
            }

            // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
            if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
                return;
            }

            // 候选集
            // 每个begin有3个长度可以选择。1,2,3
            for (int i = 0; i < 3; i++) {
                if (begin + i >= len) {
                    break;
                }

                int ipSegment = judgeIfIpSegment(s, begin, begin + i);
                if (ipSegment != -1) {
                    // 在判断是 ip 段的情况下，才去做截取
                    path.addLast(ipSegment + "");
                    dfs(s, len, split + 1, begin + i + 1, path, res);
                    path.removeLast();
                }
            }
        }
    }

}
