
// https://leetcode.com/contest/biweekly-contest-52/problems/sum-of-floored-pairs/

import java.util.Arrays;

public class SumOfFlooredPairs {

  // sweep
  public int sumOfFlooredPairs(int[] nums) {
    int max = Arrays.stream(nums).max().orElse(-1);
    int[] vals = new int[max + 1];
    for (int num : nums) {
      vals[num]++;
    }
    for (int i = max; i > 0; i--) {
      for (int j = 2 * i; j <= max; j += i) {
        vals[j] += vals[i];
      }
    }
    for (int i = 1; i < vals.length; i++) {
      vals[i] += vals[i - 1];
    }
    int res = 0;
    for (int num : nums) {
      res = (res + vals[num]) % 1000000007;
    }
    return res;
  }
}
