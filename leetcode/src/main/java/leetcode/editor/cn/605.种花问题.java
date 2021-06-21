import javax.swing.plaf.basic.BasicComboBoxUI.FocusHandler;

/*
 * @Author: dingrui
 * @Date: 2021-06-21 13:24:54
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-21 17:17:30
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 把花种满 还能种多少
        int len = flowerbed.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                // 已经种花 不能再种了
            } else {
                // 空地 能否种花取决于邻居
                if ((i - 1 >= 0 && flowerbed[i - 1] == 1) || (i + 1 < len && flowerbed[i + 1] == 1)) {
                    // 不能种
                } else {
                    // 可以种
                    count++;
                    // 把花种上
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }
}
// @lc code=end
