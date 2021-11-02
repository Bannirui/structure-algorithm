/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    // 数字跟字母之间的映射
    private Map<Character, List<String>> map;

    // 结果集
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 数字跟字母之间的映射
        this.map = new HashMap<Character, List<String>>();
        map.put('2', new ArrayList<String>(){{
            add("a");
            add("b");
            add("c");
        }});
        map.put('3', new ArrayList<String>(){{
            add("d");
            add("e");
            add("f");
        }});
        map.put('4', new ArrayList<String>(){{
            add("g");
            add("h");
            add("i");
        }});
        map.put('5', new ArrayList<String>(){{
            add("j");
            add("k");
            add("l");
        }});
        map.put('6', new ArrayList<String>(){{
            add("m");
            add("n");
            add("o");
        }});
        map.put('7', new ArrayList<String>(){{
            add("p");
            add("q");
            add("r");
            add("s");
        }});
        map.put('8', new ArrayList<String>(){{
            add("t");
            add("u");
            add("v");
        }});
        map.put('9', new ArrayList<String>(){{
            add("w");
            add("x");
            add("y");
            add("z");
        }});
        // dfs
        this.dfs(digits, 0, "");
        return this.res;
    }


    private void dfs(String s, int idx, String path){
        // base case
        if(idx==s.length()){
            // 收集结果 排除空串
            if(path.length()!=0){
                this.res.add(new String(path));
            }
            return;
        }
        // 当前遍历到s中idx字符 对应的字母选择
        List<String> letters = this.map.get(s.charAt(idx));
        if(letters==null||letters.isEmpty()){
            // todo 题目限制了这种情况不可能发生
        }else{
            for(String letter: letters){
                String newPath = new String(path);
                newPath += letter;
                this.dfs(s, idx+1, newPath);
            }
        }
    }
}
// @lc code=end

