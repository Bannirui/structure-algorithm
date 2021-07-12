/*
 * @Author: dingrui
 * @Date: 2021-07-12 22:26:32
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 22:32:09
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1880 lang=java
 *
 * [1880] 检查某单词是否等于两单词之和
 */

// @lc code=start
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return this.convert(firstWord) + this.convert(secondWord) == this.convert(targetWord);
    }

    private int convert(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res = res * 10 + (word.charAt(i) - 'a');
        }
        return res;
    }
}
// @lc code=end
