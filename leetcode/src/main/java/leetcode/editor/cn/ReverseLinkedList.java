package leetcode.editor.cn;

//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1638 👎 0

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            // 单链表的翻转 链表遍历放栈再取出来
            if (head == null) {
                return null;
            }
            Stack<Integer> stack = new Stack<>();
            ListNode cur = head;
            while (cur != null) {
                stack.push(cur.val);
                cur = cur.next;
            }
            ListNode cur2 = head;
            while (cur2 != null) {
                cur2.val = stack.pop();
                cur2 = cur2.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
