/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            this.dfs(n, i, res);
        }
        return res;
    }

    private void dfs(int max, int cur, List<Integer> res){
        // base case
        if(cur>max){
            return;
        }
        res.add(cur);
        // 以cur为高进制位
        for(int i=0;i<=9;i++){
            this.dfs(max, cur*10+i, res);
        }
    }
}
// @lc code=end

