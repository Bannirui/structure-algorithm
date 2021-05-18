**思路**
俗话说，**爆搜挂着机，打表得省一。**
这手表一共才 *10* 个灯，用深搜枚举各个灯的情况，搜索空间仅 *2^{10}*。眼睛一闭一睁就跑完了。

**参考代码**
```c++
int n;
bool w[10]; // 前4位是时间，后6位是分钟
vector<string>ans;
void dfs(int idx){
    if(idx==10){ // 10个灯
        int h=(w[0]<<3)+(w[1]<<2)+(w[2]<<1)+w[3];
        int m=(w[4]<<5)+(w[5]<<4)+(w[6]<<3)+(w[7]<<2)+(w[8]<<1)+w[9];
        //如果时间分钟溢出 或者不是n个灯亮着
        if(h>=12||m>=60||w[0]+w[1]+w[2]+w[3]+w[4]+w[5]+w[6]+w[7]+w[8]+w[9]!=n)return;

        if(m>=10)ans.push_back(to_string(h)+":"+to_string(m));
        else ans.push_back(to_string(h)+":0"+to_string(m));
        return;
    }
    w[idx]=true;
    dfs(idx+1);
    w[idx]=false;
    dfs(idx+1);
}
class Solution {
public:
    vector<string> readBinaryWatch(int _n) {
        ans.clear();
        n=_n;
        dfs(0);
        return ans;
    }
};
```

**复杂度分析**
- 时间复杂度：*O(2^n)*，此处 *n=10*
- 空间复杂度：*O(n)*，此处 *n=10*