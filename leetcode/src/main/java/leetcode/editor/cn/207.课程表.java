import java.util.ArrayList;
import java.util.List;

/*
 * @Author: dingrui
 * @Date: 2021-07-29 13:22:08
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-29 16:15:10
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {

    // 标识课程访问状态 0=未访问 1=访问中 2=访问过
    private int[] visited;

    // 能否修完课程 课程之间存在拓扑关系
    private boolean valid = true;

    // 课程之间关系 顶点 边
    private List<List<Integer>> edges = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 课程[x, y] 先修y 再修x y->x存在拓扑关系
        // 课程数numCourses
        this.visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            this.edges.add(new ArrayList<>());
        }
        // 顶点 边
        for (int[] course : prerequisites) {
            this.edges.get(course[1]).add(course[0]);
        }
        // 遍历所有课程
        for (int j = 0; j < numCourses && this.valid; j++) {
            if (this.visited[j] == 0) {
                // 还没访问过
                dfs(j);
            }
        }
        return this.valid;
    }

    // 访问课程y
    private void dfs(int y) {
        // 标记y当前正在访问中
        this.visited[y] = 1;
        // 课程y是顶点 找到对应的边
        for (int x : this.edges.get(y)) {
            // 遍历所有的边x
            if (this.visited[x] == 0) {
                // 没访问过
                dfs(x);
                if (!valid) {
                    return;
                }
            } else if (this.visited[x] == 1) {
                // 正在访问中 形成了环
                this.valid = false;
                return;
            } else {
                // 已经访问过
            }
        }
        // 标记y当前访问结束
        this.visited[y] = 2;
    }
}
// @lc code=end
