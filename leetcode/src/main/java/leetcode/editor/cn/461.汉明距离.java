/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        // int型 最多32位不同 遍历
        int cnt=0;
        for(int i=0;i<32;i++){
            int resX=x&1;
            int resY=y&1;
            if((resX==1)^(resY==1)){
                cnt++;
            }
            x>>>=1;
            y>>>=1;
        }
        return cnt;
    }
}
// @lc code=end

