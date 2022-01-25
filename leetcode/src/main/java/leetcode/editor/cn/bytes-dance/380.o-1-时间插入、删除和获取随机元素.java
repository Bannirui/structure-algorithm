/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {

    private Map<Integer,Integer> m4Val=new HashMap<>();
    private List<Integer> idx=new ArrayList<>();
    private Random r=new Random();

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if(this.m4Val.containsKey(val)) return false;
        int size = this.idx.size();
        this.m4Val.put(val,size);
        this.idx.add(size,val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!this.m4Val.containsKey(val)) return false;
        int lastEle=this.idx.get(this.idx.size()-1);
        int index=this.m4Val.get(val);
        // rebuilt
        this.idx.set(index,lastEle);
        this.m4Val.put(lastEle,index);
        // remove
        this.m4Val.remove(val);
        this.idx.remove(this.idx.size()-1);
        return true;
    }
    
    public int getRandom() {
        // 0...size-1
        int size=this.idx.size();
        return this.idx.get(this.r.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

