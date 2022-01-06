/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {

    private Map<Character, String[]> map = new HashMap<>();

    private List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0) return this.ret;
        if(this.map==null){
            this.map=new HashMap<>();
        }
        // init mapping
        this.map.put('2', new String[]{"a","b","c"});
        this.map.put('3', new String[]{"d","e","f"});
        this.map.put('4', new String[]{"g","h","i"});
        this.map.put('5', new String[]{"j","k","l"});
        this.map.put('6', new String[]{"m","n","o"});
        this.map.put('7', new String[]{"p","q","r","s"});
        this.map.put('8', new String[]{"t","u","v"});
        this.map.put('9', new String[]{"w","x","y","z"});
        
        this.dfs(digits, 0, "");
        return this.ret;
    }

    private void dfs(String digits, int idx, String path){
        if(idx==digits.length()){
            this.ret.add(new String(path));
            return;
        }
        String[] candidates = this.map.getOrDefault(digits.charAt(idx), null);
        if(candidates==null || candidates.length==0) return;
        for(String candidate: candidates){
            String pathCpy = new String(path);
            pathCpy+=candidate;
            this.dfs(digits, idx+1, pathCpy);
        }
    }
}
// @lc code=end

