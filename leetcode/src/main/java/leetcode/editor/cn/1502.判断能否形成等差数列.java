import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 14:53:25
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 15:00:56
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1502 lang=java
 *
 * [1502] 判断能否形成等差数列
 */

// @lc code=start
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // 等差数列
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] << 1) != (arr[i - 1] + arr[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
