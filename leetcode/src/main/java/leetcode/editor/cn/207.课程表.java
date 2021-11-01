import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {

    private List<List<Integer>> edges;
    // 0-还没访问过 1-访问中 2-访问过
    private int[] visited;
    private boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // dfs
        // return this.canFinishDfs(numCourses, prerequisites);

        // bfs
        return this.canFinishBfs(numCourses, prerequisites);
    }

    // ######################## bfs ########################
    private boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        // base case
        int pLen = 0;
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites == null || (pLen = prerequisites.length) == 0) {
            return true;
        }
        // 课程的入度
        int[] inDegree = new int[numCourses];
        // 邻边
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            // int[2]{后继课程, 前驱课程}
            int preNo = info[1];
            int nextNo = info[0];
            inDegree[nextNo]++;
            edges.get(preNo).add(nextNo);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 加入入度为0的顶点 表示可以选择的课程
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer courseNo = queue.poll();
            cnt++;
            // 遍历顶点上连接的所有的边
            for (int point : edges.get(courseNo)) {
                inDegree[point]--;
                if (inDegree[point] == 0) {
                    // 入度为0 可以选择该课程了
                    queue.offer(point);
                }
            }
        }
        return cnt == numCourses;
    }
    // ######################## bfs ########################

    // ######################## dfs ########################
    private boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        // 图 构建图中的边关系
        this.edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        this.visited = new int[numCourses];
        for (int[] info : prerequisites) {
            this.edges.get(info[1]).add(info[0]);
        }
        for (int prev = 0; prev < numCourses && this.valid; prev++) {
            if (this.visited[prev] == 0) {
                this.dfs(prev);
            }
        }
        return this.valid;
    }

    private void dfs(int prev) {
        // 标记课程pre在访问中
        this.visited[prev] = 1;
        for (int next : this.edges.get(prev)) {
            if (this.visited[next] == 0) {
                // 课程next还没被访问过
                this.dfs(next);
                if (!this.valid) {
                    return;
                }
            } else if (this.visited[next] == 1) {
                // 课程next正在被访问中 表示图中出现了环
                this.valid = false;
                return;
            }
        }
        // 标记课程pre访问过
        this.visited[prev] = 2;
    }
    // ######################## dfs ########################
}
// @lc code=end
