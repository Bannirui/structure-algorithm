package com.bannirui.java.structure.linkedList;

import java.util.Stack;

/**
 *@author dingrui
 *@date 2020-11-16
 *@description : 节点实体
 */
class HeroNode {
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
	 * next指针
	 */
	public HeroNode next;

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @return
	 * @description: 构造器
	 */
	public HeroNode(int no, String name, String nickName) {
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
	public HeroNode() {
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
 *@date 2020-11-10
 *@description : 带头节点的单链表
 * 头节点仅仅是说明是一个head，不存储具体的数据
 */
public class SingleLinkedList<T> {

	/**
	 * 定义一个头节点 不存放具体的数据
	 */
	private final HeroNode head = new HeroNode();

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @param heroNode
	 * @return
	 * @description: 链表中添加元素
	 * 不考虑编号顺序的时候，每添加一个新的节点，就追加到最后节点的后面
	 * 1，找到最后的那个节点
	 * 2，最后节点的next指向新添加的节点
	 */
	public void add(HeroNode heroNode) {
		// 头节点不能动，维护一个临时变量 用于遍历找最后一个几点
		HeroNode tmp = this.head;
		while (true) {
			if (null == tmp.next) {
				// 如果临时节点的next为null，意味着找到了最后的节点
				break;
			}
			tmp = tmp.next;
		}
		// 当while退出循环时 说明tmp临时节点已经到最后
		// 新增节点加到链表最后
		tmp.next = heroNode;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @param node
	 * @return
	 * @description: 按照编号顺序添加
	 */
	public void addByOrder(HeroNode node) {
		// 定义一个辅助节点
		HeroNode tmp = head;
		// 定义一个标识位 是否已经存在某个元素 不能插入
		boolean existItem = false;
		while (true) {
			// 遍历到链表尾
			if (tmp.next == null) {
				break;
			}
			if (tmp.next.no > node.no) {
				// 新增元素的插入位置就应该在tmp后面
				break;
			} else if (tmp.next.no == node.no) {
				// 不能新增这个元素 这个元素的编号已经存在了
				existItem = true;
				break;
			}
			// 指针后移
			tmp = tmp.next;
		}
		// while循环已经跳出 根据标识位决定是否插入元素
		if (existItem) {
			System.out.printf("当前元素已经存在，id为[%d]\n", node.no);
		} else {
			node.next = tmp.next;
			tmp.next = node;
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @param heroNode
	 * @return
	 * @description: 根据编号更新元素
	 */
	public void updateByNo(HeroNode heroNode) {
		// 判断当前链表不为空
		if (head.next == null) {
			System.out.println("当前链表为空");
			return;
		}
		// 定义一个临时变量指针tmp
		HeroNode tmp = head.next;
		// 定义一个标识位是否找到编号根传进来元素一样的编号
		boolean findItem = false;
		while (true) {
			if (tmp == null) {
				// 遍历完了链表
				break;
			}
			if (tmp.no == heroNode.no) {
				// 找到了当前元素的编号根传进来的编号一样
				findItem = true;
				break;
			}
			tmp = tmp.next;
		}
		// 根据标识位修改元素
		if (findItem) {
			tmp.name = heroNode.name;
			tmp.nickName = heroNode.nickName;
		} else {
			System.out.printf("不存在编号为[%d]的元素\n", heroNode.no);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @param no
	 * @return
	 * @description: 根据编号删除节点
	 */
	public void deleteByNo(int no) {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 定义一个临时节点指针
		HeroNode tmp = head;
		// 定义标志符是否找到待删除节点的前一个节点
		boolean findItem = false;
		while (true) {
			if (tmp.next == null) {
				// 遍历完了链表
				break;
			}
			if (tmp.next.no == no) {
				// 找到了需要删除的节点的前一个节点
				findItem = true;
				break;
			}
			tmp = tmp.next;
		}
		// 根据标志符删除
		if (findItem) {
			tmp.next = tmp.next.next;
		} else {
			System.out.printf("没有编号是[%d]的节点\n", no);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @return
	 * @description: 显示链表
	 */
	public void list() {
		if (null == head.next) {
			System.out.println("链表为空");
			return;
		}

		// head节点不能动 维护一个临时变量 进行遍历
		HeroNode tmp = this.head;
		while (null != tmp) {
			// 打印出链表
			System.out.println(tmp);
			// 临时变量节点后移
			tmp = tmp.next;
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @return
	 * @description: 根据链表的头节点统计出有效节点数量 不计算头节点
	 */
	public int count() {
		HeroNode cur = head.next;
		int count = 0;

		if (cur == null) {
			return count;
		} else {
			while (cur != null) {
				count++;
				cur = cur.next;
			}
		}
		return count;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @param index 倒数第index个
	 * @return
	 * @description: 查找倒数第index个节点
	 */
	public HeroNode findLastIndexNode(int index) {
		// 链表是否为空
		if (head.next == null) {
			return null;
		}
		// 链表有效节点个数
		int count = count();
		// 倒数第index个 也就是正数第count-index个
		// index校验
		if (index <= 0 || index > count) {
			return null;
		}
		// 开始遍历
		// 定义一个临时变量指针
		HeroNode cur = head.next;
		for (int i = 0; i < count - index; i++) {
			cur = cur.next;
		}
		return cur;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @return
	 * @description: 实现单链表的反转
	 */
	public void reverse() {
		// 如果链表为空或者只有一个元素 不需要反转
		if (head.next == null || head.next.next == null) {

		} else {
			// 定义一个临时变量指针遍历链表cur
			HeroNode cur = head.next;
			// 定义一个临时变量指针指向cur的下一个节点next
			HeroNode next = null;
			// 定义一个新的头节点reverseHead
			HeroNode reverseHead = new HeroNode();

			while (cur != null) {
				next = cur.next;
				cur.next = reverseHead.next;
				reverseHead.next = cur;
				cur = next;
			}
			// 原来链表的头节点指向新链表
			head.next = reverseHead.next;
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/11
	 * @return
	 * @description: 逆序打印出链表的元素
	 * 1，如果使用链表反转，然后再从头节点遍历打印的话，可以达到逆序打印的效果，但是会破坏原有数据结构
	 * 2，借助堆栈的先进后出特点，先将元素压栈，然后出栈打印
	 */
	public void printReverse() {
		Stack<HeroNode> nodeStack = new Stack<>();
		// 遍历压栈
		if (head.next != null) {
			HeroNode cur = head.next;
			while (cur != null) {
				nodeStack.push(cur);
				cur = cur.next;
			}
		}
		// 出栈打印
		while (!nodeStack.isEmpty()) {
			HeroNode pop = nodeStack.pop();
			System.out.println("当前出栈元素：" + pop.toString());
		}
	}

	// ------------------ 手动分割 ------------------

	/**
	 * @author dingrui
	 * @date 2020/11/10
	 * @param args
	 * @return
	 * @description: 测试
	 */
	public static void main(String[] args) {
		// 创建一个链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		// 创建节点
		HeroNode songjiang = new HeroNode(1, "宋江", "及时雨");
		HeroNode lujunyi = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode wuyong = new HeroNode(3, "吴用", "智多星");

		// 添加节点 元素追加到链表尾部
		System.out.println("元素追加到链表尾部");
		singleLinkedList.add(songjiang);
		singleLinkedList.add(lujunyi);
		singleLinkedList.add(wuyong);
		singleLinkedList.list();

		// 添加节点 顺序添加
		System.out.println("顺序添加");
		singleLinkedList.addByOrder(wuyong);
		singleLinkedList.addByOrder(lujunyi);
		singleLinkedList.addByOrder(songjiang);
		singleLinkedList.list();

		// 当前链表有效节点数量
		int count = singleLinkedList.count();
		System.out.printf("当前链表有效节点数量是:[%d]\n", count);

		// 链表反转
		System.out.println("链表反转：");
		singleLinkedList.reverse();
		singleLinkedList.list();

		// 反转打印
		System.out.println("逆序打印");
		singleLinkedList.printReverse();

		// 倒数第k个节点
		HeroNode lastIndexNode = singleLinkedList.findLastIndexNode(1);
		System.out.printf("倒数第1个节点是[%s]\n", lastIndexNode.toString());

		// new一个新元素更新链表
		HeroNode wuyongNew = new HeroNode(3, "吴用new", "智多星new");
		singleLinkedList.updateByNo(wuyongNew);
		System.out.println("根据编号更新元素");
		singleLinkedList.list();

		// 删除编号是1的节点
		singleLinkedList.deleteByNo(1);
		System.out.println("删除编号为1的");
		singleLinkedList.list();
		// 删除编号是3的节点
		System.out.println("删除编号为3的");
		singleLinkedList.deleteByNo(3);
		singleLinkedList.list();
		// 删除编号是4的节点
		System.out.println("删除编号为4的");
		singleLinkedList.deleteByNo(4);
		singleLinkedList.list();
	}
}
