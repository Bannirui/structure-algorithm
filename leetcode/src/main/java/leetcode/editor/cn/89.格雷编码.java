import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-21 22:34:51
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 15:57:21
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {

    public List<Integer> grayCode(int n) {
        // 递归
        if (n == 0) {
            return Collections.singletonList(0);
        }
        List<Integer> res = new ArrayList<Integer>() {
            {
                add(0);
            }
        };
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

}
// @lc code=end
