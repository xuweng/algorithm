package com.leetcode.tag.contest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
  int backCount;
  Deque<String> visitDeque;
  Deque<String> forwardDeque;

  public BrowserHistory(String homepage) {
    visitDeque = new ArrayDeque<>();
    forwardDeque = new ArrayDeque<>();

    visitDeque.push(homepage);
  }

  public void visit(String url) {
    backCount = 0;

    visitDeque.push(url);
  }

  public String back(int steps) {
    if (steps < visitDeque.size()) {
      for (int i = 0; i < steps; i++) {
        forwardDeque.push(visitDeque.pop());
        backCount++;
      }
    } else {
      while (visitDeque.size() != 1) {
        forwardDeque.push(visitDeque.pop());
        backCount++;
      }
    }

    return visitDeque.peek();
  }

  public String forward(int steps) {
    if (backCount == 0) {
      return visitDeque.peek();
    }
    int size = Math.min(steps, backCount);
    for (int i = 0; i < size && !forwardDeque.isEmpty(); i++) {
      visitDeque.push(forwardDeque.pop());
    }

    return visitDeque.peek();
  }

  /**
   * 作者：miaomiao-2
   * 链接：https://leetcode-cn.com/problems/design-browser-history/solution/java-yi-ge-lie-biao-suo-you-cao-zuo-o1-by-miaomiao/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class BrowserHistory1 {
    List<String> list;
    int cur = -1;
    int end = -1; // 有效地址的最后一个

    public BrowserHistory1(String homepage) {
      list = new ArrayList<>();
      visit(homepage);
    }

    public void visit(String url) {
      cur++;
      if (list.size() <= cur) {
        list.add(url);
      } else {
        list.set(cur, url);
      }
      end = cur;
    }

    public String back(int steps) {
      cur = Math.max(cur - steps, 0);
      return list.get(cur);
    }

    public String forward(int steps) {
      cur = Math.min(cur + steps, end);
      return list.get(cur);
    }
  }

  /**
   * Your BrowserHistory object will be instantiated and called as such: BrowserHistory obj = new
   * BrowserHistory(homepage); obj.visit(url); String param_2 = obj.back(steps); String param_3 =
   * obj.forward(steps);
   */

  /**
   * Your BrowserHistory object will be instantiated and called as such: BrowserHistory obj = new
   * BrowserHistory(homepage); obj.visit(url); String param_2 = obj.back(steps); String param_3 =
   * obj.forward(steps);
   */
}
