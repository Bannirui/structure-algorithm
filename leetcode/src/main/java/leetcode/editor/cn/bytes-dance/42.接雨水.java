/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // low-high-low
        int ret = 0;
        // desc stack for index
        Stack<Integer> descStack = new Stack<>();
        for(int i=0;i<height.length;i++){
            while(!descStack.isEmpty()&&height[i]>=height[descStack.peek()]){
                int rightIdx = i;
                int midIdx = descStack.pop();
                if(!descStack.isEmpty()){
                    int leftIdx = descStack.peek();
                    ret+=(Math.min(height[rightIdx], height[leftIdx])-height[midIdx])*(rightIdx-leftIdx-1);
                }
            }
            descStack.push(i);
        }
        return ret;
    }
}
// @lc code=end

