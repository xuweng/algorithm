package com.leetcode.tag.contest;

import org.junit.Test;

public class BrowserHistoryTest {
  @Test
  public void test() {
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com"); // 你原本在浏览 "leetcode.com" 。访问 "google.com"
    browserHistory.visit("facebook.com"); // 你原本在浏览 "google.com" 。访问 "facebook.com"
    browserHistory.visit("youtube.com"); // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
    browserHistory.back(1); // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
    browserHistory.back(1); // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
    browserHistory.forward(1); // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
    browserHistory.visit("linkedin.com"); // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
    browserHistory.forward(2); // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
    browserHistory.back(
            2); // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
    browserHistory.back(7); // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
  }

  @Test
  public void test1() {
    BrowserHistory browserHistory = new BrowserHistory("zav.com");
    browserHistory.visit("kni.com"); // 你原本在浏览 "leetcode.com" 。访问 "google.com"
    browserHistory.back(7); // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
    browserHistory.back(7); // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
    browserHistory.forward(5); // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
    browserHistory.forward(1); // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
    browserHistory.visit("pwrrbnw.com"); // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
    browserHistory.visit("mosohif.com"); // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
    browserHistory.back(
            9); // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
  }
}
