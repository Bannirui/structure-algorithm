import javax.security.auth.login.CredentialException;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 09:17:40
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 10:10:04
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1232 lang=java
 *
 * [1232] 缀点成线
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        // 第一个点
        int[] origin = coordinates[0];
        // 第二个点
        int[] sec = coordinates[1];
        for (int i = 2; i < len; i++) {
            if (((coordinates[i][1] - origin[1]) * (sec[0] - origin[0])) != ((coordinates[i][0] - origin[0])
                    * (sec[1] - origin[1]))) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
