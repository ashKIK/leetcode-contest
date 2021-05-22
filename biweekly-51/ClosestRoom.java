import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

// https://leetcode.com/contest/biweekly-contest-51/problems/closest-room/

public class ClosestRoom {

  // sort queries in decreasing minSize order.
  // sort rooms in decreasing size order.
  // roomIdsSoFar treeSet includes all room ids which have size >= minSize of current query so far.
  // For each query:
  //  - Add all room ids which have size >=minSize of current query.
  //  - Query floor and ceiling of q[0] (preferredId) from roomIdsSoFar
  //    to pick the id which closest to our preferredId

  // online query processing
  // floor and ceiling operate in O(logN)
  // TC: O(NlogN + KlogK + KlogN)
  // SC: O(N + K)
  public int[] closestRoom(int[][] rooms, int[][] queries) {
    Integer[] indices = new Integer[queries.length];
    for (int i = 0; i < queries.length; i++) {
      indices[i] = i;
    }
    // Sort by decreasing order of room size
    Arrays.sort(rooms, Comparator.comparingInt(a -> a[1]));
    // Sort by decreasing order of query minSize
    Arrays.sort(indices, (a, b) -> Integer.compare(queries[b][1], queries[a][1]));
    TreeSet<Integer> roomIdsSoFar = new TreeSet<>();
    int[] result = new int[queries.length];
    int id = 0;
    for (int index : indices) {
      // Add id of the room when its size >= query minSize
      while (id < rooms.length && rooms[id][1] >= queries[index][1]) {
        roomIdsSoFar.add(rooms[id++][0]);
      }
      result[index] = searchClosetRoomId(roomIdsSoFar, queries[index][0]);
    }
    return result;
  }

  private int searchClosetRoomId(TreeSet<Integer> roomIdsSoFar, int preferredId) {
    Integer floor = roomIdsSoFar.floor(preferredId);
    Integer ceiling = roomIdsSoFar.ceiling(preferredId);
    int k = Integer.MAX_VALUE;
    int closestRoomId = -1;
    if (floor != null) {
      closestRoomId = floor;
      k = Math.abs(preferredId - floor);
    }
    if (ceiling != null) {
      if (k > Math.abs(preferredId - ceiling)) {
        closestRoomId = ceiling;
      }
    }
    return closestRoomId;
  }
}
