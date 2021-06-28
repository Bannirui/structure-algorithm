import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-06-28 15:12:54
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 15:40:29
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=762 lang=java
 *
 * [762] 二进制表示中质数个计算置位
 */

// @lc code=start
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            // i对应二进制中的1的数量
            // int counts = this.bitsCount(i);
            int counts = Integer.bitCount(i);
            Boolean prime = this.isPrime(counts);
            if (prime) {
                // i二进制中1的数量是质数
                res++;
            }
        }
        return res;
    }

    private int bitsCount(int num) {
        // int 32位每个位置都比较一下
        int res = 0;
        for (int i = 0; i <= 32; i++) {
            i >>>= i;
            if ((i & 1) == 1) {
                res++;
            }
        }
        return res;
    }

    // num是否是质数
    private boolean isPrime(int num) {
        if (num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13 || num == 17 || num == 19
                || num == 23 || num == 29 || num == 31) {
            return true;
        }
        return false;
    }
}
// @lc code=end
