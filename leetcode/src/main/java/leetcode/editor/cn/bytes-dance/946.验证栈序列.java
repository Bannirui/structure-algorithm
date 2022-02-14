/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int lenPush=0, lenPop=0;
        if(pushed==null || popped==null || (lenPush=pushed.length)==0 || (lenPop=popped.length)==0 || lenPush!=lenPop) throw new IllegalArgumentException();
        Stack<Integer> s = new Stack<>();
        int idxPush=0, idxPop=0;
        while(idxPush<=lenPush || idxPop<=lenPop){
            if(idxPush==lenPush && idxPop==lenPop && s.isEmpty()) return true;
            if(idxPush==lenPush && !s.isEmpty() && s.peek()!=popped[idxPop]) return false;
            while(!s.isEmpty() && idxPop<lenPop && s.peek()==popped[idxPop]) {
                s.pop();
                idxPop++;
            }
            if(idxPush<lenPush) s.push(pushed[idxPush++]);
        }
        return false;
    }
}
// @lc code=end

