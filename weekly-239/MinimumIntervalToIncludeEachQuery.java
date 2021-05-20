import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// https://leetcode.com/contest/weekly-contest-239/problems/minimum-interval-to-include-each-query/

public class MinimumIntervalToIncludeEachQuery {

  public int[] minInterval(int[][] intervals, int[] queries) {
    Arrays.sort(intervals, (a, b) -> (b[0] - a[0] - (b[1] - a[1])));
    TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
    for (int i = 0; i < queries.length; i++) {
      treeMap.computeIfAbsent(queries[i], a -> new ArrayList<>()).add(i);
    }
    int[] result = new int[queries.length];
    Arrays.fill(result, -1);
    for (int[] interval : intervals) {
      int left = interval[0];
      int right = interval[1];
      Map<Integer, List<Integer>> sub =
          treeMap.subMap(left, true, right, true);
      for (List<Integer> list : sub.values()) {
        for (int i : list) {
          result[i] = right - left + 1;
        }
      }
      treeMap.keySet().removeAll(Set.copyOf(sub.keySet()));
    }
    return result;
  }
}
