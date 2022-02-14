/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1=this.area(ax1,ay1,ax2,ay2);
        int area2=this.area(bx1,by1,bx2,by2);
        if(by1>=ay2 || by2<=ay1||bx2<=ax1||bx1>=ax2) return area1+area2;
        else{
            int cx1=Math.max(ax1,bx1);
            int cy1=Math.max(ay1,by1);
            int cx2=Math.min(ax2,bx2);
            int cy2=Math.min(ay2,by2);
            int region = this.area(cx1,cy1,cx2,cy2);
            return area1+area2-region;
        }
    }

    private int area(int x1, int y1, int x2, int y2){
        if(x1>x2 || y1>y2) throw new IllegalArgumentException();
        if(x1==x2 || y1==y2) return 0;
        return (x2-x1)*(y2-y1);
    }
}
// @lc code=end

