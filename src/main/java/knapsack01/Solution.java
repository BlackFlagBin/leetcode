package knapsack01;

/*
 *  0-1背包问题
 */

class Solution {
    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {
        memo = new int[w.length][C + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w, v, w.length - 1, C);
    }

    //递归解法
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        int res = bestValue(w, v, index - 1, c);
        if (w[index] <= c) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }

    //动态规划法
    private int knapsack01Dynamic(int[] w, int[] v, int C) {
        int[] memo = new int[C + 1];
        for (int i = 0; i < C + 1; i++) {
            memo[i] = -1;
        }

        //初始化第一行
        for (int i = 0; i < memo.length; i++) {
            if (w[0] > i) {
                memo[i] = 0;
            } else {
                memo[i] = v[0];
            }
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = C; j >= w[i]; j--) {
                if (j >= w[i]) {
                    memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
                }
            }
        }

        return memo[C];
    }
}
