import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // nums1的元素都在nums2中 找到nums2中所有元素的下一个更大数字就行 然后存hash表
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历nums2中的元素
        int len = nums2.length;
        for (int i = 0; i < len; i++) {
            boolean find = false;
            for (int j = i + 1; j < len; j++) {
                if (nums2[j] > nums2[i]) {
                    // 找到了i的下一个比其大的值
                    map.put(nums2[i], nums2[j]);
                    find = true;
                    break;
                }
            }
            // 整个for循环走完都没有找到就设置为-1
            if (!find) {
                map.put(nums2[i], -1);
            }
        }
        // 遍历nums1
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
// @lc code=end
