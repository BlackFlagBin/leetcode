package problem001;

/*
1. 两数之和

给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //存放元素和它的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int targetValue = target - nums[i];
            if (map.get(targetValue) != null) {
                return new int[]{map.get(targetValue), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}