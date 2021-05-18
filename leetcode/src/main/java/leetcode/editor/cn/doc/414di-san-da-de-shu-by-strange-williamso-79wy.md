# 414第三大的数
自己写的，比不上一些大佬，适合新手看看（当然我也是个新手加菜鸟）
我是借助数据结构的ArrayList容器,贴上代码，哈哈，第一次写题解，文采和知识储备都不够


    
```
 public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        
        for(int i:nums){
            if(ans.contains(i)){
                continue;
            }
            ans.add(i);
        }

        int n = ans.size();
        if(n==1 || n==2){
            return ans.get(n-1);
        }

        return ans.get(ans.size()-3);
    }

```

