/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 当前数组已经有序
        if(this.isSorted(nums)){
            return 0;
        }
        // 深拷贝
        int[] copyArr = new int[nums.length];
        System.arraycopy(nums, 0, copyArr, 0, nums.length);
        // 升序
        Arrays.sort(copyArr);
        // 左边有序脚标 右边有序脚标
        int l=0;
        int r=nums.length-1;
        while(l<nums.length && nums[l]==copyArr[l]){
            l++;
        }
        while(r>=0&&nums[r]==copyArr[r]){
            r--;
        }
        // 中间无序的长度
        return r-l+1;
    }

    // 整个数组是否有序
    private boolean isSorted(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

