package problem215;

/*
215. 数组中的第K个最大元素

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {

        int position=nums.length-k;

        return find(nums, 0, nums.length - 1, position);
    }

    private int find(int[] nums, int left, int right, int position) {
        int partition = partition(nums, left, right);
        if (partition == position ) {
            return nums[partition];
        } else if (partition > position) {
            return find(nums, left, partition - 1, position);
        } else {
            return find(nums, partition + 1, right, position);
        }
    }

    private int partition(int[] array, int left, int right) {
        //[left+1 ... k]小于array[left]；[k+1 ... i]大于等于array[left]
        int k = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, ++k, i);
            }
        }
        swap(array, left, k);
        return k;
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}