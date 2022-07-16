/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        int ret=0;

        int end=0;
        int max=0;
        for(int i=0;i<len-1;i++){
            max=Math.max(max, i+nums[i]);
            if(i==end){
                end=max;
                ret++;
            }
        }
        return ret;
    }
}
// @lc code=end

