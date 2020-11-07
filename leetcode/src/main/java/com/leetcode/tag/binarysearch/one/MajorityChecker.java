package com.leetcode.tag.binarysearch.one;

import java.util.*;

/**
 * 1157. 子数组中占绝大多数的元素
 * <p>
 * 作者：levyjeng
 * 链接：https://leetcode-cn.com/problems/online-majority-element-in-subarray/solution/shuang-100-er-fen-sou-suo-by-levyjeng/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MajorityChecker {
    int[] nums;
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer>[] lists = new ArrayList[20001];
    List<ArrayList<Integer>> counter = new ArrayList<>();
    int[] temp;

    public MajorityChecker(int[] arr) {
        nums = arr;

        for (int i = 0; i < arr.length; i++) {
            if (lists[nums[i]] == null) {
                lists[nums[i]] = new ArrayList<>();
                lists[nums[i]].add(-1 * nums[i]);
                counter.add(lists[nums[i]]);
            }
            lists[nums[i]].add(i);

        }
        counter.sort(Comparator.comparingInt(ArrayList::size));
        temp = new int[counter.size()];
        for (int i = 0; i < counter.size(); i++) {
            temp[i] = counter.get(i).size();
        }

    }

    /**
     * @param left
     * @param right
     * @param threshold 阈值
     * @return
     */
    public int query(int left, int right, int threshold) {
        //当数据量小的时候，使用暴力搜索法
        if (right - left <= 50) {
            map.clear();
            for (int i = left; i <= right; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) >= threshold) {
                    return nums[i];
                }
            }
            return -1;
        }
        //数据量大的时候
        int pos = Arrays.binarySearch(temp, threshold - 1);
        if (pos < 0) {
            pos = -1 * pos - 1;
        }

        for (int i = pos; i < counter.size(); i++) {
            int s = Collections.binarySearch(counter.get(i), left);
            if (s < 0) {
                s = -1 * s - 1;
            }
            int e = Collections.binarySearch(counter.get(i), right);
            if (e < 0) {
                e = -1 * e - 2;
            }
            if (e - s + 1 >= threshold) {
                return counter.get(i).get(0) * -1;
            }
        }
        return -1;

    }
}

