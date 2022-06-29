/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int lenS=0, lenP=0;
        if(haystack==null || (lenS=haystack.length())==0) return -1;
        if(needle==null || (lenP=needle.length())==0) return 0;
        int[] next = this.getNext(needle);
        if(next==null) return -1;
        for(int i=0,j=0;i<lenS;i++){
            while(j>0 && needle.charAt(j) != haystack.charAt(i)) j=next[j-1];
            if(haystack.charAt(i) == needle.charAt(j)) j++;
            if(j==lenP) return i-j+1;
        }
        return -1;
    }

    // next数组
    private int[] getNext(String pat){
        int len=0;
        if(pat==null || (len=pat.length())==0) return null;
        int[] ret = new int[len];
        // base case
        ret[0]=0;
        for(int i=1,j=0;i<len;i++){
            while(j>0 && pat.charAt(i) != pat.charAt(j)) j=ret[j-1];
            if(pat.charAt(i) == pat.charAt(j)) j++;
            ret[i]=j;
        }
        return ret;
    }
}
// @lc code=end
