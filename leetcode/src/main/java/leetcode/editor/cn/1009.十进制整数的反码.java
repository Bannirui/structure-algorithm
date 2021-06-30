/*
 * @Author: dingrui
 * @Date: 2021-06-30 14:45:17
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 15:02:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 十进制整数的反码
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        // 找到最高位1 5=101->最高位=3-> 1再左移动3->1000->再减去1
        int highIndex = 0;
        int tmp = n;
        while (tmp != 0) {
            tmp >>>= 1;
            highIndex++;
        }
        // 高位跟n一样全是1
        int help = (1 << highIndex) - 1;
        return help - n;
    }
}
// @lc code=end
