/*
 * @Author: dingrui
 * @Date: 2021-06-25 15:51:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-25 16:17:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        // 从左到右和从右到左的距离比较
        int len = s.length();
        int[] res = new int[len];
        // left->right 还没找到目标c的时候最大化结果差值 防止溢出
        int leftBase = Integer.MIN_VALUE >> 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                leftBase = i;
            }
            res[i] = i - leftBase;
        }
        // right->left 还没找到目标c的时候最大化结果差值 防止溢出
        int rightBase = Integer.MAX_VALUE >> 1;
        for (int j = len - 1; j >= 0; j--) {
            if (s.charAt(j) == c) {
                rightBase = j;
            }
            res[j] = Math.min(res[j], (rightBase - j));
        }
        return res;
    }
}
// @lc code=end
