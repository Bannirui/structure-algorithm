/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int len=0;
        if(columnTitle==null || (len=columnTitle.length())==0) throw new RuntimeException("err");
        int ret=0;
        for(int i=0; i<len; i++) ret = ret*26+(columnTitle.charAt(i)-'A')+1;
        return ret;
    }
}
// @lc code=end

