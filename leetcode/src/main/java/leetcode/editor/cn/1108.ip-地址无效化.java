/*
 * @Author: dingrui
 * @Date: 2021-07-01 15:00:34
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-01 15:03:50
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1108 lang=java
 *
 * [1108] IP 地址无效化
 */

// @lc code=start
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
// @lc code=end
