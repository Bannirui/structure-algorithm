/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        if(n<=0) throw new IllegalArgumentException();
        if(n==1) return 0;
        if(this.isEvenNum(n)) return 1+this.integerReplacement(n/2);
        else return 1+
        1+Math.min(this.integerReplacement(n/2), this.integerReplacement(n/2+1));
    }

    private boolean isEvenNum(int n){
        return n%2==0;
    }
}
// @lc code=end

