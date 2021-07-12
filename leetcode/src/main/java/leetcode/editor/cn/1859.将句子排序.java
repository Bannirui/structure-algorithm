import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 20:35:41
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 21:00:58
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1859 lang=java
 *
 * [1859] 将句子排序
 */

// @lc code=start
class Solution {
    public String sortSentence(String s) {
        String[] words = s.split("\\s+");
        Map<Integer, String> wordsMap = new HashMap<>();
        int maxNum = -1;
        for (String word : words) {
            wordsMap.put((int) (word.charAt(word.length() - 1) - '0'), word.substring(0, word.length() - 1));
            maxNum = Math.max(maxNum, (int) (word.charAt(word.length() - 1) - '0'));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < maxNum; i++) {
            if (wordsMap.containsKey(i)) {
                sb.append(wordsMap.get(i));
                sb.append(" ");
            }
        }
        sb.append(wordsMap.get(maxNum));
        return sb.toString();
    }
}
// @lc code=end
