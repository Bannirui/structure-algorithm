/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    private List<String> ret = new ArrayList<>();

    private int pairCnt;

    public List<String> generateParenthesis(int n) {
        if(n==0) return this.ret;
        this.pairCnt = n;
        this.dfs(0, 0, "");
        return this.ret;
    }

    private void dfs(int leftCnt, int rightCnt, String path){
        if(path.length()==2*this.pairCnt){
            this.ret.add(new String(path));
            return;
        }
        if(leftCnt<this.pairCnt){
            String pathCpy = new String(path);
            pathCpy+="(";
            this.dfs(leftCnt+1, rightCnt, pathCpy);
        }
        if(rightCnt<leftCnt){
            String pathCpy = new String(path);
            pathCpy+=")";
            this.dfs(leftCnt, rightCnt+1, pathCpy);
        }
    }
}
// @lc code=end

