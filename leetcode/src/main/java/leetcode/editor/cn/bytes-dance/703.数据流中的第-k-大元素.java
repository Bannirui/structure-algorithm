/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start
class KthLargest {

    private int k;
    private Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.pq=new PriorityQueue<Integer>((n1,n2)->{
            return n1-n2; // asc
        });
        for(int num: nums) this.add(num);
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if(pq.size()>this.k) this.pq.poll();
        if(this.pq.isEmpty()) throw new RuntimeException("err");
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

