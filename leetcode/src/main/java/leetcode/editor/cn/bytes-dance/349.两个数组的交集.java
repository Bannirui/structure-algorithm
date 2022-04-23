/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=0, len2=0;
        if(nums1==null || nums2==null || (len1=nums1.length)==0 || (len2=nums2.length)==0) return null;
        Set<Integer> set = new HashSet();
        for(int i=0; i<len1; i++) set.add(nums1[i]);
        Set<Integer> ret = new HashSet();
        for(int i=0;i<len2;i++){
            int v = nums2[i];
            if(set.contains(v) && !ret.contains(v)) ret.add(v);
        }
        int size = ret.size();
        int[] res = new int[size];
        int idx=0;
        for(int num: ret){
            res[idx]=num;
            idx++;
        }
        return res;
    }
}
// @lc code=end

