import java.util.Arrays;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 15:10:46
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 15:14:14
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1619 lang=java
 *
 * [1619] 删除某些元素后的数组均值
 */

// @lc code=start
class Solution {
    public double trimMean(int[] arr) {
        // 删除 最小数量 最大数量
        int counts = arr.length / 20;
        // 升序
        Arrays.sort(arr);
        double sum = 0;
        for (int i = counts; i < (arr.length - counts); i++) {
            sum += arr[i];
        }
        return (double) sum / (arr.length - (counts << 1));
    }
}
// @lc code=end
