package leetcode.editor.cn;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 445 👎 0

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

        // ListNode listNode1 = new ListNode(1);
        // ListNode listNode2 = new ListNode(1);
        // ListNode listNode3 = new ListNode(2);
        // ListNode listNode4 = new ListNode(3);
        // ListNode listNode5 = new ListNode(3);
        // listNode4.next = listNode5;
        // listNode3.next = listNode4;
        // listNode2.next = listNode3;
        // listNode1.next = listNode2;

        // ListNode listNode = solution.deleteDuplicates(listNode1);

        // System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 记录以前pre cur 遍历链表
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.next.val == cur.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}