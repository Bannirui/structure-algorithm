import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-30 10:08:33
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-30 10:37:17
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        // int转列表
        List<Integer> tmp = new ArrayList<>();
        while (k != 0) {
            tmp.add(k % 10);
            k /= 10;
        }
        Collections.reverse(tmp);
        // 数组和列表中从高位相加
        int take = 0;
        int numIndex = num.length - 1;
        int tmpIndex = tmp.size() - 1;
        while (numIndex >= 0 || tmpIndex >= 0) {
            int numVal = numIndex < 0 ? 0 : num[numIndex];
            int tmpVal = tmpIndex < 0 ? 0 : tmp.get(tmpIndex);
            int sum = numVal + tmpVal + take;
            take = sum / 10;
            res.add(sum % 10);
            numIndex--;
            tmpIndex--;
        }
        // 最后的进位
        if (take != 0) {
            res.add(take);
        }
        // res翻转
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end
