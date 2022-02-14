/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    public int maximumProduct(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new IllegalArgumentException();
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[len-1], nums[len-3]*nums[len-2]*nums[len-1]);
    }
}
// @lc code=end

