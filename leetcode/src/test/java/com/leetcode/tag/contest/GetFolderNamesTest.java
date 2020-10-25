package com.leetcode.tag.contest;

import com.leetcode.tag.contest.one.GetFolderNames;
import org.junit.Test;

public class GetFolderNamesTest {
  @Test
  public void test() {
    /**
     * 我的输入 ["o(1)","o","o(1)","o","o(4)","o"]
     *
     * <p>我的答案 ["o(1)","o","o(1)(1)","o(3)","o(4)","o(2)"]
     *
     * <p>预期答案 ["o(1)","o","o(1)(1)","o(2)","o(4)","o(3)"]
     */
    GetFolderNames getFolderNames = new GetFolderNames();

    // 特殊测试用例
    String[] strings = {"o(1)", "o", "o(1)", "o", "o(4)", "o"};

    getFolderNames.getFolderNames(strings);
  }
}
