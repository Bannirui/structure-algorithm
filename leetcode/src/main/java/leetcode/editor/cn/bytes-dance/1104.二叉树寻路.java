/*
 * @lc app=leetcode.cn id=1104 lang=java
 *
 * [1104] 二叉树寻路
 */

// @lc code=start
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level=1;
        while(this.endOfLevel(level)<label) level++;
        int[] ret = new int[level];
        int idx=level-1;
        int cur=label;
        while(idx>=0){
            ret[idx--]=cur;
            int loc=(this.endOfLevel(level)-cur)/2;
            level--;
            cur=this.startOfLevel(level)+loc;
        }
        List<Integer> ans = new ArrayList<>();
        for(int num: ret) ans.add(num);
        return ans;
    }

    private int startOfLevel(int l){
        return (int)Math.pow(2, l-1);
    }

    private int endOfLevel(int l){
        return (int)Math.pow(2, l) -1;
    }
}
// @lc code=end

