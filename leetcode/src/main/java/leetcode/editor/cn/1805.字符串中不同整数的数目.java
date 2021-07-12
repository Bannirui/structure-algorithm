import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-12 17:23:10
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-12 17:46:52
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1805 lang=java
 *
 * [1805] 字符串中不同整数的数目
 */

// @lc code=start
class Solution {
    public int numDifferentIntegers(String word) {
        String[] words = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }
            int j = 0;
            while (words[i].charAt(j) == '0' && j < words[i].length() - 1) {
                j++;
            }
            set.add(words[i].substring(j));
        }
        return set.size();
    }
}
// @lc code=end
