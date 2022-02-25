/*
 * @lc app=leetcode.cn id=900 lang=java
 *
 * [900] RLE 迭代器
 */

// @lc code=start
class RLEIterator {

    private Stack<Integer> cnt = new Stack<>();
    private Stack<Integer> val = new Stack<>();

    public RLEIterator(int[] encoding) {
        int len=0;
        if(encoding==null || (len=encoding.length)==0 || len%2!=0) throw new IllegalArgumentException();
        for(int i=len-2;i>=0;i-=2){
            if(encoding[i]==0) continue;
            this.cnt.push(encoding[i]);
            this.val.push(encoding[i+1]);
        }
    }
    
    public int next(int n) {
        if(this.cnt.isEmpty()) return -1;
        if(n==0) return this.val.peek();
        if(n<=this.cnt.peek()){
            this.cnt.push(this.cnt.pop()-n);
            n=0;
        }else{
            n-=this.cnt.pop();
            this.val.pop();
        }
        return this.next(n);
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
// @lc code=end

