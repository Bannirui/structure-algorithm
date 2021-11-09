/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        // 实例化并查集
        UnionFind uf = new UnionFind(size*2);
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        for(int i=0; i<size; i++){
            List<String> equation = equations.get(i);
            String v1 = equation.get(0);
            String v2 = equation.get(1);
            if(!map.containsKey(v1)){
                map.put(v1, id);
                id++;
            }
            if(!map.containsKey(v2)){
                map.put(v2, id);
                id++;
            }
            uf.union(map.get(v1), map.get(v2), values[i]);
        }

        // 查询
        int querySize = queries.size();
        double[] res = new double[querySize];
        for(int i=0; i<querySize; i++){
            String v1 = queries.get(i).get(0);
            String v2 = queries.get(i).get(1);
            Integer id1 = map.get(v1);
            Integer id2 = map.get(v2);
            if(id1==null || id2==null){
                // 至少有一个不存在的因子
                res[i] =  -1.0D;
            }else{
                // 两个因子都存在
                res[i] = uf.isConnected(id1, id2);
            }
        }
        return res;
    }

    // 并查集
    private static class UnionFind{
        private int[] parent;
        private double[] weight;

        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for(int i=0;i<n;i++){
                this.parent[i] = i;
                this.weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value){
            int rootX = this.find(x);
            int rootY = this.find(y);
            if(rootX == rootY){
                return;
            }
            this.parent[rootX] = rootY;
            this.weight[rootX] = value*(this.weight[y]/this.weight[x]);
        }

        public int find(int x){
            if(x != this.parent[x]){
                int origin = this.parent[x];
                this.parent[x] = find(origin);
                this.weight[x]*=this.weight[origin];
            }
            return this.parent[x];
        }

        public double isConnected(int x, int y){
            int rootX = this.find(x);
            int rootY = this.find(y);
            if(rootX==rootY){
                return this.weight[x]/this.weight[y];
            }else{
                return -1.0D;
            }
        }
    }
}
// @lc code=end

