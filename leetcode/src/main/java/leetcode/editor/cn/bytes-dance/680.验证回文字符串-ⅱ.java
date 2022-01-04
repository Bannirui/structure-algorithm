/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int len = 0;
        if(s==null || (len=s.length())==0) return true;
        int l=0,r=len-1; // tow pointer
        while(l<=r){
            if(s.charAt(l)==s.charAt(r)){
                // do not delete any char
                l++;
                r--;
            }else{
                // delete left pointer or right pointer
                return this.validPalindrome(s, l+1, r) || this.validPalindrome(s, l, r-1);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right){
        for(int l=left, r=right; l<=r; l++,r--){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

