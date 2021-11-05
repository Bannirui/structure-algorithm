/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 计数
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int num: nums){
            cntMap.put(num, cntMap.getOrDefault(num,0)+1);
        }
        // 遍历 进小顶堆
        Queue<Map.Entry<Integer, Integer>> smallHeap = new PriorityQueue<>((entry1, entry2)->{
            return entry1.getValue()-entry2.getValue();
        });
        for(Map.Entry<Integer, Integer> entry: cntMap.entrySet()){
            smallHeap.offer(entry);
            if(smallHeap.size()>k){
                smallHeap.poll();
            }
        }
        // 结果
        int[] res = new int[k];
        int heapSize = smallHeap.size();
        for(int i=0;i<heapSize;i++){
            res[i]=smallHeap.poll().getKey();
        }
        return res;
    }
}
// @lc code=end

