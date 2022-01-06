/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new RuntimeException("err");
        return this.isPalindrome(s, 0, len-1);
    }


    private boolean isPalindrome(String s, int start, int end){
        if(start<0 || start>=s.length() || end<0 || end>=s.length()) throw new RuntimeException("err");
        if(start>=end) return true;
        char sCh = s.charAt(start);
        char eCh = s.charAt(end);
        // start char
        if(Character.isDigit(sCh) || Character.isLetter(sCh)){
            if(Character.isDigit(eCh) || Character.isLetter(eCh)){
                if(Character.isLetter(sCh)&&Character.isLetter(eCh)){
                    // both are letter
                    if(((sCh-'a')==(eCh-'a'))||((sCh-'a')==(eCh-'A'))||((sCh-'A')==(eCh-'A'))||((sCh-'A')==(eCh-'a'))){
                        // match
                        return this.isPalindrome(s, start+1, end-1);
                    }else{
                        // mismatch
                        return false;
                    }
                }else if(Character.isDigit(sCh)&&Character.isDigit(eCh)){
                    if(sCh==eCh){
                        return this.isPalindrome(s, start+1, end-1);
                    }else{
                        return false;
                    }
                }else{
                    // mismatch
                    return false;
                }
            }else{
                // ignore
                return this.isPalindrome(s, start, end-1);
            }
        }else{
            // ignore
            return this.isPalindrome(s, start+1, end);
        }
    }
}
// @lc code=end

