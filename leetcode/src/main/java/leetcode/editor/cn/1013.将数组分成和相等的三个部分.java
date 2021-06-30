/*
 * @Author: dingrui
 * @Date: 2021-06-30 15:03:13
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 15:17:10
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        // base case
        if (arr.length < 3) {
            return false;
        }
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        // part1=part2=part3
        if (totalSum % 3 != 0) {
            return false;
        }
        // part1
        int part1Sum = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            part1Sum += arr[i];
            if (3 * part1Sum == totalSum) {
                // part2
                int part2Sum = 0;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    part2Sum += arr[j];
                    if (part1Sum == part2Sum) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
// @lc code=end
