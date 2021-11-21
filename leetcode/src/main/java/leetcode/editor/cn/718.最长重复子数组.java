/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        // base case 最后一行 最后一列都是0
        int max=0;
        // dp[i][j] [i...][j...] 右下角->左上角
        for(int i=nums1.length-1;i>=0;i--){
            for(int j=nums2.length-1;j>=0;j--){
                dp[i][j]=nums1[i]==nums2[j]?dp[i+1][j+1]+1:0;
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
// @lc code=end

