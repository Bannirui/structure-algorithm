/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {

    private int[] origin;
    private int[] out; 
    private Random rand = new Random();

    public Solution(int[] nums) {
        if(nums==null || nums.length==0) throw new RuntimeException("err: param");
        this.origin = nums.clone();
        this.out = nums.clone();
    }
    
    public int[] reset() {
        return this.origin;
    }
    
    public int[] shuffle() {
        this.out=this.origin.clone();
        if(this.out.length==1) return this.out;
        for(int curIdx=this.out.length-1;curIdx>0;curIdx--){
            int randIdx = this.rand.nextInt(curIdx+1);
            // exchange
            int tmp = this.out[curIdx];
            this.out[curIdx] = this.out[randIdx];
            this.out[randIdx] = tmp;
        }
        return this.out;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

