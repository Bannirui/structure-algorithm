/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int LEN1=0, LEN2=0;
        if(nums1==null || (LEN1=nums1.length)==0 || (LEN2=nums2.length)==0) throw new IllegalArgumentException();
        Map<Integer, Integer> val2NextIdx = new HashMap<>();
        Stack<Integer> idxStack = new Stack<>();
        for(int i=0;i<LEN2;i++){
            while(!idxStack.isEmpty() && nums2[i]>nums2[idxStack.peek()])
                val2NextIdx.put(nums2[idxStack.pop()], nums2[i]);
            idxStack.push(i);
        }
        while(!idxStack.isEmpty()) val2NextIdx.put(nums2[idxStack.pop()],-1);
        int[] ret = new int[LEN1];
        for(int i=0;i<LEN1;i++)
            ret[i]=val2NextIdx.get(nums1[i]);
        return ret;
    }
}
// @lc code=end

