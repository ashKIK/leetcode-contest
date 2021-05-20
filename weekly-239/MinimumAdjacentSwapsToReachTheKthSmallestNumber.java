
// https://leetcode.com/contest/weekly-contest-239/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/

public class MinimumAdjacentSwapsToReachTheKthSmallestNumber {

  public int getMinSwaps(String num, int k) {
    char[] original = num.toCharArray();
    char[] nums = original.clone();
    while (k-- > 0) {
      nextPermutation(nums);
    }
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      while (original[i] != nums[i]) {
        ans++;
        swap(nums, i, j++);
      }
    }
    return ans;
  }

  public void nextPermutation(char[] nums) {
    if (nums.length <= 1) {
      return;
    }
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.length - 1;
      while (j > i && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1, nums.length - 1);
  }

  private void reverse(char[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left++, right--);
    }
  }

  private void swap(char[] nums, int i, int j) {
    char temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }
}
