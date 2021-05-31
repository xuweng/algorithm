package com.leetcode.tag.must5.six;

import java.util.Arrays;

/**
 * 1870. 准时到达的列车最小时速
 */
public class MinSpeedOnTime {
    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            //最小速度
            int i = 1;
            // 最大速度
            int j = Arrays.stream(dist).max().getAsInt() * 100;
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (costtime(m, dist) > hour) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return i > Arrays.stream(dist).max().getAsInt() * 100 ? -1 : i;
        }

        public double costtime(double speed, int[] dist) {
            int len = dist.length;
            double result = 0;
            for (int i = 0; i < len - 1; i++) {
                result += Math.ceil(dist[i] / speed);
            }
            return result + dist[len - 1] / speed;
        }
    }

    class Solution1 {
        public int minSpeedOnTime(int[] dist, double hour) {
            if (dist.length > Math.ceil(hour)) {
                return -1;
            }
            // 搜索边界
            int left = 1;
            int right = Arrays.stream(dist).max().getAsInt() * 100;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 如果以 mid 速度可达，那么就尝试减小速度
                if (check(dist, hour, mid)) {
                    right = mid;
                } else {
                    // 否则就需要加了
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean check(int[] dist, double hour, int speed) {
            double cnt = 0.0;
            // 对除了最后一个站点以外的时间进行向上取整累加
            for (int i = 0; i < dist.length - 1; ++i) {
                // 除法的向上取整
                cnt += (dist[i] + speed - 1) / speed;
            }
            // 加上最后一个站点所需的时间
            cnt += (double) dist[dist.length - 1] / speed;
            return cnt <= hour;
        }
    }
}
