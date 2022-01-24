/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s==null||s.length()<4||s.length()>12) return Collections.emptyList();
        List<List<Integer>> ret = new ArrayList<>();
        this.dfs(s,0,new ArrayList<>(),ret);
        return ret.stream()
            .map(
                l->l.stream().map(String::valueOf).collect(Collectors.joining("."))
            )
            .collect(Collectors.toList());
    }

    private void dfs(String s, int idx, List<Integer> path, List<List<Integer>> ret){
        if(idx>=s.length()){
            if(path.size()==4) ret.add(new ArrayList<>(path));
            return;
        }
        if(path.size()>=4) return;
        char ch = s.charAt(idx);
        if(ch!='0'){
            int sum=0;
            for(int i=0;i<3;i++){
                if(idx+i>=s.length()) break;
                sum=sum*10+(s.charAt(idx+i)-'0');
                if(sum>255) break;
                List<Integer> pathCpy=new ArrayList<>(path);
                pathCpy.add(sum);
                this.dfs(s,idx+i+1,pathCpy,ret);
            }
        }else{ // 不能前导0
            List<Integer> pathCpy=new ArrayList<>(path);
            pathCpy.add(0);
            this.dfs(s,idx+1,pathCpy,ret);
        }
    }
}
// @lc code=end

