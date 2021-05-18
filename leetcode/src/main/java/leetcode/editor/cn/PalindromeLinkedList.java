package leetcode.editor.cn;

//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 916 👎 0

import java.util.Objects;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            if (head != null && head.next == null) {
                return true;
            }
            // 单链表 堆成成对抵消 栈
            Stack<Integer> stack = new Stack<>();
            ListNode cur = head;
            while (cur != null) {
                if (!stack.isEmpty() && Objects.equals(stack.peek(), cur.val)) {
                    // 已经出现了成对的可以抵消的
                    stack.pop();
                } else {
                    stack.push(cur.val);
                }
                cur = cur.next;
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
