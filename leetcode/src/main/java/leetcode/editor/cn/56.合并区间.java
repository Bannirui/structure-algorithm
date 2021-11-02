/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (arr1, arr2)->{
            if(arr1[0]==arr2[0]){
                return arr1[1]-arr2[1];
            }else{
                return arr1[0]-arr2[0];
            }
        });
        // 遍历
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] lastArr = list.get(list.size()-1);
            int[] curArr = intervals[i];
            if(curArr[0]>lastArr[1]){
                // 不需要合并
                list.add(curArr);
            }else{
                // 需要合并
                int R = Math.max(lastArr[1], curArr[1]);
                int lastIdx = list.size()-1;
                list.remove(lastIdx);
                list.add(new int[]{lastArr[0], R});
            }
        }
        // 结果
        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
// @lc code=end

