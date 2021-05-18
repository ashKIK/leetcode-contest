
// https://leetcode.com/contest/biweekly-contest-52/problems/incremental-memory-leak/

public class IncrementalMemoryLeak {

  public int[] memLeak(int memory1, int memory2) {
    int second;
    for (second = 1; memory1 >= second || memory2 >= second; second++) {
      if (memory2 > memory1) {
        memory2 -= second;
      } else {
        memory1 -= second;
      }
    }
    return new int[]{second, memory1, memory2};
  }
}
