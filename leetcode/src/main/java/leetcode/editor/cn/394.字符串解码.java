/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {

    // the index for string 
    private int idx;

    public String decodeString(String s) {
        this.idx=0;
        // 递归
        return this.decodeStr(s);
    }

    private String decodeStr(String s){
        // base case
        if(this.idx==s.length() || s.charAt(this.idx)==']'){
            return "";
        }
        String ret="";
        int cnt=0;
        char curChar=s.charAt(this.idx);
        if(Character.isDigit(curChar)){
            // digit
            while(this.idx<s.length()&&Character.isDigit(s.charAt(this.idx))){
                cnt=cnt*10+(s.charAt(this.idx)-'0');
                this.idx++;
            }
            // idx->[  and skip it
            this.idx++;  
            // [...]->str
            String str=this.decodeStr(s);
            // idx->] and skip it
            this.idx++;
            while(cnt>0){
                ret+=str;
                cnt--;
            }
        }else if(Character.isLetter(curChar)){
            // letter
            ret=String.valueOf(curChar);
            this.idx++;
        }else{
            // ignore
            this.idx++;
        }
        return ret+this.decodeStr(s); 
    }
}
// @lc code=end

