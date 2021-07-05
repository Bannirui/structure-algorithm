import java.util.Stack;

/*
 * @Author: dingrui
 * @Date: 2021-07-05 10:27:52
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-05 11:27:43
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1287 lang=java
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        int lastIndex = 0;
        int lastCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[lastIndex] == arr[i]) {
                // 相同元素
                lastCount++;
                if (lastCount * 4 > arr.length) {
                    // 找到了目标值
                    return arr[lastIndex];
                }
            } else {
                lastCount = 1;
                lastIndex = i;
            }
        }
        return -1;
    }
}
// @lc code=end
