package problem079;

/*

79. 单词搜索

给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */

class Solution {
    public static void main(String[] args) {
        boolean exist = new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println(exist);
    }

    //左上右下顺时针遍历
    int[][]     d = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    boolean[][] memo;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        memo = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int index, int startX, int startY) {
        char c = board[startX][startY];
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            memo[startX][startY] = true;
            //左上右下顺时针寻找
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (validate(newX, newY) && !memo[newX][newY] && find(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            memo[startX][startY] = false;
        }


        return false;
    }

    private boolean validate(int newX, int newY) {
        return newX >= 0 && newX < m && newY >= 0 && newY < n;
    }
}