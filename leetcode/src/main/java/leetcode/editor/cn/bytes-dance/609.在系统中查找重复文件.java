/*
 * @lc app=leetcode.cn id=609 lang=java
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        if(paths==null || paths.length==0) return Collections.emptyList();
        // key=content val=path
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            // root file...
            String[] relateivePaths = path.split(" ");
            String root = relateivePaths[0];
            // all file
            for(int i=1,len=relateivePaths.length;i<len;i++){
                String[] nameWithContent = relateivePaths[i].split("\\(");
                String absPath = root+"/"+nameWithContent[0];
                String content = nameWithContent[1].replace(")","");
                List<String> l = map.getOrDefault(content, new ArrayList<String>());
                l.add(absPath);
                map.put(content,l);
            }
        }

        List<List<String>> ret = new ArrayList<>();
        for(String k: map.keySet()){
            List<String> val = map.get(k);
            if(val.size()>1) ret.add(val);
        }
        return ret;
    }
}
// @lc code=end

