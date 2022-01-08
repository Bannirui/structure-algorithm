/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int rows=0;
        int cols=0;
        if(matrix==null||(rows=matrix.length)==0||(cols=matrix[0].length)==0 || rows!=cols) throw new RuntimeException("err");
        int src=0, dest=rows-1;
        while(src<=dest){
            this.rotate(matrix, src++, dest--);
        }
    }

    private void rotate(int[][] matrix, int src, int dest){
        if(src>=dest) return;
        for(int i=0; i<dest-src; i++){
            // 左(下-上)
            int tmp=matrix[dest-i][src];
            // 下(右-左)>左(下-上)
            matrix[dest-i][src]=matrix[dest][dest-i];
            // 右(上-下)->下(右-左)
            matrix[dest][dest-i]=matrix[src+i][dest];
            // 上(左-右)->右(上-下)
            matrix[src+i][dest]=matrix[src][src+i];
            // 左->上(左-右)
            matrix[src][src+i]=tmp;
        }
    }
}
// @lc code=end

