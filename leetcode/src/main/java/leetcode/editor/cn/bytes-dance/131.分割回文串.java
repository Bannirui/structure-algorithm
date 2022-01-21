/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {

    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        int len=0;
        if(s==null || (len=s.length())==0) return ret;
        // generate dp table
        this.dp = new boolean[len][len];
        for(int i=0; i<len; i++) Arrays.fill(dp[i], true);
        for(int i=len-1; i>=0; i--){
            for(int j=i+1; j<len; j++){
                dp[i][j]=dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
            }
        }
        // trace back
        this.traceBack(s, 0, new ArrayList<String>(), ret);
        return ret;
    }


    // s[...idx-1] is ok and the cur is idx
    private void traceBack(String s, int idx, List<String> path, List<List<String>> ret){
        if(idx==s.length()){
            ret.add(new ArrayList<>(path));
            return;
        }
        // substring
        for(int j=idx; j<s.length(); j++){
            if(this.dp[idx][j]){
                List<String> pathCpy = new ArrayList<>(path);
                pathCpy.add(s.substring(idx, j+1));
                this.traceBack(s, j+1, pathCpy, ret);
            }
        }
    }
}
// @lc code=end

