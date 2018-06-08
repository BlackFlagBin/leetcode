package problem447;

/*
447. 回旋镖的数量

给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:

输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(result);
    }

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;

        for (int i = 0; i < points.length; i++) {

            //key:点i距离的平方,value:相同距离的点的个数
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    Integer value = map.get(distance(points[i], points[j]));
                    if (value == null) {
                        map.put(distance(points[i], points[j]), 1);
                    } else {
                        map.put(distance(points[i], points[j]), ++value);
                    }
                }
            }

            Set<Integer> keySet = map.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                Integer value = map.get(iterator.next());
                if (value >= 2) {
                    result += value * (value - 1);
                }
            }

        }

        return result;
    }

    private int distance(int[] first, int[] second) {
        return (first[0] - second[0]) * (first[0] - second[0]) + (first[1] - second[1]) * (first[1] - second[1]);
    }
}