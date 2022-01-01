/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length-1;
        int mIdx=m-1, nIdx=n-1;
        while(idx>=0 && (mIdx>=0 || nIdx>=0)){
            if(mIdx<0){
                nums1[idx--]=nums2[nIdx--];
            }else if(nIdx<0){
                nums1[idx--]=nums1[mIdx--];
            }else{
                if(nums1[mIdx]>=nums2[nIdx]){
                    nums1[idx--]=nums1[mIdx--];
                }else{
                    nums1[idx--]=nums2[nIdx--];
                }
            }
        }
    }
}
// @lc code=end

