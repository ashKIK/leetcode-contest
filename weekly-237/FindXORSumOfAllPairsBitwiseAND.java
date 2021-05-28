
// https://leetcode.com/contest/weekly-contest-237/problems/find-xor-sum-of-all-pairs-bitwise-and/

public class FindXORSumOfAllPairsBitwiseAND {

  // distributive property
  // (a1^a2) & (b1^b2) = (a1&b1) ^ (a1&b2) ^ (a2&b1) ^ (a2&b2)
  public int getXORSum(int[] arr1, int[] arr2) {
    int xor1 = 0;
    for (int val : arr1) {
      xor1 ^= val;
    }
    int xor2 = 0;
    for (int val : arr2) {
      xor2 ^= val;
    }
    return xor1 & xor2;
  }
}
