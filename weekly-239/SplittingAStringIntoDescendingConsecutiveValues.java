
// https://leetcode.com/contest/weekly-contest-239/problems/splitting-a-string-into-descending-consecutive-values/

public class SplittingAStringIntoDescendingConsecutiveValues {

  // TC: O(n*log(n))
  public boolean splitString(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (binarySearch(s, end, eval(s, start, end) - 1)) {
        return true;
      }
      end--;
    }
    return false;
  }

  private long eval(String s, int start, int end) {
    long num = 0;
    for (int i = start; i < end; i++) {
      num = num * 10 + (long) (s.charAt(i) - '0');
    }
    return num;
  }

  private boolean binarySearch(String s, int index, long target) {
    if (eval(s, index, s.length()) == target) {
      return true;
    }
    int left = index;
    int right = s.length();
    while (left < right) {
      int mid = right - (right - left) / 2;
      long num = eval(s, index, mid);
      if (num == target) {
        return binarySearch(s, mid, target - 1);
      }
      if (num > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return false;
  }

  // TC: O(n^2)
  public boolean splitString2(String s) {
    return dfs(s, 0, 0, 0);
  }

  private boolean dfs(String s, int pos, long curVal, long lastVal) {
    if (pos == s.length()) {
      return lastVal != 0;
    }
    if (curVal == 0 && lastVal != 0) {
      return false;
    }
    long val = 0;
    for (int i = pos; i < s.length(); i++) {
      val = val * 10 + (s.charAt(i) - '0');
      if (curVal == 0 || curVal == val + 1) {
        if (dfs(s, i + 1, val, curVal)) {
          return true;
        }
      }
    }
    return false;
  }
}
