
// https://leetcode.com/contest/weekly-contest-240/problems/maximum-population-year/

public class MaximumPopulationYear {

  public int maximumPopulation(int[][] logs) {
    int maxPopSoFar = 0;
    int year = 0;
    for (int i = 1950; i <= 2050; i++) {
      int pop = 0;
      for (int[] log : logs) {
        if (i >= log[0] && i < log[1]) {
          pop++;
        }
      }
      if (pop > maxPopSoFar) {
        maxPopSoFar = pop;
        year = i;
      }
    }
    return year;
  }
}
