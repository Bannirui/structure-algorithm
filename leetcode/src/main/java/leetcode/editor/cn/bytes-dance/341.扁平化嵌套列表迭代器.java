/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new ArrayList<>();;
    Iterator<Integer> it = list.iterator();

    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null || nestedList.size() == 0) return;
        for(NestedInteger ni: nestedList) this.dfs(ni);
        this.it = this.list.iterator();
    }

    @Override
    public Integer next() {
        return this.it.next();
    }

    @Override
    public boolean hasNext() {
        return this.it.hasNext();
    }

    private void dfs(NestedInteger ni){
        if(ni==null) return;
        if(ni.isInteger()) this.list.add(ni.getInteger());
        else {
            for(NestedInteger o: ni.getList()) this.dfs(o);
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

