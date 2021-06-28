/*
 * @Author: dingrui
 * @Date: 2021-06-28 14:44:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 15:11:41
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短补全词
 */

// @lc code=start
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 牌照中的所有字母和对应的次数
        int[] licensePlateCharCount = new int[26];
        for (char c : licensePlate.toCharArray()) {
            // 小写
            if (c - 'a' >= 0 && 'z' - c >= 0) {
                licensePlateCharCount[c - 'a'] = licensePlateCharCount[c - 'a'] + 1;
            }
            // 大写
            if (c - 'A' >= 0 && 'Z' - c >= 0) {
                licensePlateCharCount[c - 'A'] = licensePlateCharCount[c - 'A'] + 1;
            }
        }
        String res = "";
        for (String word : words) {
            // 找最短的单词
            if (res.length() == 0 || (word.length() < res.length())) {
                // 当前单词中是否包含了所有牌照中的字母
                int[] wordCharCount = new int[26];
                for (char c : word.toCharArray()) {
                    // 小写
                    if (c - 'a' >= 0 && 'z' - c >= 0) {
                        wordCharCount[c - 'a'] = wordCharCount[c - 'a'] + 1;
                    }
                    // 大写
                    if (c - 'A' >= 0 && 'Z' - c >= 0) {
                        wordCharCount[c - 'A'] = wordCharCount[c - 'A'] + 1;
                    }
                }
                // 标志位 当前单词是否包含了牌照中所有的字母
                boolean containFlag = true;
                for (int i = 0; i < 26; i++) {
                    if (wordCharCount[i] < licensePlateCharCount[i]) {
                        containFlag = false;
                    }
                }
                // 找到了长度更短的单词
                if (containFlag) {
                    res = word;
                }
            }
        }
        return res;
    }
}
// @lc code=end
