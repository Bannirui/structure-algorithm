/*
 * @Author: dingrui
 * @Date: 2021-07-12 18:13:15
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 18:14:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1832 lang=java
 *
 * [1832] 判断句子是否为全字母句
 */

// @lc code=start
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letterCount = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            letterCount[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
