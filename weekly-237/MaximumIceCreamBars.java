import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-237/problems/maximum-ice-cream-bars/

public class MaximumIceCreamBars {

  public int maxIceCream(int[] costs, int coins) {
    int totalCost = 0;
    int iceCreams = 0;
    Arrays.sort(costs);
    for (int cost : costs) {
      if (totalCost + cost <= coins) {
        totalCost += cost;
        iceCreams++;
      }
    }
    return iceCreams;
  }
}
