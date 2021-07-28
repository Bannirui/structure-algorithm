/*
 * @Author: dingrui
 * @Date: 2021-07-28 16:17:22
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-28 16:44:46
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        // 用.进行分割
        String[] fixs1 = version1.split("\\.");
        String[] fixs2 = version2.split("\\.");
        // 从左到右
        int index = 0;
        while (index < fixs1.length || index < fixs2.length) {
            // 可能有一个版本号已经遍历完了
            Integer fix1 = index < fixs1.length ? Integer.parseInt(fixs1[index]) : 0;
            Integer fix2 = index < fixs2.length ? Integer.parseInt(fixs2[index]) : 0;
            if (fix1 == fix2) {
                // 修订号大小相等 继续
                index++;
            } else {
                return fix1 > fix2 ? 1 : -1;
            }
        }
        return 0;
    }
}
// @lc code=end
