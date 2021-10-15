/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution
{
    public double myPow(double x, int n)
    {
        // base case
        if (n <= 0)
        {
            return 1.0 / this.negativePow(x, -n);
        }
        else
        {
            return this.negativePow(x, n);
        }
    }

    // 正数的幂次方
    private double negativePow(double x, int n)
    {
        // base case
        if (n == 0)
        {
            return 1.0;
        }
        double tmpRes = this.negativePow(x, n / 2);
        return n % 2 == 0 ? tmpRes * tmpRes : tmpRes * tmpRes * x;
    }
}
// @lc code=end
