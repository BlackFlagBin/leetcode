package problem416;

/*
416. Partition Equal Subset Sum

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in
both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
 */
class Solution {
    //存放重复计算的数据，-1：未访问，0：false，1：true
    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        memo = new int[nums.length][sum + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }

        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    //递归解法
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index < 0 || sum < 0) {
            return false;
        }
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        boolean result = tryPartition(nums, index - 1, sum) || tryPartition(nums, index - 1, sum - nums[index]);
        memo[index][sum] = result ? 1 : 0;
        return result;
    }

    //动态规划解法
    private boolean canPartitionDynamic(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] memo = new boolean[sum / 2 + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = (nums[0] == i);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                if (j >= nums[i]) {
                    memo[j] = memo[j] || memo[j - nums[i]];
                }
            }
        }
        return memo[sum / 2];
    }
}