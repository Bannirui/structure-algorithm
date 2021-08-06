import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @Author: dingRui
 * @Date: 2021-08-05 21:48:08
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-06 09:54:17
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // dp[i] 第i个丑数一定来自dp[0...i-1]跟primes数组中元素的乘积最小值
        // 维护一个指针数组 动态更新维护下一次primes中元素该跟dp中哪个元素相乘
        int[] dp = new int[n];
        // base case
        dp[0] = 1;
        // 数组 初始时都是0 意味着primes中元素都跟dp[0]相乘比较出最小值
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            // 填dp[i]
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[index[j]]);
            }
            dp[i] = min;
            // 更新index数组 存在primes中多个因子跟dp[0...]中的元素乘积相同的 都更新
            for (int k = 0; k < primes.length; k++) {
                if (min == primes[k] * dp[index[k]]) {
                    index[k]++;
                }
            }
        }
        return dp[n - 1];
    }
}
// @lc code=end
