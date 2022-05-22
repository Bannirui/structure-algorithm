/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int most=0;
        for(int i=0; i<len; i++){
            if(i<=most){
                most = Math.max(most, i+nums[i]);
                if(most >= len-1) return true;
            }
        }
        return false;
    }
}
// @lc code=end

