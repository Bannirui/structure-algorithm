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
        int[] parent = new int[len];
        for(int i=0;i<len;i++) parent[i]=i;

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(isConnected[i][j]==1) this.union(parent, i,j);
            }
        }

        int cnt=0;
        for(int i=0;i<len;i++) if(parent[i]==i) cnt++;
        return cnt;
    }

    private void union(int[] parent, int i, int j){
        parent[parent[i]]=this.find(parent, j);
    }

    private int find(int[] parent, int i){
        if(parent[i]!=i) parent[i]=this.find(parent, parent[i]);
        return parent[i];
    }
}
// @lc code=end

