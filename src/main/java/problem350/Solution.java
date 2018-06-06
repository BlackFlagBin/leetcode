package problem350;

/*
350. 两个数组的交集 II

给定两个数组，写一个方法来计算它们的交集。

例如:
给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

注意：

   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
   我们可以不考虑输出结果的顺序。
跟进:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？

 */

import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] resultArray = solution.intersect(new int[]{2, 1}, new int[]{1, 2});
        System.out.println(resultArray);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        //利用map记录nums1中元素出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            if (value != null) {
                map.put(nums1[i], ++value);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            Integer mapValue = map.get(nums2[i]);
            if (mapValue != null && mapValue > 0) {
                Integer value = resultMap.get(nums2[i]);
                if (value != null) {
                    resultMap.put(nums2[i], ++value);
                } else {
                    resultMap.put(nums2[i], 1);
                }
                map.put(nums2[i], --mapValue);
            }
        }

        int arraySize = 0;
        for (Integer integer : resultMap.keySet()) {
            arraySize += resultMap.get(integer);
        }
        int[] resultArray = new int[arraySize];
        int index = 0;
        for (Integer integer : resultMap.keySet()) {
            for (int i = 0; i < resultMap.get(integer); i++) {
                resultArray[index++] = integer;
            }
        }

        return resultArray;
    }
}