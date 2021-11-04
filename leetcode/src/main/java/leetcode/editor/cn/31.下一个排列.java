/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // 最大值为降序 最小值为升序
        // 从后往前找第一个升序 [i...i+1]升序 [i+1...]降序
        int i=nums.length-2;
        for(;i>=0&&nums[i]>=nums[i+1];){
            i--;
        }
        // 如果i来到-1说明整个降序
        if(i>=0){
            // 在[0...n]中间找到了i 使[i...i+1]升序 [i+1...n]降序
            // 在从后往前[i+1...n]找到第一个大于i的数字j
            int j=nums.length-1;
            while(j>=0&&nums[i]>=nums[j]){
                j--;
            }
            // 找到了j 交换i和j
            this.swap(nums, i, j);
        }
        // 整个数组降序 已经是最大的数字了 整个翻转
        this.reverse(nums, i+1, nums.length-1);
    }

    // nums [start...end]进行翻转
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            this.swap(nums, start, end);
            start++;
            end--;
        }
    }

    // 元素交换
    private void swap(int[] nums, int i, int j){
        int tmpVal = nums[i];
        nums[i] = nums[j];
        nums[j] = tmpVal;
    }
}
// @lc code=end

