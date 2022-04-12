/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        // bfs
        int ROWS=0, COLS=0;
        if(grid==null || (ROWS=grid.length)==0 || (COLS=grid[0].length)==0) throw new IllegalArgumentException();
        // find all 2 and 1
        int cntFor1 = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                else if(grid[i][j]==1) cntFor1++;
            }
        }
        // directions
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int ret=0;
        while(cntFor1>0 && !q.isEmpty()){
            ret++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] pos = q.poll();
                int x=pos[0];
                int y=pos[1];
                for(int[] direction:directions){
                    int nX=x+direction[0];
                    int nY=y+direction[1];
                    if(nX<0 || nX>=ROWS || nY<0 || nY>=COLS) continue;
                    if(grid[nX][nY]==0 || grid[nX][nY]==2) continue;
                    // got it not visited 1
                    grid[nX][nY]=2;
                    cntFor1--;
                    q.offer(new int[]{nX,nY});
                }
            }
        }
        return cntFor1>0?-1:ret;
    }
}
// @lc code=end

