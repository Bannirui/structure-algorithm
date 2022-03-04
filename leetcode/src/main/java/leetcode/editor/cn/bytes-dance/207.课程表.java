/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // b->a
        int[] indgree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<numCourses;i++) edges.add(new ArrayList<>());
        for(int[] info: prerequisites){
            int a=info[0];
            int b=info[1];
            indgree[a]++;
            edges.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(indgree[i]==0) q.offer(i);
        int ret=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            ret++;
            for(int e: edges.get(cur)){
                indgree[e]--;
                if(indgree[e]==0) q.offer(e);
            }
        }
        return ret==numCourses;
    }
}
// @lc code=end

