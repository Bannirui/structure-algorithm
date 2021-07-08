/*
 * @Author: dingrui
 * @Date: 2021-07-08 20:34:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 20:44:46
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=5817 lang=java
 *
 * [5817] 判断字符串是否可分解为值均等的子串
 */

// @lc code=start
class Solution {
    public boolean isDecomposable(String s) {
        // 数字出现的次数
        int[] numCount = new int[10];
        for (int i = 0; i < s.length(); i++) {
            numCount[s.charAt(i) - '0']++;
        }
        // 出现的次数 有且只有一个1个2 其余都是3
        boolean findTwo = false;
        for (int i = 0; i < 10; i++) {
            int count = numCount[i];
            if (findTwo) {
                if ((count - 2) % 3 == 0) {
                    return false;
                }
                if (count % 3 != 0) {
                    return false;
                }
            } else {
                if ((count - 2) % 3 == 0) {
                    findTwo = true;
                } else if (count % 3 != 0) {
                    return false;
                }
            }
        }
        return findTwo;
    }
}
// @lc code=end
