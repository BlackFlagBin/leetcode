package problem88;

/*
88. 合并两个有序数组

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        if (n == 0) {
            return;
        }

        //如果nums1的最大值小于nums2的最小值
        if (nums1[m - 1]<nums2[0]) {
            System.arraycopy(nums2, 0, nums1, m, n );
            return;
        }

        //复制数组1中的有效数据
        int[] tempNums1 = new int[m];
        for (int i = 0; i < m; i++) {
            tempNums1[i] = nums1[i];
        }

        //i表示最终数组nums1中的当前索引；j表示tempNums1中的当前索引；k表示nums2中的当前索引
        int j = 0;
        int k = 0;

        for (int i = 0; i < n + m; i++) {
            if (j == m) {
                nums1[i] = nums2[k++];
                continue;
            }

            if (k == n) {
                nums1[i] = tempNums1[j++];
                continue;
            }


            if (tempNums1[j] < nums2[k]) {
                nums1[i] = tempNums1[j++];
            } else {
                nums1[i] = nums2[k++];
            }
        }
    }
}