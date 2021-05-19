
// https://leetcode.com/contest/weekly-contest-240/problems/maximum-distance-between-a-pair-of-values/

public class MaximumDistanceBetweenAPairOfValues {

  public int maxDistance(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int max = 0;
    while (i < nums1.length) {
      while (j < nums2.length && nums1[i] <= nums2[j]) {
        j++;
      }
      max = Math.max(max, j - i - 1);
      i++;
    }
    return max;
  }
}
