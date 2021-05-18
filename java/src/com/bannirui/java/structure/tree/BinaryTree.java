package com.bannirui.java.structure.tree;

/**
 *@author dingrui
 *@date 2020-11-30
 *@description 二叉树
 */
public class BinaryTree {

	/**
	 * 二叉树根节点
	 */
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/30
	 * @return
	 * @description 前序遍历
	 */
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/30
	 * @return
	 * @description 中序遍历
	 */
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/30
	 * @return
	 * @description 后续遍历
	 */
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		}
	}

	public static void main(String[] args) {
		HeroNode node1 = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(1, "吴用");
		HeroNode node3 = new HeroNode(1, "卢俊义");
		HeroNode node4 = new HeroNode(1, "林冲");
		HeroNode node5 = new HeroNode(1, "关胜");

		node1.setLeft(node2);
		node1.setRight(node3);
		node3.setLeft(node5);
		node3.setRight(node4);

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.setRoot(node1);

		System.out.println("前序遍历");
		binaryTree.preOrder();

		System.out.println("中序遍历");
		binaryTree.infixOrder();

		System.out.println("后序遍历");
		binaryTree.postOrder();
	}
}

/**
 * @author dingrui
 * @date 2020-11-30
 * @description 二叉树的节点
 */
class HeroNode {

	/**
	 * 编号
	 */
	private Integer no;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 左子树
	 */
	private HeroNode left;

	/**
	 * 右子树
	 */
	private HeroNode right;

	/**
	 * @author dingrui
	 * @date 2020-11-30
	 * @description 构造器
	 */
	public HeroNode(Integer no, String name) {
		this.no = no;
		this.name = name;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				'}';
	}

	// ------------- 树的遍历 -------------

	/**
	 * @author dingrui
	 * @date 2020/11/30
	 * @return
	 * @description 前序遍历
	 */
	public void preOrder() {
		// 先输出父节点
		System.out.println(this);
		// 左子树递归
		if (this.left != null) {
			this.left.preOrder();
		}
		// 右子树递归
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/30
	 * @return
	 * @description 中序遍历
	 */
	public void infixOrder() {
		// 左子树递归
		if (this.left != null) {
			this.left.infixOrder();
		}
		// 输出父节点
		System.out.println(this);
		// 右子树递归
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/30
	 * @return
	 * @description 后续遍历
	 */
	public void postOrder() {
		// 右子树递归
		if (this.left != null) {
			this.left.postOrder();
		}
		// 左子树递归
		if (this.right != null) {
			this.right.postOrder();
		}
		// 输出父节点
		System.out.println(this);
	}
}
