/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1=nums1.length-1-nums2.length;
        int i2=nums2.length-1;
        int iMax=nums1.length-1;
        while(i1>=0&&i2>=0){
            int v1=nums1[i1];
            int v2=nums2[i2];
            if(v1>=v2){
                nums1[iMax]=nums1[i1];
                i1--;
                iMax--;
            }else{
                nums1[iMax]=nums2[i2];
                i2--;
                iMax--;
            }
        }
        // 至少有一个已经全部排完
        while(i1>=0){
            nums1[iMax]=nums1[i1];
            i1--;
            iMax--;
        }
        while(i2>=0){
            nums1[iMax]=nums2[i2];
            i2--;
            iMax--;
        }
    }
}
// @lc code=end

