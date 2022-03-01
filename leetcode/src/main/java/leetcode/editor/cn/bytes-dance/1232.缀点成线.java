/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len=0;
        if(coordinates==null || (len=coordinates.length)==0) throw new IllegalArgumentException();
        int[] origin = coordinates[0];
        int originX = origin[0];
        int originY = origin[1];
        for(int i=0;i<len;i++){
            coordinates[i][0]-=originX;
            coordinates[i][1]-=originY;
        }
        int A=coordinates[1][1];
        int B=-coordinates[1][0];
        for(int i=2;i<len;i++){
            int x=coordinates[i][0];
            int y=coordinates[i][1];
            if(A*x+B*y!=0) return false;
        }
        return true;
    }
}
// @lc code=end

