/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ret = new StringBuilder();
        while(a>0 || b>0){
            boolean writeA=false;

            int len=ret.length();
            if(len>=2 && ret.charAt(len-1)==ret.charAt(len-2)){
                if(ret.charAt(len-1)=='b') writeA=true;
            }else{
                if(a>=b) writeA=true;
            }

            if(writeA){
                a--;
                ret.append('a');
            }else{
                b--;
                ret.append('b');
            }
        }
        return ret.toString();
    }
}
// @lc code=end

