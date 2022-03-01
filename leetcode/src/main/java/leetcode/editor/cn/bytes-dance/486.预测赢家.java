/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return this.score(nums, 0, nums.length-1, 1)>=0;
    }

    // nums[start...end] 得分
    // first=1 先手
    // first=-1 后手
    private int score(int[] nums, int start, int end, int first){
        // base case
        if(start==end) return nums[start]*first;
        int scoreStart=nums[start]*first+this.score(nums,start+1,end,-first);
        int scoreEnd=nums[end]*first+this.score(nums,start,end-1,-first);
        return Math.max(scoreStart*first,scoreEnd*first)*first;
    }
}
// @lc code=end

