/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution
{
    public int mySqrt(int x)
    {
        // bs
        // [0...x]
        int l = 0, r = x;
        int res = 0;
        while (l <= r)
        {
            int mid = l + ((r - l) >>> 1);
            // 防止溢出
            long muti = (long) mid * mid;
            if (muti == x)
            {
                return mid;
            }
            else if (muti > x)
            {
                // 肯定在左边
                r = mid - 1;
            }
            else
            {
                // 可能在右边
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}
// @lc code=end
