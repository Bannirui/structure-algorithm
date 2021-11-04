/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] in = new int[numCourses];
        // 构建图 顶点的入度
        List<List<Integer>> edges = new ArrayList<>();
        // 课程[0...n-1]
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int[] prerequisity = prerequisites[i];
            edges.get(prerequisity[1]).add(prerequisity[0]);
            in[prerequisity[0]]++;
        }
        // 遍历课程 第一轮可选的放到队列
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        // 开始选课
        int cnt=0;
        while(!q.isEmpty()){
            Integer courseNo = q.poll();
            cnt++;
            // 邻边
            List<Integer> edgeCourses = edges.get(courseNo);
            for(int edgeCourse: edgeCourses){
                // 入度-1
                in[edgeCourse]--;
                if(in[edgeCourse]==0){
                    q.offer(edgeCourse);
                }
            }
        }
        return cnt==numCourses;
    }
}
// @lc code=end

