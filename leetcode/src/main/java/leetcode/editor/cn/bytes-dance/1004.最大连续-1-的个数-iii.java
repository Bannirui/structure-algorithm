/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len=0;
        if(nums==null || (len=nums.length)==0 || k<0) throw new IllegalArgumentException();
        int ret=0;
        // [winL...winR]中0的个数
        int cnt=0;
        int winL=0, winR=0;
        while(winR<len){
            if(nums[winR]==0) cnt++;
            while(cnt>k){
                if(nums[winL++]==0) cnt--;
            }
            ret=Math.max(ret, winR-winL+1);
            winR++;
        }
        return ret;
    }
}
// @lc code=end

