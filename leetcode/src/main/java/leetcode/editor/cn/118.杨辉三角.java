import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三
 */

// @lc code=start
class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        // base case
        if (numRows == 1)
        {
            return new ArrayList<List<Integer>>()
            {
                {
                    List<Integer> level = new ArrayList<Integer>()
                    {
                        {
                            add(1);
                        }
                    };
                    add(level);
                }
            };
        }
        // 第numRows层
        List<List<Integer>> preLevels = this.generate(numRows - 1);
        List<Integer> lastLevel = preLevels.get(preLevels.size() - 1);
        List<Integer> curLevel = new ArrayList<>();
        // 左边界
        curLevel.add(1);
        for (int i = 1; i < numRows - 1; i++)
        {
            curLevel.add(lastLevel.get(i - 1) + lastLevel.get(i));
        }
        // 右边界
        curLevel.add(1);
        // 最新的一层加到结果中
        return new ArrayList<List<Integer>>(preLevels)
        {
            {
                add(curLevel);
            }
        };
    }
}
// @lc code=end
