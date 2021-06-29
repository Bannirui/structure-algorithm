/*
 * @Author: dingrui
 * @Date: 2021-06-29 09:01:10
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-29 09:07:42
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果棒交换
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // sum
        int sumAlice = 0, sumBob = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sumAlice += aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++) {
            sumBob += bobSizes[i];
        }
        // index
        for (int i = 0; i < aliceSizes.length; i++) {
            for (int j = 0; j < bobSizes.length; j++) {
                // compare
                int aliceVal = aliceSizes[i];
                int bobVal = bobSizes[j];
                if ((sumAlice - aliceVal + bobVal) == (sumBob - bobVal + aliceVal)) {
                    return new int[] { aliceVal, bobVal };
                }
            }
        }
        return new int[2];
    }
}
// @lc code=end
