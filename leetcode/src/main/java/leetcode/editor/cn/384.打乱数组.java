/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {

    private int[] originArr;
    private int[] shuffleArr;
    private Random random=new Random();

    public Solution(int[] nums) {
        this.originArr = nums.clone();
        this.shuffleArr=nums.clone();
    }
    
    public int[] reset() {
        return this.originArr;
    }
    
    public int[] shuffle() {
        int[] help = this.originArr.clone();
        for(int i=0;i<help.length;i++){
            // 随机一个值放到i处 [0...n)
            int idx = this.random.nextInt(help.length-i);
            this.shuffleArr[i]=help[idx];
            // help中idx和最后一个位置交换
            int tmp=help[idx];
            int exchangeIdx = help.length-1-i;
            help[idx]=help[exchangeIdx];
            help[exchangeIdx]=tmp;
        }
        return this.shuffleArr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

