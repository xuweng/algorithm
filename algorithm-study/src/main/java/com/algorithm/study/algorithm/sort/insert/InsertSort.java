package com.algorithm.study.algorithm.sort.insert;

/**
 * 直接插入排序
 * 二分查找插入排序---------一样需要移动元素。没什么优化。
 * <p>
 * 插入排序优化
 */
public class InsertSort {
    /**
     * 直接插入排序的原理：先将原序列分为有序区和无序区，然后再经过比较和后移操作将无序区元素插入到有序区中。
     * <p>
     * 具体如下（实现为升序）：
     * <p>
     * 设数组为a[0…n]。
     *
     * <p>i是分界线。将数组分为有序和无序。
     * <p>
     * 1.        将原序列分成有序区和无序区。a[0…i-1]为有序区，a[i…n] 为无序区。（i从1开始）
     * <p>
     * 2.        从无序区中取出第一个元素，即a[i]，在有序区序列中从后向前扫描。
     * <p>
     * 3.        如果有序元素大于a[i]，将有序元素后移到下一位置。
     * <p>
     * 4.        重复步骤3，直到找到小于或者等于a[i]的有序元素，将a[i]插入到该有序元素的下一位置中。
     * <p>
     * 5.        重复步骤2~4，直到无序区元素为0。
     * 直接插入排序
     *
     * @param arr
     */
    public static void directSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        int i, j;

        // 将arr分成有序区和无序区，初始有序区有一个元素
        // 0-(i-1) 为有序区；i-(length-1)为无序区 （i从1开始）
        for (i = 1; i < length; i++) {
            int temp = arr[i];
            // 边找位置边后移元素
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];    // 如果已排序的元素大于新元素，将该元素移到下一位置
            }

            // 将 arr[i] 放到正确位置上
            arr[j + 1] = temp;
        }
    }

    /**
     * 一个更好理解的希尔排序实现：将数组列在一个表中并对列排序（用插入排序）。
     * 重复这过程，不过每次用更长的列来进行。最后整个表就只有一列了。
     * 将数组转换至表是为了更好地理解这算法，算法本身仅仅对原数组进行排序
     * （通过增加索引的步长，例如是用i += step_size而不是i++ ）。
     * <p>
     * Donald Shell最初建议步长选择为 n/2 并且对步长取半直到步长达到1
     * <p>
     * 5列---------->3列---------->1列。
     * <p>
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
