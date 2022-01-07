/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len=0;
        if(strs==null || (len=strs.length)==0) return "";
        String ret = strs[0];
        for(int i=1;i<len;i++){
            ret = this.longestCommonPrefix(ret, strs[i]);
            if(ret==null || ret.length()==0) break;
        }
        return ret;
    }

    private String longestCommonPrefix(String s1, String s2){
        int minLen=Math.min(s1.length(), s2.length());
        int prefixIdx=0;
        for(int i=0;i<minLen;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                prefixIdx++;
            }else{
                break;
            }
        }
        return s1.substring(0, prefixIdx); // [0...prefixIdx)
    }
}
// @lc code=end