package com.algorithm.study.algorithm.sort.insert;

/**
 * 冒泡:扫描----------是否需要交换?
 * 插入、选择----------划分有序区和无序区。冒泡没有划分。
 * 有序区---------最后一个数最大。
 * <p>
 * 直接插入排序
 * 二分查找插入排序---------一样需要移动元素。没什么优化。
 * <p>
 * 插入排序优化
 * <p>
 * 希尔排序（Shellsort），也称递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
 * <p>
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * <p>
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
 */
public class InsertSort {
    /**
     * 逆序:O(n2)
     * 正序:O(n)。不需要移动元素。
     * <p>
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

        // 将arr分成有序区和无序区，初始有序区有一个元素
        // 0-(i-1) 为有序区；i-(length-1)为无序区 （i从1开始）
        for (int i = 1; i < length; i++) {
            int temp = arr[i], j = i - 1;
            // 边找位置边后移元素
            //arr[j]是有序区最后一个元素。也是有序区最大的元素。
            //条件写在循环条件里面很巧妙。
            for (; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];    // 如果已排序的元素大于新元素，将该元素移到下一位置
            }

            // 将 arr[i] 放到正确位置上
            arr[j + 1] = temp;
        }
    }

    /**
     * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。
     * 这样可以让一个元素可以一次性地朝最终位置前进一大步。
     * 然后算法再取越来越小的步长进行排序，
     * 算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
     * <p>
     * 每次对列排序都会增加有序度。
     * <p>
     * 和基数排序不一样。基数排序列排序时行跟着移动;希尔排序只有列排序，行不动。
     * <p>
     * 一个更好理解的希尔排序实现：将数组列在一个表中并对所有列排序（用插入排序）。
     * 重复这过程，不过每次用更长的列来进行。最后整个表就只有一列了。
     * 将数组转换至表是为了更好地理解这算法，算法本身仅仅对原数组进行排序
     * （通过增加索引的步长，例如是用i += step_size而不是i++ ）。
     * <p>
     * 这里是对列排序。对行排序也可以。
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

    /**
     * 希尔排序
     * <p>
     * space=1时就是普通的插入排序
     *
     * @param arr
     */
    public static void ShellSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }
        // 间隔增量，所有距离为space的倍数的记录放在同一个组中
        int space = length / 2;
        while (space >= 1) {
            shellInsert(arr, length, space);
            // 每次增量为原先的1/2
            space = space / 2;
        }
    }

    /**
     * 根据步长来将数据分组。
     * <p>
     * https://www.cnblogs.com/heyuquan/p/insert-sort.html
     * <p>
     * 一次步长的希尔子序列排序
     * <p>
     * 对于普通插入排序。space=1。
     *
     * @param arr    待排序数组
     * @param length 待排序数组长度
     * @param space  间隔增量
     */
    private static void shellInsert(int[] arr, int length, int space) {
        // 将arr子序列分成有序区和无序区，初始有序区有一个元素
        // 0-(i-1) 为有序区；i-(length-1)为无序区

        //这里虽然是i++，但是数据量变少。数据量仅仅是同一组的数据。
        for (int i = space; i < length; i++) {
            int temp = arr[i];
            //j是有序区
            int j = i - space;
            // 边找位置边后移元素
            for (; j >= 0 && arr[j] > temp; j = j - space) {
                // 如果已排序的元素大于新元素，将该元素移到下一位置
                //普通移动是一个一个元素移动。这里移动是按照增量移动。用i += step_size而不是i++
                arr[j + space] = arr[j];
            }
            // 将 arr[i] 放到正确位置上
            arr[j + space] = temp;
        }
    }
}
