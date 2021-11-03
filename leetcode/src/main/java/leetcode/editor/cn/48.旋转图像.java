/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // [0...n-1]
        int start=0;
        int end=n-1;
        while(start<end){
            this.rotateRound(matrix, start, end);
            start++;
            end--;
        }
    }

    // 正方形 旋转一圈
    private void rotateRound(int[][] m, int s, int e){
        // 起始[s, s]
        // 终止[e, e]
        for(int i=0;i<e-s;i++){
            // 记录左(下->上)
            int tmp = m[e-i][s];
            // 左=下
            m[e-i][s]=m[e][e-i];
            // 下=右
            m[e][e-i]=m[s+i][e];
            // 右=上
            m[s+i][e]=m[s][s+i];
            // 上=临时
            m[s][s+i]=tmp;
        }
    }
}
// @lc code=end

