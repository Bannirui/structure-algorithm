import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-29 17:05:17
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 18:01:19
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {

    // 有向图
    List<List<Integer>> edges;

    // 顶点访问状态 0=未访问 1=正在访问 2=已经访问过
    private int[] visited;

    private int[] res;

    private int index;

    // 是否有环标识
    private boolean valid;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            this.edges.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {
            this.edges.get(course[1]).add(course[0]);
        }
        this.visited = new int[numCourses];
        this.res = new int[numCourses];
        this.index = numCourses - 1;
        this.valid = true;
        for (int j = 0; j < numCourses; j++) {
            if (this.visited[j] == 0) {
                dfs(j);
            }
        }
        return valid ? res : new int[0];
    }

    // 遍历课程x
    private void dfs(int x) {
        // 更新访问标识
        this.visited[x] = 1;
        // 以x为顶点遍历边
        for (int y : this.edges.get(x)) {
            // 访问状态
            int visitedStatus = this.visited[y];
            if (visitedStatus == 0) {
                // 未访问
                dfs(y);
                if (!valid) {
                    // 出现环
                    return;
                }
            } else if (visitedStatus == 1) {
                // 访问中 出现了环
                this.valid = false;
                return;
            } else {
                // 访问过了
            }
        }
        this.visited[x] = 2;
        // 加到结果集中
        this.res[this.index--] = x;
    }
}
// @lc code=end
