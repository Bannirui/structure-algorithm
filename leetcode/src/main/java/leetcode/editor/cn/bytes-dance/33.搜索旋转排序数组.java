/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        /*
        l1...r1 l2...r2
        [l1...r1] asc
        [l2...r2] asc
        [r1...l2] desc
        */
        int len=0;
        if((len=nums.length)==0) return -1; // empty arr
        if(len==1) return nums[0]==target?0:-1; // only one element
        int l=0, r=len-1; // two pointer
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target) return mid;
            if(nums[0]<=nums[mid]){ // [l1...r1]
                if(nums[0]<=target && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{ // [l2...r2]
                if(nums[mid]<target && target<=nums[len-1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

