/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {

    // 字符串
    private String src;
    // 遍历到字符串中的脚标
    private int idx;

    public String decodeString(String s) {
        this.src=s;
        this.idx=0;
        return this.getStr();
    }

    private String getStr(){
        // base case
        if(idx==this.src.length()||this.src.charAt(idx)==']'){
            return "";
        }
        // 当前处理的字符
        char curChar = this.src.charAt(idx);
        // 重复的次数
        int repeatCnt=1;
        // 结果字符串
        String res="";
        if(Character.isDigit(curChar)){
            // 当前处理的是数字
            // 获取连续的数字
            repeatCnt = this.getDigit();
            // 跳过[
            this.idx++;
            // 获取...]之间的字符串
            String str = this.getStr();
            // 跳过]
            this.idx++;
            while(repeatCnt>0){
                res+=str;
                repeatCnt--;
            }
        }else if(Character.isLetter(curChar)){
            // 当前处理的是字母
            res=String.valueOf(this.src.charAt(this.idx));
            this.idx++;
        }
        return res+this.getStr();
    }

    private int getDigit(){
        int ret = 0;
        while (this.idx < this.src.length() && Character.isDigit(this.src.charAt(this.idx))) {
            ret = ret * 10 + src.charAt(this.idx++) - '0';
        }
        return ret;
    }
}
// @lc code=end

