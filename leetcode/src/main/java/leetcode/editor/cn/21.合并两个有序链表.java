/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // base case
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        // 链表有序
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l1!=null || l2!=null){
            if(l1==null){
                // l1遍历完 l2剩余节点
                cur.next=l2;
                break;
            } else if(l2==null){
                // l2遍历完 l1剩余节点
                cur.next=l1;
                break;
            }else{
                // l1 l2都没有遍历完
                int v1 = l1.val;
                int v2 = l2.val;
                if(v1<=v2){
                    // 使用l1节点
                    cur.next=new ListNode(v1);
                    l1=l1.next;
                    cur=cur.next;
                }else{
                    // 使用l2节点
                    cur.next=new ListNode(v2);
                    l2=l2.next;
                    cur=cur.next;
                }
            }
        }
        return dummy.next;
    }
}
// @lc code=end

