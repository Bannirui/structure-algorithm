/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int ret = 0;
        for(int i=1; i<=n; i*=10){
            ret+=(n/(i*10))*i + Math.min(i, Math.max(0,n%(i*10)-i+1));
        }
        return ret;
    }
}
// @lc code=end

