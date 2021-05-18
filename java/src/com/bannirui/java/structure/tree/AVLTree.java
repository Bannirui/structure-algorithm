package com.bannirui.java.structure.tree;

/**
 *@author dingrui
 *@date 2020-12-07
 *@description AVL 平衡二叉搜索树
 */
public class AVLTree {
	public static void main(String[] args) {
		// int[] arr = {10, 12, 8, 9, 7, 6};
		int[] arr = {10, 11, 7, 6, 8, 9};
		// 创建avl树
		AVLTree avlTree = new AVLTree();
		// 添加avl树的节点
		for (int i : arr) {
			avlTree.add(new AVLNode(i));
		}
		// avl树遍历
		avlTree.infixOrder();
		int height = avlTree.root.height();
		int leftHeight = avlTree.root.leftHeight();
		int rightHeight = avlTree.root.rightHeight();
		AVLNode root = avlTree.getRoot();

		System.out.println();
	}

	private AVLNode root;

	public AVLNode getRoot() {
		return root;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param node
	 * @return
	 * @description 添加节点
	 */
	public void add(AVLNode node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description 中序遍历
	 */
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param value
	 * @return
	 * @description 查找值对应的节点
	 */
	public AVLNode search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param value
	 * @return
	 * @description 查找值对应节点的父节点
	 */
	public AVLNode searchParent(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param node 传入的BST的节点
	 * @return
	 * @description 删除以node为根节点的BST的最小节点的值，并返回
	 */
	public int delRightTreeMin(AVLNode node) {
		AVLNode target = node;
		// 因为BST的特点是左子树的值<当前节点的值<右子树的值 因此BST的最小值就在左子树叶子节点
		while (target.left != null) {
			target = target.left;
		}
		// 删除这个节点
		delete(target.value);
		return target.value;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param value
	 * @return
	 * @description 删除一个节点
	 */
	public void delete(int value) {
		if (root == null) {
			return;
		} else {
			// 需要删除的节点
			AVLNode targetNode = search(value);
			if (targetNode == null) {
				return;
			} else {
				// BST只有一个root节点
				if (root.left == null && root.right == null) {
					root = null;
					return;
				}

				// 找tartgetNode的父节点
				AVLNode parent = searchParent(value);
				if (targetNode.left == null && targetNode.right == null) {
					// targetNode是叶子节点 判断targetNode是parent的左子节点还是右子节点
					if (parent.left != null && parent.left.value == value) {
						// 要删除的节点是parent的左子节点
						parent.left = null;
					} else if (parent.right != null && parent.right.value == value) {
						// 要删除的节点是parent的右子节点
						parent.right = null;
					}
				} else if (targetNode.left != null && targetNode.right != null) {
					// targetNode是有两个子节点的节点
					int min = delRightTreeMin(targetNode);
					targetNode.value = min;
				} else {
					// targetNode是有一个子节点的节点
					if (targetNode.left != null) {
						// targetNode有左子节点
						if (parent.left.value == value) {
							parent.left = targetNode.left;
						} else {
							parent.right = targetNode.left;
						}
					} else {
						// targetNode有右子节点
						if (parent.left.value == value) {
							parent.left = targetNode.right;
						} else {
							parent.right = targetNode.right;
						}
					}
				}
			}
		}
	}
}

/**
 * @author dingrui
 * @date 2020-12-07
 * @description 节点
 */
class AVLNode {
	int value;
	AVLNode left;
	AVLNode right;

	public AVLNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description 返回当前节点的高度
	 * 以该节点为根节点的树的高度
	 */
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description 左子树的高度
	 */
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description 右子树的高度
	 */
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description AVL树左旋转
	 */
	private void leftRotate() {
		// 创建新的节点 新节点的值设置为当前根节点的值
		AVLNode newNode = new AVLNode(value);
		// 把新节点的左子树设置成当前节点的左子树
		newNode.left = left;
		// 把新节点的右子树设置成当前节点的右子树的左子树
		newNode.right = right.left;
		// 把当前节点的值替换成右子节点的值
		value = right.value;
		// 把当前节点的右子树设置成当前节点右子树的右子树
		right = right.right;
		// 把当前节点的左子树设置成新的节点
		left = newNode;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description AVL树右旋转
	 */
	private void rightRotate() {
		// 创建新的节点 新节点的值设置为当前根节点的值
		AVLNode newNode = new AVLNode(value);
		// 把新节点的右子树设置成当前节点的右子树
		newNode.right = right;
		// 把新节点的左子树设置成当前节点的左子树的右子树
		newNode.left = left.right;
		// 把当前节点的值替换成左子节点的值
		value = left.value;
		// 把当前节点的左子树设置成当前节点左子树的左子树
		left = left.left;
		// 把当前节点的右子树设置成新的节点
		right = newNode;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param node
	 * @return
	 * @description 递归添加节点，满足BST要求：做节点<当前节点<右子节点
	 */
	public void add(AVLNode node) {
		if (node == null) {
			return;
		}
		if (node.value < this.value) {
			// 新增节点的值小于当前节点的值
			if (this.left == null) {
				// 当前节点没有左节点 直接将新增节点挂到左节点
				this.left = node;
			} else {
				// 向左节点递归
				this.left.add(node);
			}
		} else {
			// 新增节点的值大于当前节点的值
			if (this.right == null) {
				// 当前节点没有右子节点 直接将新增节点挂到右节点
				this.right = node;
			} else {
				// 向右节点递归
				this.right.add(node);
			}
		}

		// 添加完一个节点之后 判断是否需要进行左旋转 (右子树高度-左子树高度)>1
		if (rightHeight() - leftHeight() > 1) {
			if (right!=null&&right.leftHeight()>right.rightHeight()){
				// 右子树的左子树高度大于右子树的右子树高度 先对右子树节点进行右旋转 再对当前节点进行左旋转
				right.rightRotate();
				leftRotate();
			}else{
				leftRotate();
			}
			return;
		}

		// 添加完一个节点之后 判断是否需要进行右旋转 (左子树高度-右子树高度)>1
		if (leftHeight() - rightHeight() > 1) {
			if (left!=null&&left.rightHeight()>left.leftHeight()){
				// 如果现在左子树的右子树高度大于左子树的左子树高度 左子树先左旋转
				left.leftRotate();
				rightRotate();
			}else{
				// 直接右旋转
				rightRotate();
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @return
	 * @description 中序遍历
	 */
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param value
	 * @return
	 * @description 根据值查找节点
	 */
	public AVLNode search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			} else {
				return this.left.search(value);
			}
		} else {
			if (this.right == null) {
				return null;
			} else {
				return this.right.search(value);
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param value 需要查找的值
	 * @return 如果没有就返回null
	 * @description 查找值对应节点的父节点
	 */
	public AVLNode searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if (value >= this.value && this.right != null) {
				return this.right.searchParent(value);
			} else {
				return null;
			}
		}
	}
}