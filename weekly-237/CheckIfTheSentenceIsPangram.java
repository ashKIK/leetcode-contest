import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/contest/weekly-contest-237/problems/check-if-the-sentence-is-pangram/

public class CheckIfTheSentenceIsPangram {

  public boolean checkIfPangram(String sentence) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < sentence.length(); i++) {
      set.add(sentence.charAt(i));
    }
    return set.size() == 26;
  }
}
