/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        // base case
        if(x==0) return 0;
        return n>=0? this.myPowPositive(x,n):1.0/this.myPowPositive(x,-n);
    }

    private double myPowPositive(double x, int n){
        if(n==0) return 1.0;
        double t=this.myPowPositive(x, n/2);
        return n%2==0?t*t:x*t*t;
    }
}
// @lc code=end

