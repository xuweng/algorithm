package com.algorithm.study.algorithm.sort.quicksort.one;

/**
 * 什么样的数据?
 * 1,2,3,4,5,6
 * 6,5,4,3,2,1
 * 2,2,2,2,2,1
 * <p>
 * 即使有重复数据。一边慢，但是一边快。
 * <p>
 * 快速排序
 * <p>
 * 双路快排。等于v这种情况包含进了大于v的情况里面
 * 不管是当条件是大于等于还是小于等于v，当数组中重复元素非常多的时候，等于v的元素太多，
 * 那么就将数组分成了极度不平衡的两个部分，因为等于v的部分总是集中在数组的某一边。
 * <p>
 * 归并排序是二分。极度平衡。
 * <p>
 * 挖坑填数+分治法
 * <p>
 * 挖坑填数不是交换，不是拿基准数据不断交换
 */
public class QuickSort {
    //快速排序
    void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                //用一些数据来验证
                //1,2,3,4,5,6
                //退出时，i=j。
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                {
                    j--;
                }
                if (i == j) {
                    return;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                //用一些数据来验证
                //6,5,4,3,2,1
                //退出时，i=j。
                //等于x放在右边
                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                {
                    i++;
                }
                if (i == j) {
                    return;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    void quick_sort1(int s[], int l, int r) {
        if (l < r) {
            int i = AdjustArray(s, l, r);//先成挖坑填数法调整s[]
            quick_sort1(s, l, i - 1); // 递归调用
            quick_sort1(s, i + 1, r);
        }
    }

    /**
     * 返回调整后基准数的位置
     *
     * @param s
     * @param l
     * @param r
     * @return 调整后基准数的位置
     */
    int AdjustArray(int s[], int l, int r) {
        int i = l, j = r;
        int x = s[l]; //s[l]即s[i]就是第一个坑
        while (i < j) {
            //两个条件，保证i<j
            // 从右向左找小于x的数来填s[i]
            while (i < j && s[j] >= x) {
                j--;
            }
            if (i < j) {
                s[i] = s[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
                i++;
            }
            //两个条件，保证i<j
            // 从左向右找大于或等于x的数来填s[j]
            //等于的元素放在右边
            while (i < j && s[i] < x) {
                i++;
            }
            if (i < j) {
                s[j] = s[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
                j--;
            }
        }
        //退出时，i等于j。将x填到这个坑中。
        s[i] = x;

        return i;
    }
}
