import leetcode.editor.cn.RemoveLinkedListElements.ListNode;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // 递归找到当前树的root节点
        return this.dfs(head);
    }

    private TreeNode dfs(ListNode head) {
        // 找到链表的中间节点为当前树的root
        // base case
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            // 只此一个节点 没有子树了
            return new TreeNode(head.val);
        }
        // 快慢指针 中间节点为下半区间
        // 前半截
        ListNode preHalf = head;
        // 后半截
        ListNode nextHalf = null;
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        nextHalf = slow.next;
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(preHalf);
        root.right = dfs(nextHalf);
        return root;
    }
}
// @lc code=end
