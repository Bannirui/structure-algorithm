import java.util.Arrays;

/*
 * @Author: dingRui
 * @Date: 2021-08-30 15:30:59
 * @LastEditors: dingRui
 * @LastEditTime: 2021-09-03 15:31:08
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 升序: 身高 人数
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                // 身高不同 按照身高升序
                return p1[0] - p2[0];
            } else {
                // 身高相同 按照人数降序
                return p2[1] - p1[1];
            }
        });
        // 重建顺序
        int n = people.length;
        int[][] res = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; i++) {
                if (res[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
