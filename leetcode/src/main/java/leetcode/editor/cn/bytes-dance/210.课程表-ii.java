/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {

    private List<List<Integer>> edges;
    private int[] indgree;
    private int[] ret;
    private int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.edges=new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++) edges.add(new ArrayList<Integer>());
        this.indgree = new int[numCourses];
        this.ret=new int[numCourses];
        this.idx=0;
        // bfs
        for(int[] info: prerequisites){
            // int[0, 1] 0依赖于1 0的入度是1 1的出度是0
            this.indgree[info[0]]++;
            this.edges.get(info[1]).add(info[0]);
        }
        // 入度0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(this.indgree[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int cur=q.poll();
            this.ret[idx++]=cur;
            for(int e: this.edges.get(cur)){
                this.indgree[e]--;
                if(this.indgree[e]==0) q.offer(e);
            }
        }
        if(this.idx!=numCourses) return new int[0];
        return this.ret;
    }
}
// @lc code=end

