import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j]))
                        return false;
                    rowSet.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (rowSet.contains(board[j][i]))
                        return false;
                    rowSet.add(board[j][i]);
                }
                // 简直神奇
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
                        && !cubeSet.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    // 作为最原始的解法，下面这种解法冗余在三个循环，遍历了3次，应该考虑只使用一个循环
    public static boolean isValidSudoku2(char[][] board) {
        // 判断行
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
        }
        // 判断列
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i]))
                        return false;
                    set.add(board[j][i]);
                }
            }
        }
        // 判断3*3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<>();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i * 3 + m][j * 3 + n] != '.') {
                            if (set.contains(board[i][j]))
                                return false;
                            set.add(board[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }

}
