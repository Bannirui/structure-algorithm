/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // sort
        Arrays.sort(intervals, (i1, i2)->{
            if(i1[0]==i2[0]){
                // asc
                return i1[1]-i2[1];
            }else{
                return i1[0]-i2[0];
            }
        });
        Stack<int[]> stack = new Stack<>();
        for(int[] interval: intervals){
            if(stack.isEmpty()){
                stack.push(interval);
            }else{
                if(stack.peek()[0]<=interval[0] && interval[0]<=stack.peek()[1]){
                    // 合并
                    int[] pre = stack.pop();
                    stack.push(new int[]{pre[0], Math.max(pre[1],interval[1])});
                }else{
                    // 不合并
                    stack.push(interval);
                }
            }
        }
        // res
        int[][] res = new int[stack.size()][];
        for(int i=stack.size()-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
// @lc code=end

