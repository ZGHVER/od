package LeetCode;

import java.util.TreeSet;

@SuppressWarnings({"unused", "ControlFlowStatementWithoutBraces"})
public class shuDu {
    public static void main(String[] args) {
    }

    public boolean isValidSudoku(char[][] board) {
        TreeSet[][] area = new TreeSet[3][3];
        TreeSet[] column = new TreeSet[9];
        TreeSet[] row = new TreeSet[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                area[i][j] = new TreeSet<Character>();
                column[i * 3 + j] = new TreeSet<Character>();
                row[i * 3 + j] = new TreeSet<Character>();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[i][j];
                if (temp != '.') {
                    if (column[j].contains(temp))
                        return false;
                    else
                        column[j].add(temp);
                    if (row[i].contains(temp))
                        return false;
                    else
                        row[i].add(temp);
                    if (area[i / 3][j / 3].contains(temp))
                        return false;
                    else
                        area[i / 3][j / 3].add(temp);
                }
            }
        }
        return true;
    }

}
