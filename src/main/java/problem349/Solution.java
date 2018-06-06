package problem349;

/*
349. 两个数组的交集

给定两个数组，写一个函数来计算它们的交集。

例子:

 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

提示:

每个在结果中的元素必定是唯一的。
我们可以不考虑输出结果的顺序。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //利用Set只能存放不同元素的特性
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int value : nums1) {
            set.add(value);
        }
        for (int value : nums2) {
            if (set.contains(value)) {
                resultSet.add(value);
            }
        }


        //将set转换成数组
        int[] resultArray = new int[resultSet.size()];
        int index = 0;
        for (Integer value : resultSet) {
            resultArray[index++] = value;
        }


        return resultArray;
    }
}