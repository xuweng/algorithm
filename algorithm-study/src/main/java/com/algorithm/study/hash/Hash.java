package com.algorithm.study.hash;

/**
 * 散列表
 */
public class Hash {
    /**
     * 获取散列表的填装因子
     * 一旦填装因子开始增大，你就需要在散列表中添加位置，这被称为调整长度（resizing）
     * 填装因子超过默认值就要扩容
     *
     * @param size     已经存放元素的个数
     * @param capacity 数组的容量，数组的length
     * @return
     */
    public static Integer getFillFactor(Integer size, Integer capacity) {
        return size / capacity;
    }
}
