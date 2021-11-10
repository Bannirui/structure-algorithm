/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 小顶堆
        Map<Integer, Integer> cntMap = new HashMap<>();
        // 遍历
        for(int num: nums){
            cntMap.put(num, cntMap.getOrDefault(num,0)+1);
        }
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((e1, e2)->{
            // cnt升序
            return e1.getValue()-e2.getValue();
        });
        for(Map.Entry<Integer,Integer> entry: cntMap.entrySet()){
            q.offer(entry);
            if(q.size()>k){
                q.poll();
            }
        }
        int size = q.size();
        int[] res = new int[size];
        for(int i=0;i<size;i++){
            res[i] = q.poll().getKey();
        }
        return res;
    }
}
// @lc code=end

