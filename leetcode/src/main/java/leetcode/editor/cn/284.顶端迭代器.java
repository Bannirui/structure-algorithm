import java.util.Iterator;

/*
 * @Author: dingRui
 * @Date: 2021-08-03 17:03:07
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-03 17:08:26
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iter;

	private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.iter = iterator;
		this.next = this.iter.hasNext() ? this.iter.next() : null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return this.next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer tmp = this.next;
		this.next = this.iter.hasNext() ? this.iter.next() : null;
		return tmp;
	}

	@Override
	public boolean hasNext() {
		return this.next != null;
	}
}
// @lc code=end
