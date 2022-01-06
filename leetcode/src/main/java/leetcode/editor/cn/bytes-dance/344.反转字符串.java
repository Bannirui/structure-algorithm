/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int len=0;
        if(s==null||(len=s.length)==0) throw new RuntimeException("err");
        int l=0, r=len-1;
        while(l<r){
            char tmpCh = s[l];
            s[l]=s[r];
            s[r]=tmpCh; 
            l++;
            r--;    
        }
    }
}
// @lc code=end

