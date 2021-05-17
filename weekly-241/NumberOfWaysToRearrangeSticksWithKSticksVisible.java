
// https://leetcode.com/contest/weekly-contest-241/problems/number-of-ways-to-rearrange-sticks-with-k-sticks-visible/

public class NumberOfWaysToRearrangeSticksWithKSticksVisible {

  private final int[][] dp = new int[1001][1001];
  private final int MOD = 1000000007;

  public int rearrangeSticks(int n, int k) {
    if (n == k) {
      return 1;
    }
    if (k == 0) {
      return 0;
    }
    if (dp[n][k] == 0) {
      dp[n][k] = (int) (((long) rearrangeSticks(n - 1, k - 1)
          + (long) rearrangeSticks(n - 1, k) * (n - 1)) % MOD);
    }
    return dp[n][k];
  }
}
