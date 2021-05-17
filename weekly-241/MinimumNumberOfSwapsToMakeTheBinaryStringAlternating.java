
// https://leetcode.com/contest/weekly-contest-241/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/

public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {

  public int minSwaps(String s) {
    int numOnes = 0;
    int numZeros = 0;
    int countOnes = 0;
    int countZeros = 0;

    // two patters; either 10101 or 01010
    char one = '1';
    char zero = '0';

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '1') {
        numOnes++;
      }
      if (c == '0') {
        numZeros++;
      }
      if (c != one) {
        countOnes++;
      }
      if (c != zero) {
        countZeros++;
      }
      // alternate the 10101 or 01010 pattern
      one = one == '1' ? '0' : '1';
      zero = zero == '1' ? '0' : '1';
    }
    if (Math.abs(numOnes - numZeros) > 1) {
      return -1;
    }
    // if the difference is odd, then impossible to make 10101 pattern, make 01010 instead
    // vice versa
    if (countOnes % 2 == 1) {
      return countZeros / 2;
    }
    if (countZeros % 2 == 1) {
      return countOnes / 2;
    }
    // if able to alter to both patters then return minimum
    return Math.min(countOnes / 2, countZeros / 2);
  }
}
