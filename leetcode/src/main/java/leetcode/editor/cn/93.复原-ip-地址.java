import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 17:25:56
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-22 18:06:00
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return Collections.emptyList();
        }
        this.dfs(s, 0, new ArrayList<>());
        return this.res;
    }

    // [0...s.length]中[index...s.length]找数字
    private void dfs(String s, int index, List<String> pathList) {
        // base case
        if (index == s.length()) {
            if (pathList.size() == 4) {
                // ip地址的4个收集齐
                String path = pathList.stream().collect(Collectors.joining("."));
                this.res.add(path);
                return;
            }
            return;
        }
        List<String> copyPathList = new ArrayList<>(pathList);
        // 当前字符是0
        if (s.charAt(index) == '0') {
            // 只能用当前的0
            copyPathList.add("" + s.charAt(index));
            dfs(s, index + 1, copyPathList);
        } else {
            // 当前不为0 [index...]最多能取到哪儿
            // 取1位
            copyPathList.add("" + s.charAt(index));
            dfs(s, index + 1, copyPathList);
            // 取2位
            if (index + 1 < s.length()) {
                dfs(s, index + 2, new ArrayList<String>(pathList) {
                    {
                        add(s.substring(index, index + 2));
                    }
                });
            }
            // 取3位 [0...255]
            if (index + 2 < s.length()) {
                if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '4')
                        || (s.charAt(index) == '2' && s.charAt(index + 1) == '5' && s.charAt(index + 2) <= '5'))
                    dfs(s, index + 3, new ArrayList<String>(pathList) {
                        {
                            add(s.substring(index, index + 3));
                        }
                    });
            }
        }
    }
}
// @lc code=end
