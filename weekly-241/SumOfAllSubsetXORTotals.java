
// https://leetcode.com/contest/weekly-contest-241/problems/sum-of-all-subset-xor-totals/

public class SumOfAllSubsetXORTotals {

  public int subsetXORSum(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res |= num;
    }
    return res * (1 << nums.length - 1);
  }
}
