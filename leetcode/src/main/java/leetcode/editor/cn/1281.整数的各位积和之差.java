/*
 * @Author: dingrui
 * @Date: 2021-07-05 10:23:48
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 10:26:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1281 lang=java
 *
 * [1281] 整数的各位积和之差
 */

// @lc code=start
class Solution {
    public int subtractProductAndSum(int n) {
        if (n == 0) {
            return 0;
        }
        // 乘积 和
        int product = 1, sum = 0;
        while (n != 0) {
            int mod = n % 10;
            product *= mod;
            sum += mod;
            n /= 10;
        }
        return product - sum;
    }
}
// @lc code=end
