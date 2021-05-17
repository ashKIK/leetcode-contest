import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/contest/weekly-contest-241/problems/finding-pairs-with-a-certain-sum/

public class FindingPairsWithACertainSum {

  class FindSumPairs {

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
      this.map = new HashMap<>();
      this.nums1 = nums1;
      this.nums2 = nums2;
      for (int num2 : nums2) {
        map.merge(num2, 1, Integer::sum);
      }
    }

    public void add(int index, int val) {
      map.merge(nums2[index], -1, Integer::sum);
      nums2[index] += val;
      map.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
      int count = 0;
      for (int num : nums1) {
        count += map.getOrDefault(tot - num, 0);
      }
      return count;
    }
  }

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
}
