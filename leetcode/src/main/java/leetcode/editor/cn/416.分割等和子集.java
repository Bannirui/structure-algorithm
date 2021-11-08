/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums==null || nums.length<2){
            return false;
        }
        int sum=0;
        int maxNum=Integer.MIN_VALUE;
        for(int num: nums){
            sum+=num;
            maxNum = Math.max(maxNum, num);
        }
        // 和为奇数 无法分割为2个数组
        if(sum%2!=0){
            return false;
        }
        // 和为偶数 数字大小无法分割为2个和相等的数组
        int target = sum/2;
        if(maxNum>target){
            // 分割成的2个数组 一个和小于target 一个和大于target
            return false;
        }
        // 问题转换 从nums[0...n]中找和为target
        // dp[i][j]在nums中以i结尾[0...i]中可以找到和为j的元素
        boolean[][] dp = new boolean[nums.length][target+1];
        // base case
        // 和为0
        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        // 第一个元素
        dp[0][nums[0]]=true;
        for(int i=1;i<nums.length;i++){
            int curNum = nums[i];
            for(int j=1;j<=target;j++){
                if(j>=curNum){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-curNum];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }

}
// @lc code=end

