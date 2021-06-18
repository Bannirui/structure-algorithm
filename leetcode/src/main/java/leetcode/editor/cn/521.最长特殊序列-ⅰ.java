/*
 * @Author: dingrui
 * @Date: 2021-06-18 10:17:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-18 11:06:49
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=521 lang=java
 *
 * [521] 最长特殊序列 Ⅰ
 */

// @lc code=start
class Solution {
    public int findLUSlength(String a, String b) {
        /**
         * ab长度相同 内容相同     -> -1
         * ab长度相同 内容不同     -> a或b的长度
         * ab长度不同 内容肯定不同  -> ab两者的最大长度
         * 
         * 
         */
        if (a.equals(b)) {
            // ab内容相同
            return -1;
        } else {
            // ab内容不同 长度最大的
            return Math.max(a.length(), b.length());
        }
    }
}
// @lc code=end
