/*
 * @lc app=leetcode.cn id=1172 lang=java
 *
 * [1172] 餐盘栈
 */

// @lc code=start
class DinnerPlates {

    Stack<Integer>[] arr = new Stack[100_000];
    int cap;
    int left=0;
    int right=0;

    public DinnerPlates(int capacity) {
        this.cap=capacity;
    }
    
    public void push(int val) {
        if(arr[this.left]==null) arr[this.left]=new Stack<Integer>();
        Stack<Integer> stack = arr[this.left];
        if(stack.size() == this.cap){
            while(arr[this.left]!=null&&arr[this.left].size()==this.cap) this.left++;
            if(arr[this.left]==null) arr[this.left]=new Stack<Integer>();
        }
        arr[left].push(val);
        if(right<left) right=left;
    }
    
    public int pop() {
        if(this.right==-1) return -1;
        if(arr[this.right]==null || arr[right].size()==0){
            while(right>=0 && (arr[right]==null || arr[right].size()==0)) right--;
        }
        if(right==-1) return -1;
        return arr[right].pop();
    }
    
    public int popAtStack(int index) {
        if(index<0) return -1;
        if(arr[index]==null || arr[index].size()==0) return -1;
        if(left>index) left =index;
        return arr[index].pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
// @lc code=end

