import java.util.PriorityQueue;

// https://leetcode.com/contest/weekly-contest-237/problems/single-threaded-cpu/

public class SingleThreadedCPU {

  // O(n*log(n))
  public int[] getOrder(int[][] tasks) {
    // Sort by enqueue time then by processing time
    PriorityQueue<int[]> taskQueue = new PriorityQueue<>(
        (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    // Sort by processing time then by id
    PriorityQueue<int[]> waitQueue = new PriorityQueue<>(
        (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

    for (int i = 0; i < tasks.length; i++) {
      taskQueue.offer(new int[]{tasks[i][0], tasks[i][1], i});
    }

    int[] result = new int[tasks.length];
    int finishedTime = -1;
    int idx = 0;

    while (!taskQueue.isEmpty() || !waitQueue.isEmpty()) {
      while (!taskQueue.isEmpty() && taskQueue.peek()[0] <= finishedTime) {
        waitQueue.offer(taskQueue.poll());
      }
      int[] task;
      if (!waitQueue.isEmpty()) {
        task = waitQueue.poll();
        finishedTime += task[1];
      } else { // taskQueue is empty
        task = taskQueue.poll();
        finishedTime = task[0] + task[1];
      }
      result[idx++] = task[2];
    }
    return result;
  }
}
