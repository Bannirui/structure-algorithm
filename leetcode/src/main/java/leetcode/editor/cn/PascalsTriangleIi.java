package leetcode.editor.cn;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 216 👎 0

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        // solution.getRow(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            // 暴力解法 生成二维列表 取出第k个
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < rowIndex+1; ++i) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                    }
                }
                res.add(row);
            }
            return res.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}