import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {

    public int countPrimes(int n) {
        // [0...n-1]
        boolean[] isPrime = new boolean[n];
        // 全部填充true 所有都是质数
        Arrays.fill(isPrime, true);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                // i是质数
                cnt++;
                // i*[2,3,4...]肯定不是质数 开始感染
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return cnt;
    }

    // 暴力解法
    private int force(int num) {
        int cnt = 0;
        for (int i = 2; i < num; i++) {
            cnt += this.isPrime(i) ? 1 : 0;
        }
        return cnt;
    }

    // 判断num是否是质数
    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
