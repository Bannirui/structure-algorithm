/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int len=0;
        if(height==null ||(len=height.length)==0) return 0;
        // two pointer
        int l=0, r=len-1;
        int ret=0;
        while(l<r){
            ret = Math.max(ret, (r-l)*(Math.min(height[l], height[r])));
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return ret;
    }
}
// @lc code=end

