/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int ret=0;
        int s = x^y;
        while(s!=0){
            ret+=s&1;
            s>>=1;
        }
        return ret;
    }
}
// @lc code=end

