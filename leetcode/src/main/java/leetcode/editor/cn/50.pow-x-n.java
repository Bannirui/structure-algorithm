import java.io.PipedWriter;

/*
 * @Author: dingrui
 * @Date: 2021-07-20 18:42:26
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-20 22:25:28
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0.0;
        }
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    // x^n n正数
    private double pow(double x, int n) {
        // base case
        if (n == 0) {
            return 1.0;
        }
        double tmp = pow(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : x * tmp * tmp;
    }
}
// @lc code=end
