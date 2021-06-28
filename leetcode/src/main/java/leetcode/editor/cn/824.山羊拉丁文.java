/*
 * @Author: dingrui
 * @Date: 2021-06-28 15:55:04
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 16:09:47
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
class Solution {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String newWord = convert(words[i], i);
            if (i == 0) {
                sb.append(newWord);
            } else {
                sb.append(" ");
                sb.append(newWord);
            }
        }
        return sb.toString();
    }

    private String convert(String word, int index) {
        String res = word;
        String letterWord = word.toLowerCase();
        char firChar = letterWord.charAt(0);
        if (firChar == 'a' || firChar == 'e' || firChar == 'i' || firChar == 'o' || firChar == 'u') {
            // 首字母 元音 a e i o u
            res += "ma";
        } else {
            // 首字母 辅音
            res = res.substring(1);
            res += word.charAt(0);
            res += "ma";
        }
        for (int i = 0; i <= index; i++) {
            res += "a";
        }
        return res;
    }
}
// @lc code=end
