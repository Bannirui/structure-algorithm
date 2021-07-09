/*
 * @Author: dingrui
 * @Date: 2021-07-09 15:15:40
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 15:32:45
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1550 lang=java
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // base case
        if (arr.length < 3) {
            return false;
        }
        // 窗口
        boolean[] window = new boolean[3];
        for (int i = 0; i < arr.length - 2;) {
            window[0] = this.isOdd(arr[i]);
            window[1] = this.isOdd(arr[i + 1]);
            window[2] = this.isOdd(arr[i + 2]);
            if (window[0] && window[1] && window[2]) {
                return true;
            } else {
                // 至少有一个是偶数
                if (!window[2]) {
                    // 第三个数是偶数
                    i += 3;
                } else {
                    // 第三个数是奇数 前两个至少一个偶数
                    if (!window[1]) {
                        // 第2个数是偶数
                        i += 2;
                    } else {
                        // 第一个数必是偶数
                        i++;
                    }
                }
            }
        }
        return false;
    }

    // true: num为奇数
    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
// @lc code=end
