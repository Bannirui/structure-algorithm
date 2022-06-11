/*
 * @lc app=leetcode.cn id=432 lang=java
 *
 * [432] 全 O(1) 的数据结构
 */

// @lc code=start
class AllOne {

    Map<String, Integer> data = new HashMap<>();
    Queue<String> maxQ;
    Queue<String> minQ;;

    public AllOne() {
        this.maxQ = new PriorityQueue<>((s1, s2)->{
            return this.data.get(s2)-this.data.get(s1);
        });
        this.minQ = new PriorityQueue<>((s1, s2)->{
            return this.data.get(s1)-this.data.get(s2);
        });
    }
    
    public void inc(String key) {
        this.data.put(key, this.data.getOrDefault(key, 0)+1);
        if(this.maxQ.contains(key)) this.maxQ.remove(key);
        this.maxQ.offer(key);
        if(this.minQ.contains(key)) this.minQ.remove(key);
        this.minQ.offer(key);
    }
    
    public void dec(String key) {
        int curCnt = this.data.get(key);
        if(curCnt==1){
            this.data.remove(key);
            this.maxQ.remove(key);
            this.minQ.remove(key);
        }else{
            this.data.put(key, curCnt-1);
            this.maxQ.remove(key);
            this.maxQ.offer(key);
            this.minQ.remove(key);
            this.minQ.offer(key);
        }
    }
    
    public String getMaxKey() {
        if(this.data.isEmpty()) return "";
        return this.maxQ.peek();
    }
    
    public String getMinKey() {
        if(this.data.isEmpty()) return "";
        return this.minQ.peek();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
// @lc code=end

