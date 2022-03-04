/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int len=0;
        if(s==null || (len=s.length())==0) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<len){
            while(i<len && s.charAt(i)==' '){
                i++;
                sb.append(' ');
            }
            // first ch
            int start=i;
            while(i<len && s.charAt(i)!=' ') i++;
            for(int cur=i-1;cur>=start;cur--) sb.append(s.charAt(cur));
        }
        return sb.toString();
    }
}
// @lc code=end

