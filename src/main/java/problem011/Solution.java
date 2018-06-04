package problem011;

/*
11. 盛最多水的容器

给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

注意：你不能倾斜容器，n 至少是2。
 */

class Solution {
    public int maxArea(int[] height) {
        //指针对撞，如果height[l]<height[r],只有l增大才可能会扩大面积，因为r-l代表宽度，这个宽度会不断减少。反之同理。
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}