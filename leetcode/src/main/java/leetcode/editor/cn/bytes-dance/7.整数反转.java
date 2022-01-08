/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int ret=0;
        while(x!=0){
            if(ret<Integer.MIN_VALUE/10 || ret>Integer.MAX_VALUE/10) return 0;
            int left = x%10;
            x/=10;
            ret=ret*10+left;
        }
        return ret;
    }
}
// @lc code=end

