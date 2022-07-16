/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {

    int n;
    int k;
    int[] cnt;
    boolean[] used;

    public String getPermutation(int n, int k) {
        this.n=n;
        this.k=k;
        this.cnt=this.calCnt(n);
        this.used=new boolean[n+1];

        StringBuilder sb = new StringBuilder();
        this.dfs(0, sb);
        return sb.toString();
    }

    private void dfs(int idx, StringBuilder path){
        if(idx==this.n) return;
        int cnt = this.cnt[this.n-1-idx];
        for(int i=1;i<=n;i++){
            if(this.used[i]) continue;
            if(k>cnt){
                k-=cnt;
                continue;
            }
            path.append(i);
            used[i]=true;
            this.dfs(idx+1,path);
            return;
        }
    }

    private int[] calCnt(int n){
        int[] ret = new int[n+1];
        ret[0]=1;
        for(int i=1;i<=n;i++){
            ret[i]=ret[i-1]*i;
        }
        return ret;
    }
}
// @lc code=end

