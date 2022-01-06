/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        if(columnNumber <= 0) throw new RuntimeException("err");
        StringBuilder ret = new StringBuilder();
        while(columnNumber>0){
            int num = (columnNumber-1)%26+1;
            ret.append((char)(num-1+'A'));
            columnNumber=(columnNumber-num)/26;
        }
        return ret.reverse().toString();
    }
}
// @lc code=end

