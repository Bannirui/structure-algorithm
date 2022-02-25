/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {


    public int findCircleNum(int[][] isConnected) {
        int len=0;
        if(isConnected==null || (len=isConnected.length)==0 || isConnected.length!=isConnected[0].length) throw new IllegalArgumentException();
        int cnt=0;
        boolean[] visit = new boolean[len];
        for(int i=0;i<len;i++){
            if(!visit[i]){
                this.dfs(isConnected, visit, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] isConnected, boolean[] visit, int i){
        for(int j=0;j<visit.length;j++){
            if(!visit[j] && isConnected[i][j]==1){
                visit[j]=true;
                this.dfs(isConnected, visit, j);
            }
        }
    }
}
// @lc code=end

