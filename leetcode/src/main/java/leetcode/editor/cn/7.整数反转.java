/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        // base case
        if(x==0){
            return 0;
        }
        int res=0;
        while(x!=0){
            // 取模找末尾
            int last = x%10;
            if(res<Integer.MIN_VALUE/10||res>Integer.MAX_VALUE/10){
                return 0;
            }
            // 新的数 溢出检查
            res = res*10+last;
            x/=10;
        }
        return res;
    }
}
// @lc code=end

