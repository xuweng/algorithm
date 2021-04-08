package com.leetcode.tag.must.one.seven;

/**
 * 278. 第一个错误的版本
 */
public class FirstBadVersion {
    /**
     * 最小值
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/first-bad-version/solution/di-yi-ge-cuo-wu-de-ban-ben-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
