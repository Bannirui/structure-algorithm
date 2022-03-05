/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        int bits=1;
        int cnt=9;
        while(n>(long)bits*cnt){
            n-=(bits*cnt);
            bits++;
            cnt*=10;
        }
        int start=(int)Math.pow(10,bits-1);
        int idx=n-1;
        int num=start+idx/bits;
        int digits=idx%bits;
        return (num/(int)(Math.pow(10,bits-digits-1)))%10;
    }
}
// @lc code=end

