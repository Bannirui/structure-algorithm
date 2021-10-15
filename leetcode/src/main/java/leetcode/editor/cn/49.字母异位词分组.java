import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();
        // 挑出所有的异位词
        for (String str : strs)
        {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            // 异位词 字典序
            String newStr = new String(strArr);
            if (!map.containsKey(newStr))
            {
                List<String> strList = new ArrayList<String>()
                {
                    {
                        add(str);
                    }
                };
                map.put(newStr, strList);
            }
            else
            {
                map.get(newStr).add(str);
            }
        }
        // 收集
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            res.add(entry.getValue());
        }
        return res;
    }
}
// @lc code=end
