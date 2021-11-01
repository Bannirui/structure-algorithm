import java.awt.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return this.bfs(numCourses, prerequisites);
    }

    private int[] bfs(int numCourses, int[][] prerequisites) {
        // 课程的入度
        int[] inDegree = new int[numCourses];
        // 构建图
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        // 所有课程 顶点-边的情况
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            // 后继课程-前驱课程
            edges.get(info[1]).add(info[0]);
            // 入度
            inDegree[info[0]]++;
        }
        // 存储所有可以选的课程(入度为0)
        Queue<Integer> pending4Select = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                // 该课程可选 入队
                pending4Select.offer(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        ;
        // 已经选了几门课程
        int cnt4Select = 0;
        // bfs转起来
        while (!pending4Select.isEmpty()) {
            // 选一门
            int selectedCourse = pending4Select.poll();
            cnt4Select++;
            resList.add(selectedCourse);
            // 该顶点的邻边
            for (Integer nextCourse : edges.get(selectedCourse)) {
                // pre被选择了 pre-next的出度减1 也就是next的入度减1
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    // 是否可以被选择
                    pending4Select.offer(nextCourse);
                }
            }
        }
        // 已经选择的课程都已经搜集在resList中
        if (resList.size() != numCourses) {
            return new int[0];
        } else {
            int[] resArr = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                resArr[i] = resList.get(i);
            }
            return resArr;
        }
    }
}
// @lc code=end
