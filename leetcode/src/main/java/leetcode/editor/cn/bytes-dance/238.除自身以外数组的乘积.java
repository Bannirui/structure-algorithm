/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=0;
        if(nums==null || (len=nums.length)==0) throw new RuntimeException("err");
        int[] pre = new int[len];
        pre[0]=1;
        int[] post = new int[len];
        post[len-1]=1;
        for(int i=1; i<len; i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        for(int i=len-2;i>=0;i--){
            post[i]=post[i+1]*nums[i+1];
        }
        int[] ret = new int[len];
        for(int i=0; i<len; i++) ret[i]=pre[i]*post[i];
        return ret;
    }
}
// @lc code=end

