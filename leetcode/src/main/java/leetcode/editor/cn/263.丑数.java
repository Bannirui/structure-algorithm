'/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int[] facs = new int[]{2,3,5};
        for(int fac: facs){
            while(n%fac==0){
                n/=fac;
            }
        }
        return n==1;
        
    }
}
// @lc code=end

