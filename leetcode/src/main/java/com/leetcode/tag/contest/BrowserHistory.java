package com.leetcode.tag.contest;

/**
 * 一定要先看懂题目
 *
 * <p>一定要先看懂题目
 *
 * <p>一定要先看懂题目
 *
 * <p>先看懂题目再写代码
 *
 * <p>先看懂题目再写代码
 *
 * <p>先看懂题目再写代码
 *
 * <p>通过示例看懂题目
 *
 * <p>通过示例看懂题目
 *
 * <p>通过示例看懂题目
 *
 * <p>输入：
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * 输出：
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 *
 * <p>解释： BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com"); // 你原本在浏览 "leetcode.com" 。访问 "google.com"
 * browserHistory.visit("facebook.com"); // 你原本在浏览 "google.com" 。访问 "facebook.com"
 * browserHistory.visit("youtube.com"); // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
 * browserHistory.back(1); // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
 * browserHistory.back(1); // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
 * browserHistory.forward(1); // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
 * browserHistory.visit("linkedin.com"); // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
 * browserHistory.forward(2); // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。 browserHistory.back(2); // 你原本在浏览
 * "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
 * browserHistory.back(7); // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
 */
public class BrowserHistory {

  public BrowserHistory(String homepage) {
  }

  public void visit(String url) {
  }

  public String back(int steps) {
    return "";
  }

  public String forward(int steps) {
    return "";
  }

  /**
   * Your BrowserHistory object will be instantiated and called as such: BrowserHistory obj = new
   * BrowserHistory(homepage); obj.visit(url); String param_2 = obj.back(steps); String param_3 =
   * obj.forward(steps);
   */
}
