import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: dingrui
 * @Date: 2021-07-09 13:36:39
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-09 13:47:34
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1582 lang=java
 *
 * [1582] 二进制矩阵中的特殊位置
 */

// @lc code=start
class Solution {
    public int numSpecial(int[][] mat) {
        // 两个数组记录行和列上面出现的元素次数 集合记录需要查找的坐标
        int ROW = mat.length;
        int COL = mat[0].length;
        // 行上面元素出现次数
        int[] rowCounts = new int[ROW];
        // 列上面元素出现次数
        int[] colCounts = new int[COL];
        // 坐标(r,c)
        List<List<Integer>> positions = new ArrayList<>();
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (mat[r][c] == 1) {
                    // 计数
                    rowCounts[r]++;
                    colCounts[c]++;
                    // 坐标
                    List<Integer> position = new ArrayList<>();
                    position.add(r);
                    position.add(c);
                    positions.add(position);
                }
            }
        }
        int res = 0;
        // 遍历坐标
        for (int i = 0; i < positions.size(); i++) {
            // (r, c)
            List<Integer> o = positions.get(i);
            if (rowCounts[o.get(0)] == 1 && colCounts[o.get(1)] == 1) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end
