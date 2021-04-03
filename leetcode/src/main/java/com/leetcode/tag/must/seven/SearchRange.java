package com.leetcode.tag.must.seven;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null) {
                return new int[]{};
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    int i = mid;
                    int j = mid;
                    while (i >= 0 && nums[i] == target) {
                        i--;
                    }
                    while (j < nums.length && nums[j] == target) {
                        j++;
                    }
                    return new int[]{i + 1, j - 1};
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return new int[]{-1, -1};
        }
    }

    /**
     * 两次二分
     */
    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 小于一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                }
            }

            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    // 下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                } else {
                    // nums[mid] < target，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }

    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    // 2 2 target=2
                    // nums[left]==nums[mid]==target left不变,死循环
                    if (mid + 1 < nums.length && nums[mid + 1] == target) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    /**
     * 2: left=mid=right=0
     * <p>
     * 2 2: left=0,mid=0,right=1 left=mid right
     */
    class Solution3 {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (mid - 1 >= 0 && nums[mid - 1] == target) {
                        right = mid - 1;
                    } else {
                        return mid;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    // 2 2 target=2
                    // nums[left]==nums[mid]==target left不变,死循环
                    if (mid + 1 < nums.length && nums[mid + 1] == target) {
                        left = mid + 1;
                    } else {
                        return mid;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    /**
     * 2 2 只有两个数时,选择mid=0或者mid=1
     */
    class Solution4 {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        /**
         * 2 2
         *
         * @param nums
         * @param target
         * @return
         */
        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        /**
         * 2 2
         *
         * @param nums
         * @param target
         * @return
         */
        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
}
