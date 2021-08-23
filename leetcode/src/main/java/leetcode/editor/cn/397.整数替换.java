import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingRui
 * @Date: 2021-08-23 22:37:16
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-23 22:58:22
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {

    public int integerReplacement(int n) {
        return (int) this.dfs((long) n);
    }

    public long dfs(long num) {
        // base case
        if (num == 1) {
            return 0;
        }
        if (num % 2 == 0) {
            return 1 + this.dfs(num / 2);
        } else {
            return 1 + Math.min(this.dfs(num - 1), this.dfs(num + 1));
        }
    }
}
// @lc code=end
