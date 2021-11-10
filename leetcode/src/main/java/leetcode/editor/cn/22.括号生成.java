/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.dfs(n, 0, 0, "");
        return this.res;
    }

    // 总共pairCnt括号对
    // 已经使用左括号数量leftUsedCnt
    // 已经使用右括号数量rightUsedCnt
    // 已经生成的括号字符串path
    private void dfs(int pairCnt, int leftUsedCnt, int rightUsedCnt, String path){
        // base case
        if(path.length() == pairCnt*2){
            // 收集方案
            this.res.add(path);
            return;
        }
        // 使用左括号
        if(leftUsedCnt<pairCnt){
            String newPath = new String(path);
            newPath += "(";
            this.dfs(pairCnt, leftUsedCnt+1, rightUsedCnt, newPath);
        }
        // 使用右括号
        if(rightUsedCnt<leftUsedCnt){
            String newPath = new String(path);
            newPath += ")";
            this.dfs(pairCnt, leftUsedCnt, rightUsedCnt+1, newPath);
        }
    }
}
// @lc code=end

