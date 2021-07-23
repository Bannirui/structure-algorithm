import java.util.List;
import java.util.Stack;

import leetcode.editor.cn.InvertBinaryTree.TreeNode;

/*
 * @Author: dingrui
 * @Date: 2021-07-22 18:21:00
 * @LastEditors: dingrui
 * @LastEditTime: 2021-07-23 15:25:00
 * @Descripttion: 
 */
/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
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

    public void recoverTree(TreeNode root) {
        // 进阶方案
        // root = this.recover(root);

        // 暴力方案
        // 中序遍历的结果
        List<Integer> inorderList = new ArrayList<>();
        this.inorder(root, inorderList);
        // 在中序遍历的结果中找降序的 第一组降序的第一个数 最右一组降序的第二个数
        Integer[] twoErrorNodeVal = this.findTwoErrorNodeVal(inorderList);
        this.fixTree(root, 2, twoErrorNodeVal[0], twoErrorNodeVal[1]);
        return;
    }

    // 普通方案
    // 中序遍历二叉树
    private void inorder(TreeNode root, List<Integer> list) {
        // base case
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // 数组中找降序就是错误的两个节点
    private Integer[] findTwoErrorNodeVal(List<Integer> inorderList) {
        Integer[] res = new Integer[2];
        for (int i = 0; i < inorderList.size() - 1; i++) {
            // i > i+1
            if (inorderList.get(i) > inorderList.get(i + 1)) {
                // 找到了一组
                res[0] = res[0] == null ? inorderList.get(i) : res[0];
                res[1] = inorderList.get(i + 1);
            }
        }
        return res;
    }

    // 恢复错误的二叉树
    private void fixTree(TreeNode head, int count, int e1, int e2) {
        // base case
        if (head == null) {
            return;
        }
        // 当前节点head
        if (head.val == e1 || head.val == e2) {
            // 找到了错误的节点 换成正确的值
            head.val = head.val == e1 ? e2 : e1;
            // 需要调整的节点数 已经调整完 就可以结束了
            if (--count == 0) {
                return;
            }
        }
        // 递归 子树
        fixTree(head.left, count, e1, e2);
        fixTree(head.right, count, e1, e2);
    }

    // --------------------------------------------------------------------
    // 进阶方案 moris中序遍历 原地修改二叉树节点

    // 返回数组里面2个错误的节点
    // 中序遍历过程中出现的降序
    private TreeNode[] getTwoErrorNode(TreeNode head) {
        // 中序遍历
        TreeNode[] errors = new TreeNode[2];
        // base case
        if (head == null) {
            return errors;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.val > head.val) {
                    // 出现了中序遍历时的相邻节点降序 说明是错误的节点
                    errors[0] = errors[0] == null ? pre : errors[0];
                    errors[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errors;
    }

    // 在head这个树中找到e1和e2这两个节点的父节点
    private TreeNode[] getTwoNodeParent(TreeNode head, TreeNode e1, TreeNode e2) {
        TreeNode[] parents = new TreeNode[2];
        if (head == null) {
            return parents;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.left == e1 || head.right == e1) {
                    // e1的父节点
                    parents[0] = head;
                }
                if (head.left == e2 || head.right == e2) {
                    // e2的父节点
                    parents[1] = head;
                }
                head = head.right;
            }
        }
        return parents;
    }

    // 调整二叉搜索树中两个错误的节点
    private TreeNode recover(TreeNode head) {
        // 找到两个错误的节点
        TreeNode[] errors = this.getTwoErrorNode(head);
        TreeNode e1 = errors[0];
        TreeNode e2 = errors[1];
        // 找到两个错误的节点的父节点
        TreeNode[] parents = this.getTwoNodeParent(head, e1, e2);
        TreeNode e1P = parents[0], e1L = e1.left, e1R = e1.right;
        TreeNode e2P = parents[1], e2L = e2.left, e2R = e2.right;
        if (e1 == head) {
            if (e1 == e2P) {
                // 情况1 e1是头 e1是e2的父 此时只可能e2是e1的右孩子
                e1.left = e2L;
                e1.right = e2R;
                e2.left = e1L;
                e2.right = e1;
            } else if (e2P.left == e2) {
                // 情况2 e1是头 e1不是e2的父 e2是e2P的左孩子
                e2P.left = e1;
                e2.left = e1L;
                e2.right = e1R;
                e1.left = e2L;
                e1.right = e2R;
            } else {
                // 情况3 e1是头 e1不是e2的父 e2是e2P的右孩子
                e2P.right = e1;
                e2.left = e1L;
                e2.right = e1R;
                e1.left = e2L;
                e1.right = e2R;
            }
            head = e2;
        } else if (e2 == head) {
            if (e2 == e1P) {
                // 情况4 e2是头 e2是e1的父 此时e1只可能是e2的左孩子
                e2.left = e1L;
                e2.right = e1R;
                e1.left = e2;
                e1.right = e2R;
            } else if (e1P.left == e1) {
                // 情况5 e2是头 e2不是e1的父 e1是e1P的左孩子
                e1P.left = e2;
                e1.left = e2L;
                e1.right = e2R;
                e2.left = e1L;
                e2.right = e1R;
            } else {
                // 情况6 e2是头 e2不是e1的父 e1是e1P的右孩子
                e1P.right = e2;
                e1.left = e2L;
                e1.right = e2R;
                e2.left = e1L;
                e2.right = e1R;
            }
            head = e1;
        } else {
            if (e1 == e2P) {
                if (e1P.left == e1) {
                    // 情况7 e1和e2都不是头 e1是e2的父 此时e2只可能是e1的右孩子 e1是e1P的左孩子
                    e1P.left = e2;
                    e1.left = e2L;
                    e1.right = e2R;
                    e2.left = e1L;
                    e2.right = e1;
                } else {
                    // 情况8 e1和e2都不是头 e1是e2的父 此时e2只可能是e1的右孩子 e1是e1P的右孩子
                    e1P.right = e2;
                    e1.left = e2L;
                    e1.right = e2R;
                    e2.left = e1L;
                    e2.right = e1;
                }
            } else if (e2 == e1P) {
                if (e2P.left == e2) {
                    // 情况9 e1和e2都不是头 e2是e1的父 此时e1只可能是e2的左孩子 e2是e2P的左孩子
                    e2P.left = e1;
                    e2.left = e1L;
                    e2.right = e1R;
                    e1.left = e2;
                    e1.right = e2R;
                } else {
                    // 情况10 e1和e2都不是头 e2是e1的父 此时e1只可能是e2的左孩子 e2是e2P的右孩子
                    e2P.right = e1;
                    e2.left = e1L;
                    e2.right = e1R;
                    e1.left = e2;
                    e1.right = e2R;
                }
            } else {
                if (e1P.left == e1) {
                    if (e2P.left == e2) {
                        // 情况11 e1和e2都不是头 谁也不是谁的父节点e1是e1P的左孩子 e2是e2P的左孩子
                        e1.left = e2L;
                        e1.right = e2R;
                        e2.left = e1L;
                        e2.right = e1R;
                        e1P.left = e2;
                        e2P.left = e1;
                    } else {
                        // 情况12 e1和e2都不是头 谁也不是谁的父节点e1是e1P的左孩子 e2是e2P的右孩子
                        e1.left = e2L;
                        e1.right = e2R;
                        e2.left = e1L;
                        e2.right = e1R;
                        e1P.left = e2;
                        e2P.right = e1;
                    }
                } else {
                    if (e2P.left == e2) {
                        // 情况13 e1和e2都不是头 谁也不是谁的父节点e1是e1P的右孩子 e2是e2P的左孩子
                        e1.left = e2L;
                        e1.right = e2R;
                        e2.left = e1L;
                        e2.right = e1R;
                        e1P.right = e2;
                        e2P.left = e1;
                    } else {
                        // 情况14 e1和e2都不是头 谁也不是谁的父节点e1是e1P的右孩子 e2是e2P的右孩子
                        e1.left = e2L;
                        e1.right = e2R;
                        e2.left = e1L;
                        e2.right = e1R;
                        e1P.right = e2;
                        e2P.right = e1;
                    }
                }
            }
        }
        return head;
    }
}

// @lc code=end
