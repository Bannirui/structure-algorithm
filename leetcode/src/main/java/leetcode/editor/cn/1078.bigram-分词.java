import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-01 13:52:11
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 14:02:54
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1078 lang=java
 *
 * [1078] Bigram 分词
 */

// @lc code=start
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> help = new ArrayList<>();
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length - 2; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];
            if (firstWord.equals(first) && secondWord.equals(second)) {
                // got it
                help.add(words[i + 2]);
            }
        }
        String[] res = new String[help.size()];
        for (int i = 0; i < help.size(); i++) {
            res[i] = help.get(i);
        }
        return res;
    }
}
// @lc code=end
