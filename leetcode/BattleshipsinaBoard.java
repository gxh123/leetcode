public class BattleshipsinaBoard {

    public static void main(String[] args) {
        char[][] board = { { 'X', 'X', '.', 'X' }, { '.', '.', '.', 'X' }, { 'X', '.', '.', 'X' } };
        System.out.println(countBattleships(board));
    }

    public static int countBattleships(char[][] board) {
        if (board == null || board.length == 0)
            return 0;

        int battleshipCount = 0;
        int rsize = board.length;
        int csize = board[0].length;
        boolean[][] visited = new boolean[rsize][csize];
        for (int i = 0; i < rsize; i++) {
            for (int j = 0; j < csize; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    battleshipCount++;
                    DFS(board, visited, i, j);
                }
            }
        }
        return battleshipCount;
    }

    public static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 上下左右

    public static void DFS(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] || board[row][col] == '.')
            return;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            DFS(board, visited, row + direction[i][0], col + direction[i][1]);
        }
    }
}
