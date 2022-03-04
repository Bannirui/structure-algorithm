/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        boolean[] used=new boolean[n];
        List<List<Integer>> ret = new ArrayList<>();
        this.backtrack(n,k,0,used,new ArrayList<Integer>(),ret);
        return ret;
    }

    private void backtrack(int n, int k, int idx, boolean[] used, List<Integer> path, List<List<Integer>> ret){
        // base case
        if(path==null) throw new IllegalArgumentException();
        if(path.size()==k){
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        if(idx==n) return;
        for(int i=idx;i<n;i++){
            if(!used[i]){
                used[i]=true;
                List<Integer> pathCpy = new ArrayList<>(path);
                pathCpy.add(i+1);
                this.backtrack(n,k,i,used,pathCpy,ret);
                used[i]=false;
            }
        }
    }
}
// @lc code=end

