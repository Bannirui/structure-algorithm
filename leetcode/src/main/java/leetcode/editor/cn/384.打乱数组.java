import java.util.Random;

/*
 * @Author: dingRui
 * @Date: 2021-08-17 14:43:14
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-17 15:47:28
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {

    private int[] arr;
    private int[] origin;

    private Random random = new Random();

    public Solution(int[] nums) {
        // 数组拷贝
        this.origin = nums.clone();
        this.arr = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < this.arr.length; i++) {
            this.swap(this.arr, i, this.rand(i, this.arr.length));
        }
        return this.arr;
    }

    private void swap(int[] nums, int x, int y) {
        int X = nums[x];
        nums[x] = nums[y];
        nums[y] = X;
    }

    private int rand(int min, int max) {
        // [min...max)
        return this.random.nextInt(max - min) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end
