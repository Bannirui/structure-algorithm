/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=0; // length of arr
        if(temperatures==null || (len=temperatures.length)==0) throw new RuntimeException("err");
        // mono stack and the ele is idx, keeping pushing element til bigger num
        Stack<Integer> idxStack = new Stack<>();
        int[] idxRet = new int[len]; // record the next bigger idx
        for(int i=0; i<len; i++){
            while(!idxStack.isEmpty() && temperatures[i]>temperatures[idxStack.peek()]){
                // the bigger num occurs, record
                idxRet[idxStack.pop()] = i;
            }
            idxStack.push(i);
        }
        while(!idxStack.isEmpty()){
            // special value
            idxRet[idxStack.peek()]=idxStack.pop();
        }
        for(int i=0;i<len;i++){
            idxRet[i]=idxRet[i]-i;
        }
        return idxRet;
    }
}
// @lc code=end

