package com.leetcode.tag.daily;

import org.junit.Test;

public class CourseScheduleTest {
  @Test
  public void replaceSpaceTest() {
    CourseSchedule courseSchedule = new CourseSchedule();
    int numCourses = 4;
    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

    courseSchedule.findOrder(numCourses, prerequisites);
  }
}
