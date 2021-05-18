package com.bannirui.java.structure.linkedList;

/**
 *@author dingrui
 *@date 2020-11-16
 *@description : 单向环形链表 解决约瑟夫问题
 */
public class SingleCircleLinkedList {

	private Node head;

	public SingleCircleLinkedList() {
	}

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @param nums
	 * @return
	 * @description: 创建环形链表
	 */
	public int create(int nums) {
		// 参数校验
		if (nums >= 1) {
			// 定义临时节点
			Node cur = null;
			for (int i = 1; i <= nums; i++) {
				Node node = new Node(i);
				// 构建头节点特殊处理
				if (i == 1) {
					this.head = node;
					node.setNext(this.head);
					cur = head;
				} else {
					cur.setNext(node);
					node.setNext(head);
					cur = node;
				}
			}
			return nums;
		}
		return -1;
	}

	public void list() {
		// 头节点不动 创建一个临时节点
		Node cur = this.head;
		if (cur != null) {
			// 否则遍历打印出来
			while (true) {
				System.out.println(cur);
				if (cur.getNext() == head) {
					break;
				}
				cur = cur.getNext();

			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/16
	 * @param start 从第几个小孩开始报数
	 * @param step 每次报几个数字
	 * @param total 总共多少个小孩
	 * @return
	 * @description: 约瑟夫问题
	 */
	public void count(int start, int step, int total) {
		// 参数校验
		if (start < 1 || step > total || step < 1) {
			System.out.println("参数不合理");
		} else {
			// 现在头节点就是head
			// 定义一个辅助变量节点
			Node helper = this.head;
			// 把helper移动到first的前一个节点 然后不断的根据step开始同时移动step-1个节点
			while (true) {
				if (helper.getNext() == head) {
					// 找到了头几点的前一个节点 也就是尾节点
					break;
				}
				helper = helper.getNext();
			}

			// 从第几个小孩开始报数 初始化过去
			for (int i = 0; i < start - 1; i++) {
				head = head.getNext();
				helper = helper.getNext();
			}

			// 开始报数
			while (true) {
				// 小孩都出圈过后 最后的情况就是只剩下一个节点 也就是while的跳出条件
				if (helper == head) {
					System.out.println("最后一个出圈:" + head.getNo());
					break;
				}
				// 同时移动
				for (int i = 0; i < step - 1; i++) {
					head = head.getNext();
					helper = helper.getNext();
				}
				// 这个时候head指向的就是要出圈的
				System.out.println("准备出圈:" + head.getNo());
				head = head.getNext();
				helper.setNext(head);
			}
		}
	}

	// ------------------ 手动分割 ------------------

	public static void main(String[] args) {

		System.out.println("创建一个环形链表");
		SingleCircleLinkedList list = new SingleCircleLinkedList();

		System.out.println("初始化节点数");
		int i = list.create(124);
		System.out.println(i);

		System.out.println("初始化后环形链表");
		list.list();

		System.out.println();

		// 约瑟夫问题
		System.out.println("约瑟夫问题");
		list.count(10, 20, 124);
	}
}

/**
 * @author dingrui
 * @date 2020-11-16
 * @description: 定义一个节点
 */
class Node {
	/**
	 * 编号
	 */
	private int no;

	/**
	 * next指针 默认为null
	 */
	private Node next;

	public Node() {
	}

	public Node(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node{" +
				"no=" + no +
				'}';
	}
}
