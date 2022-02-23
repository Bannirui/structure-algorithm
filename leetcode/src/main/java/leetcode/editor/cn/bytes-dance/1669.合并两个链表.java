/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1==null || list2==null || a<0 || b<a) throw new IllegalArgumentException();
        // [...a) [a...b] (b...]
        ListNode dummy = new ListNode(0, list1);
        ListNode l = dummy;
        int cnt=a;
        while(cnt>0) {
            l=l.next;
            if(l==null) throw new IllegalArgumentException();
            cnt--;
        }
        ListNode r=l;
        cnt=b-a+1;
        while(cnt>0){
            r=r.next;
            if(r==null) throw new IllegalArgumentException();
            cnt--;
        }
        if(r==null) throw new IllegalArgumentException();
        r=r.next;
        ListNode cur2=list2;
        while(cur2.next!=null) cur2=cur2.next;
        l.next=list2;
        cur2.next=r;
        return dummy.next;
    }
}
// @lc code=end

