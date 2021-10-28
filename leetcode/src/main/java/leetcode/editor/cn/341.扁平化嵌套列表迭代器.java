import java.util.Iterator;

/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {

    // 所有展开的元素
    List<Integer> itemList = new ArrayList<>();

    // 列表的迭代器
    Iterator<Integer> itemIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.dfs(nestedList);
        this.itemIterator = this.itemList.iterator();
    }

    // 递归展开放到容器中
    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                // 整数
                Integer curVal = nestedInteger.getInteger();
                this.itemList.add(curVal);
            } else {
                // 嵌套
                this.dfs(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return this.itemIterator.next();
    }

    @Override
    public boolean hasNext() {
        return this.itemIterator.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */
// @lc code=end
