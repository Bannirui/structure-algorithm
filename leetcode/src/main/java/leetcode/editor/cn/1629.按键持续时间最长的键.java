/*
 * @Author: dingrui
 * @Date: 2021-07-10 15:55:57
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 16:01:16
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1629 lang=java
 *
 * [1629] 按键持续时间最长的键
 */

// @lc code=start
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // [0]=字符 [1]=持续时间
        int[] res = new int[2];
        for (int i = 0; i < keysPressed.length(); i++) {
            // char
            int c = keysPressed.charAt(i) - 'a';
            // time
            int t = releaseTimes[i] - (i == 0 ? 0 : releaseTimes[i - 1]);
            if (t > res[1]) {
                res[0] = c;
                res[1] = t;
            } else if (t == res[1]) {
                res[0] = Math.max(res[0], c);
            }
        }
        return (char) (res[0] + 'a');
    }
}
// @lc code=end
