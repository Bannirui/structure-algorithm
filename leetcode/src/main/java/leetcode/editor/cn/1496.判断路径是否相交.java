import java.util.HashSet;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 21:09:06
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 21:41:22
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1496 lang=java
 *
 * [1496] 判断路径是否相交
 */

// @lc code=start
class Solution {
    public boolean isPathCrossing(String path) {
        int len = path.length();
        Set<Long> positionSet = new HashSet<>();
        int x = 0, y = 0;
        positionSet.add((long) (x << 16) + (long) y);
        int[] diX = new int[] { -1, 0, 1, 0 };
        int[] diY = new int[] { 0, -1, 0, 1 };
        for (int i = 0; i < len; i++) {
            char di = path.charAt(i);
            if (di == 'N') {
                y++;
            } else if (di == 'S') {
                y--;
            } else if (di == 'W') {
                x--;
            } else if (di == 'E') {
                x++;
            }
            long position = (long) (x << 16) + (long) y;
            if (positionSet.contains(position)) {
                return true;
            }
            positionSet.add(position);
        }
        return false;
    }
}
// @lc code=end
