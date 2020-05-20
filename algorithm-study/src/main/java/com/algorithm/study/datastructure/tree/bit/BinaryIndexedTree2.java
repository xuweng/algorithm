package com.algorithm.study.datastructure.tree.bit;

/**
 * 现多用于高效计算数列的前缀和， 区间和。它可以以O(log n)的时间得到任意前缀和
 *
 * <p>并同时支持在O(log n)时间内支持动态单点值的修改。空间复杂度O(n)
 *
 * <p>能做什么?
 *
 * <p>数据结构能做什么?
 */
public class BinaryIndexedTree2 {
  private final int[] bitArr;

  public BinaryIndexedTree2(int[] list) {
    // O(n) initialization
    this.bitArr = new int[list.length + 1];
    System.arraycopy(list, 0, this.bitArr, 1, list.length);

    for (int i = 1; i < this.bitArr.length; i++) {
      int j = i + (i & -i);
      if (j < this.bitArr.length) {
        this.bitArr[j] += this.bitArr[i];
      }
    }
  }

  /**
   * Add `delta` to elements in `idx` of original array
   *
   * @param idx   index of the element in original array that is going to be updated
   * @param delta number that will be added to the original element.
   */
  public void update(int idx, int delta) {
    idx += 1;
    while (idx < this.bitArr.length) {
      this.bitArr[idx] += delta;
      idx = idx + (idx & -idx);
    }
  }

  /**
   * Get the sum of elements in the original array up to index `idx`
   *
   * @param idx index of the last element that should be summed.
   * @return sum of elements from index 0 to `idx`.
   */
  public int prefixSum(int idx) {
    idx += 1;
    int result = 0;
    while (idx > 0) {
      result += this.bitArr[idx];
      idx = idx - (idx & -idx);
    }

    return result;
  }

  /**
   * Get the range sum of elements from original array from index `fromIdx` to `toIdx`
   *
   * @param fromIdx start index of element in original array
   * @param toIdx end index of element in original array
   * @return range sum of elements from index `fromIdx` to `toIdx`
   */
  public int rangeSum(int fromIdx, int toIdx) {
    return prefixSum(toIdx) - prefixSum(fromIdx - 1);
  }
}
