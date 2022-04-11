/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */

// @lc code=start
class FreqStack {

    Map<Integer, Integer> freq=new HashMap();
    Map<Integer, Stack<Integer>> group=new HashMap();
    int maxfreq=0;

    public FreqStack() {
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        Stack<Integer> stack = this.group.get(f);
        if(stack==null) stack=new Stack<Integer>();
        stack.push(val);
        this.group.put(f, stack);
        if (f > maxfreq) maxfreq = f;
    }
    
    public int pop() {
        Stack<Integer> stack = this.group.get(this.maxfreq);
        if(stack==null || stack.isEmpty()) throw new RuntimeException();
        int ret=stack.pop();
        if(stack.isEmpty()) this.maxfreq--;
        freq.put(ret, freq.get(ret) - 1);
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end

