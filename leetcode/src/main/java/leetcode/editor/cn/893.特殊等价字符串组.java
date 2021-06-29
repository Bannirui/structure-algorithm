import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-06-29 11:20:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 11:46:07
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=893 lang=java
 *
 * [893] 特殊等价字符串组
 */

// @lc code=start
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        // 如果存在特殊等价字符串的话 一定存在一对下标(i, j) 使得s[i]==t[j] && s[j]==t[i]
        // 找到n组这样的脚标对
        // 数组0-25放偶数脚标的计数 26-51放奇数脚标的计数
        Set<String> find = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            int[] mark = new int[52];
            for (int j = 0; j < words[i].length(); j++) {
                mark[(words[i].charAt(j) - 'a') + 26 * (j % 2)]++;
            }
            find.add(Arrays.toString(mark));
        }
        return find.size();
    }
}
// @lc code=end
