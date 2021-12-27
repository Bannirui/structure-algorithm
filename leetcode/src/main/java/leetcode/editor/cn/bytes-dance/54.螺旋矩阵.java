/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        // start [x, y]
        int sX=0;
        int sY=0;
        // end [x, y]
        int eX=matrix.length-1;
        int eY=matrix[0].length-1;
        while(sX<=eX&&sY<=eY){
            List<Integer> roundRet = this.byRound(matrix, sX, sY, eX, eY);
            ret.addAll(roundRet);
            sX++;
            sY++;
            eX--;
            eY--;
        }
        return ret;
    }

    // matrix [sX, sY]->[eX, eY]
    private List<Integer> byRound(int[][] matrix, int sX, int sY, int eX, int eY){
        List<Integer> ret = new ArrayList<>();
        if(sX==eX){
            // only one column
            for(int i=sY;i<=eY;i++){
                ret.add(matrix[sX][i]);
            }
        }else if(sY==eY){
            // only one row
            for(int i=sX;i<=eX;i++){
                ret.add(matrix[i][sY]);
            }
        }else{
            int curX=sX;
            int curY=sY;
            while(curY!=eY){
                // fist row
                ret.add(matrix[sX][curY]);
                curY++;
            }
            while(curX!=eX){
                // last col
                ret.add(matrix[curX][eY]);
                curX++;
            }
            while(curY!=sY){
                // last row
                ret.add(matrix[eX][curY]);
                curY--;
            }
            while(curX!=sX){
                // first col
                ret.add(matrix[curX][sY]);
                curX--;
            }
        }
        return ret;
    }
}
// @lc code=end

