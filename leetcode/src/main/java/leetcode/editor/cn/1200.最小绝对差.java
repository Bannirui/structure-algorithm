import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-03 14:44:49
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-03 14:50:11
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int curGap = arr[i + 1] - arr[i];
            if (curGap > gap) {
                continue;
            }
            if (curGap < gap) {
                gap = curGap;
                res.clear();
            }
            // curGap<=gap
            res.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return res;
    }
}
// @lc code=end
