package com.bannirui.java.structure.stack;

/**
 *@author dingrui
 *@date 2020-11-17
 *@description : 使用数组实现栈
 */
public class ArrayStack {

	/**
	 * 使用数组实现栈 数组的大小
	 */
	private int size;

	/**
	 * 数组
	 */
	private int[] array;

	/**
	 * 栈顶指针 初始化为-1
	 */
	private int top = -1;

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @param size 数组大小
	 * @return
	 * @description: 构造器 构造出一个数组
	 */
	public ArrayStack(int size) {
		this.size = size;
		array = new int[this.size];
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @return
	 * @description: 判断是否栈空
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @return
	 * @description: 判断是否栈满
	 */
	public boolean isFull() {
		return top == size - 1;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @param value
	 * @return
	 * @description: 入栈
	 */
	public void push(int value) {
		// 先判断是否栈满
		if (isFull()) {
			throw new RuntimeException("栈满，不能入栈");
		}
		top++;
		array[top] = value;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @return
	 * @description: 出栈
	 */
	public int pop() {
		// 判断是否栈空
		if (isEmpty()) {
			throw new RuntimeException("栈空，不能出栈");
		}
		int value = array[top];
		top--;
		return value;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @return
	 * @description: 查看栈顶元素
	 */
	public int peek() {
		// 栈为空
		if (isEmpty()) {
			throw new RuntimeException("栈为空，没有元素");
		}
		return array[top];
	}

	public void list() {
		// 判断是否栈空
		if (isEmpty()) {
			throw new RuntimeException("栈空，没有元素");
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("当前元素 stack[%d]=%d\n", i, array[i]);
		}
	}

	// ------------------- 为了方便实现计算器功能 扩展几个方法 -------------------

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @param operator
	 * @return
	 * @description: 判断是否为操作符 操作符为char 传入int进行判断 只对加减乘除进行判断
	 */
	public boolean isOperator(int operator) {
		return operator == '+' || operator == '-' || operator == '*' || operator == '/';
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @param operator
	 * @return
	 * @description: 判断运算符的优先级
	 */
	public int operatorOrder(int operator) {
		if (operator == '*' || operator == '/') {
			return 1;
		} else if (operator == '+' || operator == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @param number1
	 * @param number2
	 * @param operator
	 * @return
	 * @description: 两个数字进行计算 因为数字栈中的数字是先进后出 所以要用先进去的数字 操作 后进去的数字 也就是后出来的数字 操作 先出来的数字
	 */
	public int calculate(int number1, int number2, int operator) {
		int result = 0;
		switch (operator) {
			case '+':
				result = number2 + number1;
				break;
			case '-':
				result = number2 - number1;
				break;
			case '*':
				result = number2 * number1;
				break;
			case '/':
				result = number2 / number1;
				break;
			default:
				break;
		}
		return result;
	}


	// ------------------- 手动分割 -------------------

	public static void main(String[] args) {
		// 初始化一个栈实例
		ArrayStack stack = new ArrayStack(5);
		// 是否为空
		System.out.println("是否为空");
		System.out.println(stack.isEmpty());

		System.out.println();
		// 添加元素
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		// 是否为空
		System.out.println("是否为空");
		System.out.println(stack.isEmpty());
		System.out.println();

		// 是否满
		System.out.println("是否满");
		System.out.println(stack.isFull());

		// 遍历元素
		System.out.println();
		stack.list();
	}
}
