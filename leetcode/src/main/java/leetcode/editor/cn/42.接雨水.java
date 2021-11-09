/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 单调栈 递减栈 找峰-谷-峰
        Stack<Integer> stack = new Stack<>();
        int sum=0;
        for(int i=0; i<height.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(height[i]<=height[stack.peek()]){
                    // 递减 入栈
                    stack.push(i);
                }else{
                    // 递增 出栈
                    while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                        int rIdx = i;
                        int mIdx = stack.pop();
                        if(!stack.isEmpty()){
                            int lIdx = stack.peek();
                            int w = rIdx-lIdx-1;
                            int h = Math.min(height[lIdx],height[rIdx])-height[mIdx];
                            sum+=(w*h);
                        }
                    }
                    stack.push(i);
                }
            }
        }
        return sum;
    }
}
// @lc code=end

