/*
 * @Author: dingrui
 * @Date: 2021-07-08 20:06:50
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 20:27:21
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            // k==0
        } else if (k > 0) {
            // k>0
            int sumK = 0;
            for (int i = 0; i < k; i++) {
                sumK += code[i];
            }
            for (int start = 0; start < code.length; start++) {
                sumK = sumK - code[start] + code[(start + k) % code.length];
                res[start] = sumK;
            }
        } else {
            // k<0 正数的翻转
            int[] reverseCode = this.reverseArr(code);
            int[] reverseRes = decrypt(reverseCode, -k);
            res = this.reverseArr(reverseRes);
        }
        return res;
    }

    private int[] reverseArr(int[] arr) {
        int[] reverseArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArr[i] = arr[arr.length - 1 - i];
        }
        return reverseArr;
    }
}
// @lc code=end
