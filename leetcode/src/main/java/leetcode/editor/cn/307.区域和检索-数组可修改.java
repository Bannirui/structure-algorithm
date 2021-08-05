/*
 * @Author: dingRui
 * @Date: 2021-08-05 11:32:07
 * @LastEditors: dingRui
 * @LastEditTime: 2021-08-05 13:56:41
 * @Description: 
 */
/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    // 线段树
    int[] tree;
    // 原数组长度
    int n;

    public NumArray(int[] nums) {
        if ((this.n = nums.length) > 0) {
            // 树的长度
            this.tree = new int[this.n * 2];
            // 构建树
            this.buildTree(nums);
        }
    }

    public void update(int index, int val) {
        // 原数组脚标对应在tree中的脚标
        index += this.n;
        this.tree[index] = val;
        // 当前节点index去找父节点进行更新
        while (index > 0) {
            int left = index, right = index;
            if (index % 2 == 0) {
                right = index + 1;
            } else {
                left = index - 1;
            }
            this.tree[index / 2] = this.tree[left] + this.tree[right];
            index /= 2;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        left += this.n;
        right += this.n;
        while (left <= right) {
            if (left % 2 == 1) {
                sum += this.tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += this.tree[right];
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    /**
     * @author: dingRui
     * @Date: 2021-08-05 13:31:19
     * @param {int[]} nums
     * @return {*}
     * @description: 构建线段树
     * @example: 
     */
    private void buildTree(int[] nums) {
        for (int i = this.n, j = 0; i < 2 * this.n; i++, j++) {
            this.tree[i] = nums[j];
        }
        for (int i = this.n - 1; i > 0; i--) {
            this.tree[i] = this.tree[2 * i] + this.tree[2 * i + 1];
        }
    }
}

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* obj.update(index,val);
* int param_2 = obj.sumRange(left,right);
*/
// @lc code=end
