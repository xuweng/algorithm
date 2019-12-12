package com.algorithm.study.algorithm.hash;

/**
 * 散列表
 * 复杂度:O(1)
 * 散列表是一对一映射,图是一对多映射
 */
public class Hash {
    /**
     * 获取散列表的填装因子
     * 一旦填装因子开始增大，你就需要在散列表中添加位置，这被称为调整长度（resizing）
     * 填装因子超过默认值就要扩容
     * 一个不错的经验规则是：一旦填装因子大于0.7，就调整散列表的长度。
     * 平均而言，即便考虑到调整长度所需的时间，散列表操作所需的时间也为O(1)。
     *
     * @param size     已经存放元素的个数
     * @param capacity 数组的容量，数组的length
     * @return
     */
    public static Integer getFillFactor(Integer size, Integer capacity) {
        return size / capacity;
    }
}
