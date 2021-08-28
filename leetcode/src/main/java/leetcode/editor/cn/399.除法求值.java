import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
class Solution {

    private class UnionFind {
        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.weight[i] = 1.0D;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = this.find(x);
            int rootY = this.find(y);
            if (rootX == rootY) {
                return;
            }
            this.parent[rootX] = rootY;
            this.weight[rootX] = this.weight[y] * value / this.weight[x];
        }

        public double isConnected(int x, int y) {
            int rootX = this.find(x);
            int rootY = this.find(y);
            if (rootX == rootY) {
                return this.weight[x] / this.weight[y];
            } else {
                return -1.0D;
            }
        }

        private int find(int x) {
            if (x != this.parent[x]) {
                int origin = this.parent[x];
                this.parent[x] = this.find(origin);
                this.weight[x] *= this.weight[origin];
            }
            return this.parent[x];
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2 * equationsSize);
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }
}
// @lc code=end
