/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int ret=0;
        int num=x;
        while(num!=0){
            ret=ret*10+num%10;
            num/=10;
        }
        return ret==x;
    }
}
// @lc code=end

