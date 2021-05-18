
// https://leetcode.com/contest/biweekly-contest-52/problems/rotating-the-box/

public class RotatingTheBox {

  public char[][] rotateTheBox(char[][] box) {
    int m = box.length;
    int n = box[0].length;
    char[][] res = new char[n][m];
    for (int i = 0; i < m; i++) {
      int pos = n - 1;
      for (int j = n - 1; j >= 0; j--) {
        if (box[i][j] == '.') {
          res[j][m - i - 1] = '.';
        } else if (box[i][j] == '*') {
          res[j][m - i - 1] = '*';
          if (j > 0) {
            pos = j - 1;
          }
        } else {
          res[pos][m - i - 1] = '#';
          if (pos != j) {
            res[j][m - i - 1] = '.';
          }
          pos--;
        }
      }
    }
    return res;
  }
}
