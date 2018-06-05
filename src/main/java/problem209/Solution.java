package problem209;

/*
209. 长度最小的子数组

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组。如果不存在符合条件的子数组，返回 0。

示例:

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //滑动窗口 [l ... r] 满足和 ≥ s
        int l = 0;
        int r = -1;
        int sum = 0;
        int result = nums.length + 1;

        while (l < nums.length) {

            if (sum < s && r < nums.length - 1) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                result = Math.min(result, r - l + 1);
            }

        }


        //如果遍历完整个数组还没找到，返回0
        if (result == nums.length + 1) {
            return 0;
        }


        return result;
    }
}