/*
 * @Author: dingrui
 * @Date: 2021-07-16 13:03:41
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-16 17:39:17
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new RuntimeException();
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        } else if (divisor == Integer.MIN_VALUE) {
            return 0;
        } else if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int res = this.div(this.add(dividend, 1), divisor);
            return this.add(res, this.div(this.minus(dividend, this.multi(res, divisor)), divisor));
        } else {
            return this.div(dividend, divisor);
        }
    }

    // 加法
    private int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    // 取负数
    private int negNum(int n) {
        return add(~n, 1);
    }

    // 减法
    private int minus(int a, int b) {
        return add(a, this.negNum(b));
    }

    // 乘法
    private int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = this.add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    // 判断是否是负数
    private boolean isNeg(int n) {
        return n < 0;
    }

    // 除法
    private int div(int a, int b) {
        int x = this.isNeg(a) ? this.negNum(a) : a;
        int y = this.isNeg(b) ? this.negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = this.minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = this.minus(x, y << i);
            }
        }
        return (this.isNeg(a) ^ this.isNeg(b)) ? this.negNum(res) : res;
    }
}
// @lc code=end
