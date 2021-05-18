import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

// https://leetcode.com/contest/biweekly-contest-52/problems/sorting-the-sentence/

public class SortingTheSentence {

  public String sortSentence(String s) {
    String[] str = s.split(" ");
    Arrays.sort(str, Comparator.comparingInt(word -> word.charAt(word.length() - 1)));
    StringJoiner res = new StringJoiner(" ");
    for (String word : str) {
      res.add(word.substring(0, word.length() - 1));
    }
    return res.toString();
  }
}
