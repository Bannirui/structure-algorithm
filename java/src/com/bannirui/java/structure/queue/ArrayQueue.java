package com.bannirui.java.structure.queue;

import java.util.Scanner;

/**
 *@author dingrui
 *@date 2020-11-09
 *@description : 数组实现队列
 */
public class ArrayQueue {

	/**
	 * 数组容量
	 */
	private int maxSize;

	/**
	 * 队列头指针，对头元素前一个位置
	 */
	private int front;

	/**
	 * 队列尾指针，队尾元素位置
	 */
	private int rear;

	/**
	 * 数组
	 */
	int[] arr;

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @return
	 * @description: 构造函数
	 */
	public ArrayQueue(int maxSize) {
		// 数组容量
		this.maxSize = maxSize;
		// 根据数组容量初始化一个空数组
		this.arr = new int[this.maxSize];
		// 初始化时队列头尾指针都是-1
		this.front = -1;
		this.rear = -1;
	}

	/***
	 * @author dingrui
	 * @date 2020/11/9
	 * @return
	 * @description: 队列是否为空
	 */
	public boolean isEmpty() {
		return this.rear == this.front;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @return
	 * @description: 队列是否已满
	 */
	public boolean isFull() {
		return this.rear == maxSize - 1;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @param item 向队列添加的元素
	 * @return
	 * @description: 元素入队
	 */
	public void addEle(int item) {
		// 入队前判断是否已满
		if (isFull()) {
			throw new RuntimeException("队列已满，不能添加元素");
		}
		// rear指针后移
		this.rear++;
		// 数组赋值
		this.arr[rear] = item;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @return
	 * @description: 元素出队
	 */
	public int getEle() {
		// 出队列之前判断是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空，不能取出元素");
		}
		// front指针后移
		this.front++;
		// 数组元素取出
		return this.arr[this.front];
	}

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @return
	 * @description: 显示对头元素
	 */
	public int peek() {
		// 判断队列是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空，没有元素");
		}
		return this.arr[this.front + 1];
	}

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @return
	 * @description: 查看队列元素
	 */
	public void show() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，没有数据");
		}
		for (int i = 0; i < this.arr.length; i++) {
			System.out.printf("a[%d]=%d\n", i, this.arr[i]);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/9
	 * @param args
	 * @return
	 * @description: 主函数 测试
	 */
	public static void main(String[] args) {
		// 创建一个自定义队列
		ArrayQueue queue = new ArrayQueue(3);

		// 用户输入
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		// 输出一个菜单
		while (loop) {
			System.out.println("s(show)：显示队列");
			System.out.println("e(exit)：退出程序");
			System.out.println("a(add)：数据入队");
			System.out.println("g(get)：数据出队");
			System.out.println("p(peek)：查看对头数据");

			key = scanner.next().charAt(0);
			switch (key) {
				case 's':
					try {
						queue.show();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 'e':
					scanner.close();
					loop = false;
					break;
				case 'a':
					try {
						System.out.println("输入一个整数");
						int value = scanner.nextInt();
						queue.addEle(value);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 'g':
					try {
						int ele = queue.getEle();
						System.out.println("获取的元素是: " + ele);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 'p':
					try {
						int peek = queue.peek();
						System.out.println("查到的对头元素是: " + peek);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
			}
		}
		System.out.println("程序退出");
	}
}
