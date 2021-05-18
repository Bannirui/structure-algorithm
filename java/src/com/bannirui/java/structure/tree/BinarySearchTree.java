package com.bannirui.java.structure.tree;

/**
 *@author dingrui
 *@date 2020-12-07
 *@description BST 二叉查找树
 */
public class BinarySearchTree {
	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
		BinarySearchTree bst = new BinarySearchTree();
		// 遍历添加树节点
		for (int i : arr) {
			bst.add(new BSTNode(i));
		}

		// 中序遍历树
		System.out.println("创建节点之后：");
		bst.infixOrder();

		// 删除节点
		bst.delete(2);
		System.out.println("删除节点之后：");
		bst.infixOrder();

		System.out.println();
	}

	private BSTNode root;

	/**
	 * @author dingrui
	 * @date 2020/12/7
	 * @param node
	 * @return
	 * @description 添加节点
	 */
	public void add(BSTNode node) {
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
	public BSTNode search(int value) {
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
	public BSTNode searchParent(int value) {
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
	public int delRightTreeMin(BSTNode node) {
		BSTNode target = node;
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
			BSTNode targetNode = search(value);
			if (targetNode == null) {
				return;
			} else {
				// BST只有一个root节点
				if (root.left == null && root.right == null) {
					root = null;
					return;
				}

				// 找tartgetNode的父节点
				BSTNode parent = searchParent(value);
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
class BSTNode {
	int value;
	BSTNode left;
	BSTNode right;

	public BSTNode(int value) {
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
	 * @param node
	 * @return
	 * @description 递归添加节点，满足BST要求：做节点<当前节点<右子节点
	 */
	public void add(BSTNode node) {
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
	public BSTNode search(int value) {
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
	public BSTNode searchParent(int value) {
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
