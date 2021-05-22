
// https://leetcode.com/contest/biweekly-contest-51/problems/replace-all-digits-with-characters/

public class ReplaceAllDigitsWithCharacters {

  public String replaceDigits(String s) {
    StringBuilder str = new StringBuilder(s.length());
    for (int i = 0; i < s.length(); i++) {
      str.append(i % 2 == 0 ? s.charAt(i) : shift(s, i));
    }
    return str.toString();
  }

  private char shift(String s, int idx) {
    return (char) (s.charAt(idx - 1) + (s.charAt(idx) - '0'));
  }
}
