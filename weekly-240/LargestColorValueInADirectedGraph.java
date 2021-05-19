
// https://leetcode.com/contest/weekly-contest-240/problems/largest-color-value-in-a-directed-graph/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInADirectedGraph {

  // Topological sort + DP
  public int largestPathValue(String colors, int[][] edges) {
    int n = colors.length();
    List<List<Integer>> childToParent = new ArrayList<>();
    List<List<Integer>> parentToChildren = new ArrayList<>();
    int[] outDegree = new int[n];
    for (int i = 0; i < n; i++) {
      childToParent.add(new ArrayList<>());
      parentToChildren.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      childToParent.get(to).add(from);
      parentToChildren.get(from).add(to);
      outDegree[from]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    int[][] dp = new int[n][26];
    for (int i = 0; i < n; i++) {
      if (outDegree[i] == 0) {
        queue.add(i);
      }
    }
    int res = 0;
    int count = n;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      count--;
      int nodeColor = colors.charAt(node) - 'a';
      for (int i = 0; i < 26; i++) {
        for (int prev : parentToChildren.get(node)) {
          dp[node][i] = Math.max(dp[node][i], dp[prev][i]);
        }
      }
      dp[node][nodeColor]++;
      res = Math.max(res, dp[node][nodeColor]);
      for (int parent : childToParent.get(node)) {
        outDegree[parent]--;
        if (outDegree[parent] == 0) {
          queue.add(parent);
        }
      }
    }
    return count > 0 ? -1 : res;
  }
}
