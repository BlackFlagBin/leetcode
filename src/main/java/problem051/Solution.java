package problem051;

import java.util.ArrayList;
import java.util.List;


/*

51. N皇后

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 */
class Solution {
    private boolean[]          col;
    private boolean[]          dia1;
    private boolean[]          dia2;
    private List<List<String>> result = new ArrayList<>();
    private List<Integer>      list   = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

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

            ArrayList<String> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Integer index = list.get(i);
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == index) {
                        temp.append("Q");
                    } else {
                        temp.append(".");
                    }
                }

                tempList.add(temp.toString());

            }

            result.add(tempList);
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