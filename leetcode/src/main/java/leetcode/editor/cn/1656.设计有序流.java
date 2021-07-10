import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: dingrui
 * @Date: 2021-07-10 19:34:53
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-10 19:45:44
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=1656 lang=java
 *
 * [1656] 设计有序流
 */

// @lc code=start
class OrderedStream {

    int lastIndex = 1;
    boolean[] exists;
    Map<Integer, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public OrderedStream(int n) {
        this.exists = new boolean[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        exists[idKey] = true;
        map.put(idKey, value);
        // 将已经形成的有序结果输出
        this.res.clear();
        for (int i = this.lastIndex; i < this.exists.length; i++) {
            if (this.exists[i]) {
                this.res.add(this.map.get(i));
            } else {
                this.lastIndex = i;
                return this.res;
            }
        }
        return this.res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
// @lc code=end
