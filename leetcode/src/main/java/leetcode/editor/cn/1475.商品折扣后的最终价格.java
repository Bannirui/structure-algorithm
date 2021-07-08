import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 14:00:44
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 14:44:23
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        // key=数字脚标 value=折扣
        Map<Integer, Integer> map = new HashMap<>();
        // 单调栈 找<=的值 栈里面存脚标
        Stack<Integer> helpStack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (helpStack.isEmpty()) {
                helpStack.push(i);
            } else {
                while (!helpStack.isEmpty() && (prices[i] <= prices[helpStack.peek()])) {
                    // 找到了右边第一个<=自己的值
                    map.put(helpStack.pop(), prices[i]);
                }
                helpStack.push(i);
            }
        }
        // 栈里面元素右边没有最小值 较小值脚标记为-1
        while (!helpStack.isEmpty()) {
            map.put(helpStack.pop(), 0);
        }
        // map中折扣
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            res[i] = (prices[i] - map.get(i));
        }
        return res;
    }
}
// @lc code=end
