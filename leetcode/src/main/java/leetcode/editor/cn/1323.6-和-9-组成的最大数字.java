/*
 * @Author: dingrui
 * @Date: 2021-07-06 17:10:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-06 17:18:06
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number(int num) {
        // 从高位开始 6->9
        String numStr = String.valueOf(num);
        char[] numArr = numStr.toCharArray();
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == '6') {
                numArr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(numArr));
    }
}
// @lc code=end
