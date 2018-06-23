package problem046;

import java.util.ArrayList;
import java.util.List;

/*
46. 全排列

给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[]           memo;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        memo = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        permutation(nums, 0, list);
        return result;
    }

    private void permutation(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            ArrayList<Integer> copiedList = new ArrayList<>(list);
            result.add(copiedList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!memo[i]) {
                memo[i] = true;
                list.add(nums[i]);
                permutation(nums, index + 1, list);
                list.remove(list.size() - 1);
                memo[i] = false;
            }
        }

    }
}