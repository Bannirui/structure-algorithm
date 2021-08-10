/*
 * @Author: dingRui
 * @Date: 2021-08-10 15:36:26
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-10 18:23:06
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
    public int superPow(int a, int[] b) {
        // (a^(b))%c = (a(b%ol(c)+ol(c)))%c
        // 欧拉
        int olValue = this.ol(1337);
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum = (sum * 10 + b[i]) % olValue;
        }
        sum += olValue;
        return this.q((long) a, sum, 1337);
    }

    private int q(long a, int b, int mod) {
        long res = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                // 奇数
                res = res % mod * a % mod;
            }
            // 降幂
            a = a % mod * a % mod;
            b /= 2;
        }
        return (int) res;
    }

    /**
     * x的欧拉函数
     * @param x
     * @return
     */
    private int ol(int x) {
        int res = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                res = res - res / i;
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) {
            res = res - res / x;
        }
        return res;
    }
}
// @lc code=end
