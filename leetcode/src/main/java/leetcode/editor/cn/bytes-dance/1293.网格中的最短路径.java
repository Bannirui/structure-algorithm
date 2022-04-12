/*
 * @lc app=leetcode.cn id=1293 lang=java
 *
 * [1293] 网格中的最短路径
 */

// @lc code=start
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int ROWS=0;
        int COLS=0;
        if(grid==null ||(ROWS=grid.length)==0 || (COLS=grid[0].length)==0 || k<0) throw new IllegalArgumentException();
        if(ROWS==1 && COLS==1) return 0;

        int[][] visited = new int[ROWS][COLS];
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++) visited[i][j]=-1;
        }

        int[][] dires=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        int[] start=new int[]{0,0,k};
        visited[0][0]=k;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int ret=0;
        while(!q.isEmpty()){
            ret++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int pX=cur[0];
                int pY=cur[1];
                int pK=cur[2];
                for(int[] dire:dires){
                    int nX=pX+dire[0];
                    int nY=pY+dire[1];
                    // valid
                    if(nX<0||nX>=ROWS||nY<0||nY>=COLS) continue;
                    if(nX==ROWS-1 && nY==COLS-1) return ret;
                    int nK=grid[nX][nY]==1?pK-1:pK;
                    if(nK<0) continue;
                    if(visited[nX][nY]==-1 || (visited[nX][nY]!=-1&&nK>visited[nX][nY])){
                        q.offer(new int[]{nX,nY,nK});
                        visited[nX][nY]=nK;
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end

