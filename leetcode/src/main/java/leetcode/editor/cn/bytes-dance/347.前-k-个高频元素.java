/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<0) return null;
        Map<Integer, Integer> cntMap = new HashMap<>(); // count element in arr
        for(int i=0; i<nums.length; i++){
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i],0)+1);
        }
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2)->{
            // asc by cnt
            return e1.getValue().compareTo(e2.getValue());
        });
        for(Map.Entry<Integer, Integer> e: cntMap.entrySet()){
            heap.offer(e);
            if(heap.size()>k){
                heap.poll();
            }
        }
        int size = heap.size();
        if(size==0) return null;
        int[] ret =new int[size];
        for(int i=0; i<size; i++){
            ret[i] = heap.poll().getKey();
        }
        return ret;
    }
}
// @lc code=end

