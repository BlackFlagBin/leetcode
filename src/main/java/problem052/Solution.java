package problem052;


/*

52. N皇后 II

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean[]     col;
    private boolean[]     dia1;
    private boolean[]     dia2;
    private int           result = 0;
    private List<Integer> list   = new ArrayList<>();

    public int totalNQueens(int n) {

        col = new boolean[n];
        for (int i = 0; i < n; i++) {
            col[i] = false;
        }
        dia1 = new boolean[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            dia1[i] = false;
        }
        dia2 = new boolean[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            dia2[i] = false;
        }

        find(n, 0);


        return result;
    }

    private void find(int n, int rowIndex) {
        if (rowIndex == n) {
            result++;
        }

        //在rowIndex这一行中查找合适的位置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[rowIndex + i] && !dia2[rowIndex - i + n - 1]) {
                list.add(i);
                col[i] = true;
                dia1[rowIndex + i] = true;
                dia2[rowIndex - i + n - 1] = true;

                find(n, rowIndex + 1);

                list.remove(list.size() - 1);
                col[i] = false;
                dia1[rowIndex + i] = false;
                dia2[rowIndex - i + n - 1] = false;
            }
        }
    }
}