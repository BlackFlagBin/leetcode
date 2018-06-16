package problem343;

/*
343. 整数拆分

给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

例如，给定 n = 2，返回1（2 = 1 + 1）；给定 n = 10，返回36（10 = 3 + 3 + 4）。

注意：你可以假设 n 不小于2且不大于58。
 */

class Solution {
    //存放重叠子问题的解
    private int[] array;

    public int integerBreak(int n) {
        array = new int[n + 1];
        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }
        return breakInteger(n);
    }

    //递归解法
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (array[n] != -1) {
            return array[n];
        }
        int result = -1;
        for (int i = 1; i <= n - 1; i++) {
            result = max3(result, i * (n - i), i * breakInteger(n - i));
        }
        array[n] = result;
        return result;
    }

    //动态规划解法
    private int integerBreak2(int n) {
        array[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i - 1; j++) {
                array[i] = max3(array[i], j * (i - j), j * array[i - j]);
            }
        }
        return array[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


}