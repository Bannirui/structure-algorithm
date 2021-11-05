/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        // [0...n]
        for(int i=0;i<=n;i++){
            res[i]=this.bitCnt(i);
        }
        return res;
    }

    // n的二进制表达中1的数量
    private int bitCnt(int n){
        int cnt=0;
        while(n!=0){
            if((n&1)==1)
            cnt++;
            n>>>=1;
        }
        return cnt;
    }
}
// @lc code=end

