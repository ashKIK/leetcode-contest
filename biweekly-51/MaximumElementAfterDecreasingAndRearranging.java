import java.util.Arrays;

// https://leetcode.com/contest/biweekly-contest-51/problems/maximum-element-after-decreasing-and-rearranging/

public class MaximumElementAfterDecreasingAndRearranging {

  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    Arrays.sort(arr);
    int cur = 0;
    for (int v : arr) {
      cur = Math.min(cur + 1, v);
    }
    return cur;
  }
}
