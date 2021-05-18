package com.bannirui.java.structure.linkedList;

/**
 *@author dingrui
 *@date 2020-11-16
 *@description : 节点实体
 */
class DoubleLinkedListNode {
	/**
	 * 编号
	 */
	public int no;

	/**
	 * 姓名
	 */
	public String name;

	/**
	 * 昵称
	 */
	public String nickName;

	/**
	 * pre指针
	 */
	public DoubleLinkedListNode pre;

	/**
	 * next指针
	 */
	public DoubleLinkedListNode next;

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @return
	 * @description: 构造器
	 */
	public DoubleLinkedListNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @return
	 * @description: 构造器
	 */
	public DoubleLinkedListNode() {
	}

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @return
	 * @description: toString
	 */
	@Override
	public String toString() {
		return "HeroNode{" +
				"no=" + no +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				'}';
	}
}

/**
 *@author dingrui
 *@date 2020-11-16
 *@description : 双向链表
 */
public class DoubleLinkedList {
	/**
	 * 定义一个头节点 不存储任何数据 仅仅表明是链表的头节点
	 */
	private final DoubleLinkedListNode head = new DoubleLinkedListNode();

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @return
	 * @description: 获取双向链表的头节点
	 */
	public DoubleLinkedListNode getHead() {
		return head;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @return
	 * @description: 遍历双向链表
	 */
	public void list() {
		// 定义临时节点
		DoubleLinkedListNode tmp = head.next;
		while (tmp != null) {
			System.out.println(tmp);
			tmp = tmp.next;
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @param node
	 * @return
	 * @description: 添加节点到最后
	 */
	public int addToLast(DoubleLinkedListNode node) {
		// 找到最后一个节点 挂到最后
		DoubleLinkedListNode tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = node;
		node.pre = tmp;
		return node.no;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @param node
	 * @return
	 * @description: 根据节点进行更新
	 */
	public int updateByNode(DoubleLinkedListNode node) {
		// 找当前节点
		// 判断当前链表不为空
		DoubleLinkedListNode tmp = head.next;
		// 是否找到节点 标识位
		boolean findNode = false;
		while (tmp != null) {
			if (tmp.no == node.no) {
				findNode = true;
				break;
			}
			tmp = tmp.next;
		}

		if (findNode) {
			tmp.name = node.name;
			tmp.nickName = node.nickName;
			return tmp.no;
		}
		return -1;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @param no
	 * @return
	 * @description: 根据节点no进行删除节点
	 */
	public int deleteByNodeNumber(int no) {
		// 找到待删除的节点
		DoubleLinkedListNode tmp = head.next;
		// 是否找到待删除节点 标识符
		boolean findNode = false;
		while (tmp != null) {
			if (tmp.no == no) {
				findNode = true;
				break;
			}
			tmp = tmp.next;
		}

		if (findNode) {
			tmp.pre.next = tmp.next;
			if (tmp.next != null) {
				tmp.next.pre = tmp.pre;
			}
			return tmp.no;
		}
		return -1;
	}

	// ---------------------- 手动分割 ----------------------

	public static void main(String[] args) {
		// 创建一个链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

		// 创建节点
		DoubleLinkedListNode songjiang = new DoubleLinkedListNode(1, "宋江", "及时雨");
		DoubleLinkedListNode lujunyi = new DoubleLinkedListNode(2, "卢俊义", "玉麒麟");
		DoubleLinkedListNode wuyong = new DoubleLinkedListNode(3, "吴用", "智多星");

		// 添加节点 元素追加到链表尾部
		doubleLinkedList.addToLast(songjiang);
		doubleLinkedList.addToLast(lujunyi);
		doubleLinkedList.addToLast(wuyong);

		System.out.println("元素追加到链表尾部");
		doubleLinkedList.list();

		System.out.println("当前链表头节点");
		System.out.println(doubleLinkedList.getHead());

		System.out.println("删除1号");
		System.out.println(doubleLinkedList.deleteByNodeNumber(1));

		System.out.println("删除之后链表");
		doubleLinkedList.list();

		DoubleLinkedListNode lujunyi2 = new DoubleLinkedListNode(2, "卢俊义2", "玉麒麟2");
		System.out.println("更新2号");
		System.out.println(doubleLinkedList.updateByNode(lujunyi2));

		System.out.println("更新之后链表");
		doubleLinkedList.list();
	}
}
