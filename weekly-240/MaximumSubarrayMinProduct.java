
// https://leetcode.com/contest/weekly-contest-240/problems/maximum-subarray-min-product/

import java.util.Stack;

public class MaximumSubarrayMinProduct {

  public int maxSumMinProduct(int[] nums) {
    int n = nums.length;
    int[] leftBound = new int[n + 1];
    int[] rightBound = new int[n + 1];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        leftBound[i] = 0;
      } else {
        leftBound[i] = stack.peek() + 1;
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        rightBound[i] = n - 1;
      } else {
        rightBound[i] = stack.peek() - 1;
      }
      stack.push(i);
    }
    long[] preSum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      preSum[i + 1] = preSum[i] + nums[i];
    }
    long maxProduct = 0;
    for (int i = 0; i < n; i++) {
      maxProduct = Math.max(maxProduct, nums[i] * getSum(preSum, leftBound[i], rightBound[i]));
    }
    return (int) (maxProduct % 1000000007);
  }

  private long getSum(long[] preSum, int left, int right) {
    if (left > right) {
      return 0;
    }
    return preSum[right + 1] - preSum[left];
  }
}
