package problem279;

/*

279. 完全平方数

给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
 */

import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(n, 0));
        ArrayList<Boolean> visitedList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            visitedList.add(false);
        }
        visitedList.set(n, true);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> headPair = queue.poll();
            Integer num = headPair.first;
            Integer step = headPair.second;
            for (int i = 1; ; i++) {

                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (a == 0) {
                    return step + 1;
                }
                if (!visitedList.get(a)) {
                    queue.offer(new Pair<>(a, step + 1));
                    visitedList.set(a, true);
                }
            }

        }
        return 0;
    }

    class Pair<K, V> {
        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}