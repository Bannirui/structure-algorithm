package leetcode.editor.cn;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 437 👎 0

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        // solution.generate(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 后面问题依赖前面的结果 有点像递归 如果是递归就要找逼近条件、大问题转小问题
            // 两边都是1
            // 第3行第2个元素 list2[1]=list1[0]+list1[1]
            // 第4行第2个元素 list3[1]=list2[0]+list2[1]
            // 第4行第3个元素 list3[2]=list2[1]+list2[2]
            // 第5行第2个元素 list4[1]=list3[0]+list3[1]
            // 第5行第3个元素 list4[2]=list3[1]+list3[2]
            List<List<Integer>> res = new ArrayList<>();
            // numRows是非负整数 如果等于0就不走下面逻辑 直接return了
            for (int rowIndex = 1; rowIndex <= numRows; rowIndex++) {
                // 每一行
                List<Integer> row = new ArrayList<>();
                for (int colIndex = 0; colIndex < rowIndex; colIndex++) {
                    if (colIndex == 0 || colIndex == rowIndex - 1) {
                        row.add(1);
                    } else {
                        // 当前索引就是colIndex
                        row.add(res.get(rowIndex - 1-1).get(colIndex - 1) + res.get(rowIndex - 1-1).get(colIndex));
                    }
                }
                res.add(row);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}