import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * @Author: dingRui
 * @Date: 2021-08-10 13:09:37
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-10 13:46:59
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % (this.gcd(jug1Capacity, jug2Capacity)) == 0;
    }

    /**
     * 取两数最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        int remain = x % y;
        while (remain != 0) {
            x = y;
            y = remain;
            remain = x % y;
        }
        return y;
    }
}
// @lc code=end
