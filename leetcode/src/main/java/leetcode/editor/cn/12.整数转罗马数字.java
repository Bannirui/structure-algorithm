import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-13 14:23:14
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-14 10:16:06
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        // 常规映射
        int[] no = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] str = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < no.length; i++) {
            while (no[i] <= num) {
                sb.append(str[i]);
                num -= no[i];
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
// @lc code=end
