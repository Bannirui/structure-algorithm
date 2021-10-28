/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        // 升序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 双指针
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            int v1 = nums1[p1];
            int v2 = nums2[p2];
            if (v1 == v2) {
                resList.add(v1);
                p1++;
                p2++;
            } else if (v1 < v2) {
                // p1后移
                p1++;
            } else {
                // p2后移
                p2++;
            }
        }
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }
}
// @lc code=end
