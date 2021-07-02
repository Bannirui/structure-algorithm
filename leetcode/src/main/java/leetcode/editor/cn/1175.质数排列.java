import java.util.function.BiPredicate;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/*
 * @Author: dingrui
 * @Date: 2021-07-01 17:42:29
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-02 19:38:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
    public int numPrimeArrangements(int n) {
        if (n <= 2) {
            return 1;
        }
        int primeCount = fun(n);
        long res = 1L;
        // 质数
        for (int i = 1; i <= primeCount; i++) {
            res = (res * i) % (1000000000 + 7);
        }
        // 合数
        for (int i = 1; i <= (n - primeCount); i++) {
            res = (res * i) % (1000000000 + 7);
        }
        return (int) res;
    }

    private int fun(int n) {
        // n++;
        int count = 0;
        boolean[] bool = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!bool[i]) {
                // 质数
                count++;
                for (int j = 2; (j * i) <= n; j++) {
                    // 合数
                    bool[j * i] = true;
                }
            }
        }
        return count;
    }

}
// @lc code=end
