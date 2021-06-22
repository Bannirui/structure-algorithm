import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-06-22 15:24:17
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-22 15:35:35
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        // 成对出现移动指令
        int countU = 0, countD = 0, countL = 0, countR = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                countU++;
            } else if (c == 'D') {
                countD++;
            } else if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countR++;
            }
        }
        return (countU == countD) && (countL == countR);
    }
}
// @lc code=end
