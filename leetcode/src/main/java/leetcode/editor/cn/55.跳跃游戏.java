/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // 当前可以到达的右边界 遍历过程中动态维护
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(i<=max){
                max = Math.max(max, i+nums[i]);
                if(max>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

