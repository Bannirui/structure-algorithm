/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        for(int i=0;i<=n;i++)
            ret[i]=this.countBit(i);
        return ret;
    }

    private int countBit(int num){
        int ret=0;
        while(num>0){
            num&=(num-1);
            ret++;
        }
        return ret;
    }
}
// @lc code=end

