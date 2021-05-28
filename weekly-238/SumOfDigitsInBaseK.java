
// https://leetcode.com/contest/weekly-contest-238/problems/sum-of-digits-in-base-k/

import java.util.PriorityQueue;

public class SumOfDigitsInBaseK {

  public int sumBase(int n, int k) {
    int sum = 0;
    do {
      sum += n % k;
      n /= k;
    } while (n != 0);
    return sum;
  }

  public boolean checkZeroOnes(String s) {
    char[] chr = s.toCharArray();
    int ones = 0;
    int mOne = 0;
    int zeros = 0;
    int mZero = 0;
    for (char c : chr) {
      if (c == '0') {
        zeros++;
        ones = 0;
      } else {
        ones++;
        zeros = 0;
      }
      mOne = Math.max(mOne, ones);
      mZero = Math.max(mZero, zeros);
    }
    return mOne > mZero;
  }
}
