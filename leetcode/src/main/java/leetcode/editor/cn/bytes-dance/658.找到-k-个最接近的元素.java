/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len=0;
        if(arr==null || (len=arr.length)==0) throw new IllegalArgumentException();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        if(x<=arr[0]) return list.subList(0, k);
        else if(x>=arr[len-1]) return list.subList(len-k, len);
        int index = Collections.binarySearch(list, x);
        if(index<=0) index=-index-1;
        int lo=Math.max(index-k+1,0);
        int hi=Math.min(index+k-1,len-1);
        while(hi-lo+1>k){
            int loVal=arr[lo];
            int hiVal=arr[hi];
            int midVal=arr[index];
            if(midVal-loVal<=hiVal-midVal) hi--;
            else lo++;
        }
        return list.subList(lo, hi+1);
    }
}
// @lc code=end

