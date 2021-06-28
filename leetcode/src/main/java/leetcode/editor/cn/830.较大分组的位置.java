import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-06-28 16:10:37
 * @LastEditors: dingrui
 * @LastEditTime: 2021-06-28 16:27:47
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] sCharArr = s.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < sCharArr.length;) {
            // 以i为起始 [i,j]是否都相等
            int j = i + 1;
            char firChar = sCharArr[i];
            while (j < sCharArr.length) {
                if (sCharArr[j] == sCharArr[i]) {
                    j++;
                } else {
                    break;
                }
            }
            if (j - i >= 3) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j - 1);
                res.add(tmp);
            }
            // 现在j的位置就是新字符的位置
            i = j;
        }
        return res;
    }
}
// @lc code=end
