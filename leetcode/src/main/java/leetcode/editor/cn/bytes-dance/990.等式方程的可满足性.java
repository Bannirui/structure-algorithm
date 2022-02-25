/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {
        int len=0;
        if(equations==null || (len=equations.length)==0) throw new IllegalArgumentException();
        int[] parent = new int[26];
        for(int i=0;i<26;i++) parent[i]=i;
        for(String equation: equations){
            if(equation.charAt(1)=='='){
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                this.union(parent, a-'a', b-'a');
            }
        }

        for(String equation: equations){
            if(equation.charAt(1)=='!'){
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                if(this.find(parent, a-'a')==this.find(parent, b-'a')) return false;
            }
        }
        return true;
    }

    private void union(int[] parent, int i, int j){
        parent[this.find(parent, i)] = this.find(parent, j);
    }

    private int find(int[] parent, int i){
        // base case
        if(parent[i]==i) return parent[i];
        return this.find(parent, parent[i]);
    }
}
// @lc code=end

