/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) throw new IllegalArgumentException();
        int len1=nums1.length, len2=nums2.length;
        int totalLen=len1+len2;
        if(totalLen%2==1){
            int midIdx = totalLen/2;
            double midVal=this.getKthVal(nums1, nums2, midIdx+1);
            return midVal;
        }else{
            int midIdx1=totalLen/2-1;
            int midIdx2=totalLen/2;
            double midVal=(this.getKthVal(nums1, nums2, midIdx1+1)+this.getKthVal(nums1,nums2,midIdx2+1))/2.0;
            return midVal;
        }
    }

    private int getKthVal(int[] nums1, int[] nums2, int k){
        int len1=nums1.length;
        int len2=nums2.length;
        int idx1=0, idx2=0;
        for(;;){
            if(idx1==len1) return nums2[idx2+k-1];
            if(idx2==len2) return nums1[idx1+k-1];
            if(k==1) return Math.min(nums1[idx1], nums2[idx2]);

            int half=k/2;
            int newIdx1 = Math.min(idx1+half, len1)-1;
            int newIdx2 = Math.min(idx2+half, len2)-1;
            int pivot1=nums1[newIdx1];
            int pivot2=nums2[newIdx2];
            if(pivot1<=pivot2){
                k-=(newIdx1-idx1+1);
                idx1=newIdx1+1;
            }else{
                k-=(newIdx2-idx2+1);
                idx2=newIdx2+1;
            }
        }
    }
}
// @lc code=end

