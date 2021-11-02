/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {

    // 结果集
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        // 括号对 先有左括号 后有又括号
        this.dfs(n, "", 0, 0);
        return this.res;
    }

    // 总共需要pairCnt对括号 已经生成了path 使用了left个左括号 right个右括号
    private void dfs(int pairCnt, String path, int left, int right){
        // base case
        if(path.length()==pairCnt*2){
            // 已经生成了一种答案 收集
            this.res.add(new String(path));
            return;
        }
        // 左括号可以使用的上限pairCnt
        if(left<pairCnt){
            // 继续选择使用或者不使用左括号
            String newPath = new String(path);
            newPath += "(";
            this.dfs(pairCnt, newPath, left+1, right);
        }
        // 右括号可以使用的上限是left
        if(right<left){
            String newPath = new String(path);
            newPath += ")";
            this.dfs(pairCnt, newPath, left, right+1);
        }
    }
}
// @lc code=end

