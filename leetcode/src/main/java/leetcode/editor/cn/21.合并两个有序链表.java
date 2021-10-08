/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        // base case
        if (l1 == null && l2 == null)
        {
            return null;
        }
        // 哑节点
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null || l2 != null)
        {
            Integer curNodeValue = null;
            if (l1 == null)
            {
                if (l2 == null)
                {
                    // ignore
                }
                else
                {
                    curNodeValue = l2.val;
                    l2 = l2.next;
                }
            }
            else
            {
                if (l2 == null)
                {
                    curNodeValue = l1.val;
                    l1 = l1.next;
                }
                else
                {
                    // bot not null
                    if (l1.val <= l2.val)
                    {
                        curNodeValue = l1.val;
                        l1 = l1.next;
                    }
                    else
                    {
                        curNodeValue = l2.val;
                        l2 = l2.next;
                    }
                }
            }
            cur.next = new ListNode(curNodeValue);
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end
