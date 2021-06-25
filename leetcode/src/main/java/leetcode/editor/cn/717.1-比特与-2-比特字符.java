/*
 * @Author: dingrui
 * @Date: 2021-06-23 13:07:42
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-26 00:25:03
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1比特与2比特字符
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            int cur = bits[i];
            i += (cur == 1 ? 2 : 1);
        }
        // 最后看index落在哪儿
        return i == (bits.length - 1);
    }
}
// @lc code=end
