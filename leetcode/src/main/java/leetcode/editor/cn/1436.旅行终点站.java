import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-08 09:56:38
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-08 10:06:20
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1436 lang=java
 *
 * [1436] 旅行终点站
 */

// @lc code=start
class Solution {
    public String destCity(List<List<String>> paths) {
        // 只有一个终点 终点不是起点
        Set<String> startSet = new HashSet<>();
        for (List<String> path : paths) {
            if (!startSet.contains(path.get(0))) {
                startSet.add(path.get(0));
            }
        }
        // 遍历终点
        for (List<String> path : paths) {
            if (!startSet.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
// @lc code=end
