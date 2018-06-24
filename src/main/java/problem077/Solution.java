package problem077;

import java.util.ArrayList;
import java.util.List;

/*

77. 组合

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        combination(n, k, 1, list);

        return result;
    }

    private void combination(int n, int k, int start, ArrayList<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n-(k-list.size())+1; i++) {
            list.add(i);
            combination(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }

    }
}