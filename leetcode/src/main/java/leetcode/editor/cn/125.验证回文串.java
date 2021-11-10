/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        // 数字 大小写
        while(l<r){
            while(l<r &&!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            // 一个数字一个字母
            if(Character.isDigit(s.charAt(l)) ^ Character.isDigit(s.charAt(r))){
                return false;
            }
            // 都是数字或都是字母
            if(Character.isDigit(s.charAt(l)) && Character.isDigit(s.charAt(r))){
                // 数字
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
            }else{
                // 字母
                char lChar = s.charAt(l);
                char rChar = s.charAt(r);
                if(lChar!=rChar && ((lChar-'A')!=(rChar-'a')) && ((lChar-'a')!=(rChar-'A'))){
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end

