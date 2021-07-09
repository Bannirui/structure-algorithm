/*
 * @Author: dingrui
 * @Date: 2021-07-09 14:24:35
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 14:53:55
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1534 lang=java
 *
 * [1534] 统计好三元组
 */

// @lc code=start
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // 暴力
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
