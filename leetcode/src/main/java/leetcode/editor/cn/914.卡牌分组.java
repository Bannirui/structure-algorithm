import java.util.HashMap;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-06-29 12:58:58
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 13:39:17
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // 计数每个分组的数量
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (countMap.containsKey(deck[i])) {
                int curCount = countMap.get(deck[i]);
                countMap.put(deck[i], curCount + 1);
                // 求最大公约数
            } else {
                countMap.put(deck[i], 1);
            }
        }
        // 计数的最大公约数
        int g = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (g == -1) {
                g = entry.getValue();
            } else {
                g = gcd(g, entry.getValue());
            }
        }
        return g >= 2;
    }

    // 两个数的最大公约数
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
// @lc code=end
