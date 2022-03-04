/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length==1) throw new IllegalArgumentException();
        if(nums.length==2) return nums;
        int ret=0;
        for(int num:nums) ret^=num;
        int bound=(ret==Integer.MIN_VALUE)?ret:ret&(-ret);
        int ret1=0;
        int ret2=0;
        for(int num:nums){
            if((num&bound)==0) ret1^=num;
            else ret2^=num;
        }
        return new int[]{ret1,ret2};
    }
}
// @lc code=end

