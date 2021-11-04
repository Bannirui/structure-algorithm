/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调递减栈 遇到递增就出栈 栈里面保存脚标
        int[] res =new int[temperatures.length];
        Stack<Integer> descStack = new Stack<>();
        // 遍历元素
        for(int i=0;i<temperatures.length;i++){
            if(descStack.isEmpty()){
                // 空栈直接入
                descStack.push(i);
            }else{
                // 非空栈 判断栈顶元素
                while(!descStack.isEmpty()&&temperatures[i]>temperatures[descStack.peek()]){
                    // 遇到了更高的温度 出栈
                    int idx = descStack.pop();
                    res[idx]=i-idx;
                }
                descStack.push(i);
            }
        }
        // 遍历完 栈里面可能还有元素 这些元素后面再也没有更大元素使之出栈
        while(!descStack.isEmpty()){
            int idx = descStack.pop();
            res[idx]=0;
        }
        return res;
    }
}
// @lc code=end

