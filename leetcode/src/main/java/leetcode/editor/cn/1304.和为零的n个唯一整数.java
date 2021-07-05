import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 14:33:05
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 14:46:02
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的N个唯一整数
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            res[i] = i;
            sum += i;
        }
        res[n - 1] = -sum;
        return res;
    }
}
// @lc code=end
