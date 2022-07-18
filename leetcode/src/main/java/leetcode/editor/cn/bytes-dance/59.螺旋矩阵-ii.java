/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {

    int v;

    public int[][] generateMatrix(int n) {
        if(n<1) throw new IllegalArgumentException();
        int[][] ret = new int[n][n];
        int start=0, end=n-1;
        this.v=1;
        while(start<end){
            this.gen(ret, start, start, end, end);
            start++;
            end--;
        }
        if(start==end) ret[start][end]=this.v;
        return ret;
    }

    private void gen(int[][] m, int fromX, int fromY, int toX, int toY){
        for(int y=fromY;y<toY;y++) m[fromX][y]=this.v++;
        for(int x=fromX;x<toX;x++) m[x][toY]=this.v++;
        for(int y=toY;y>fromY;y--) m[toX][y]=this.v++;
        for(int x=toX;x>fromX;x--) m[x][fromY]=this.v++;
    }
}
// @lc code=end

