/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // base case
        if(n==1) return new ArrayList<Integer>(){{
            add(0);
        }};
        int[] indegree = new int[n];
        List<List<Integer>> edgesTable = new ArrayList<>();
        for(int i=0;i<n;i++) edgesTable.add(new ArrayList<>());
        for(int[] edge: edges){
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            edgesTable.get(edge[0]).add(edge[1]);
            edgesTable.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==1) q.offer(i);
        List<Integer> ret = new ArrayList<>();
        while(!q.isEmpty()){
            ret=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                ret.add(cur);
                for(int e: edgesTable.get(cur)){
                    indegree[e]--;
                    if(indegree[e]==1) q.offer(e);
                }
            }
        }
        return ret;
    }
}
// @lc code=end

