/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int res=0;
        // 双指针
        int l=0;
        int r = height.length-1;
        while(l<r){
            int leftVal = height[l];
            int rightVal = height[r];
            int width = r-l;
            int high = Math.min(leftVal, rightVal);
            res = Math.max(res, width*high);
            // 寻找可能的最大值
            if(leftVal<rightVal){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
// @lc code=end

