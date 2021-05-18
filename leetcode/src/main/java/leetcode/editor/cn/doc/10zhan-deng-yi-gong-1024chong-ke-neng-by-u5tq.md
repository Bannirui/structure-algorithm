
### 代码

```cpp
class Solution {
private:
    vector<string> ans;
public:
    int oneCnt(int i){ // 计算‘1’个数
        int cnt = 0;
        while(i > 0){
            cnt++;
            i &= i - 1;
        }
        return cnt;
    }
    vector<string> readBinaryWatch(int num) {
        for(int i = 0; i < 1024; ++i){
            if(oneCnt(i) == num){ // 如果‘1’个数刚好等于num
                int hour = i >> 6; // 高4位是hour
                int minute = i & 0x3F; // 低6位是minute
                if(hour >= 12 || minute >= 60) continue;
                string ret = to_string(hour) + ':';
                if(minute < 10) ret += '0';
                ret += to_string(minute);
                ans.push_back(ret);
            }
        }
        return ans;
    }
};
```
时间复杂度：O(nx)
空间复杂度：O(1)