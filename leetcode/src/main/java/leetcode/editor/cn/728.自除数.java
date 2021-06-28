import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-24 13:20:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 13:58:27
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        // 只有一位的
        for (int i = left; i <= right; i++) {
            if (isDivNumber(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isDivNumber(int num) {
        String numStr = String.valueOf(num);
        char[] numCharArr = numStr.toCharArray();
        for (char c : numCharArr) {
            if (c == '0') {
                return false;
            }
            if ((num % (c - '0')) != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
