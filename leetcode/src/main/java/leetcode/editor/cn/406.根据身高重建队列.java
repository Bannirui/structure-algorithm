/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 身高升序 排次降序
        Arrays.sort(people, (p1, p2)->{
            if(p1[0]!=p2[0]){
                return p1[0]-p2[0];
            }else{
                // 身高相同
                return p2[1]-p1[1];
            }
        });
        int[][] res = new int[people.length][];
        // 遍历
        for(int[] person: people){
            // 预留的空位置
            int space = person[1]+1;
            for(int i=0;i<people.length;i++){
                if(res[i]==null){
                    // 预留的空位置
                    space--;
                }
                if(space==0){
                    // 当前元素
                    res[i] = person;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

