/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // 0^N=N N^N=0
        int res=0;
        for(int num: nums){
            res^=num;
        }
        return res;
    }
}
// @lc code=end

