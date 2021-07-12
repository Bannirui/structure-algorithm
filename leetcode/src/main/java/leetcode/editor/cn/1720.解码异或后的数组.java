/*
 * @Author: dingrui
 * @Date: 2021-07-12 13:37:18
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 13:50:42
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1720 lang=java
 *
 * [1720] 解码异或后的数组
 */

// @lc code=start
class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
// @lc code=end
