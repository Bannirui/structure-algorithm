/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int totalSum=0;
        // 接雨水总和 找到所有的 峰-谷-峰
        // 单调递减栈 遇到递增 就求和一次 直到遍历结束所有
        // 栈里面存放脚标
        Stack<Integer> descStack = new Stack<Integer>();
        for(int i=0; i<height.length; i++){
            if(descStack.isEmpty()){
                // 空 入栈
                descStack.push(i);
            }else{
                // 栈不空 判断是否要出栈
                if(height[i]<=height[descStack.peek()]){
                    // 单调递减 入栈
                    descStack.push(i);
                }else{
                    // 遇到 峰-谷-峰 出栈
                    while(!descStack.isEmpty() && height[i]>height[descStack.peek()]){
                        int rightIdx = i;
                        int rightHeight = height[i];
                        int midIdx=descStack.pop();
                        int midHeight = height[midIdx];
                        if(!descStack.isEmpty()){
                            int leftIdx = descStack.peek();
                            int leftHeight =height[leftIdx];
                            // 当前接到的雨水
                            int curWidth = rightIdx-leftIdx-1;
                            int curHeight = Math.min(leftHeight, rightHeight)-midHeight;
                            totalSum+=(curWidth*curHeight);
                        }
                    }
                    descStack.push(i);
                }
            }
        }
        return totalSum;
    }
}
// @lc code=end

