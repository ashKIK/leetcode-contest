import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/contest/biweekly-contest-51/problems/seat-reservation-manager/

public class SeatReservationManager {

  class SeatManager {

    private int count;
    private final Queue<Integer> queue;

    public SeatManager(int n) {
      this.count = 1;
      this.queue = new PriorityQueue<>();
    }

    public int reserve() {
      if (queue.isEmpty()) {
        return count++;
      }
      return queue.poll();
    }

    public void unreserve(int seatNumber) {
      queue.offer(seatNumber);
    }
  }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
