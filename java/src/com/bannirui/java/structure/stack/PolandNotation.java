package com.bannirui.java.structure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *@author dingrui
 *@date 2020-11-18
 *@description : 逆波兰表达式计算器
 */
public class PolandNotation {
	public static void main(String[] args) {
		// 定义一个逆波兰表达式 (30+4) * 5 - 6
		String expresion = "30 4 + 5 * 6 -";
		// 根据表达式计算出结果
		int res = calResultFromExpresion(expresion);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param expresion
	 * @return
	 * @description: 根据逆波兰表达式计算出结果
	 */
	private static int calResultFromExpresion(String expresion) {
		// 字符串表达式转换成列表
		List<String> list = transferString2List(expresion);
		// 根据列表计算结果
		return calResultFromList(list);
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param list
	 * @return
	 * @description: 根据列表元素计算出结果
	 */
	private static int calResultFromList(List<String> list) {
		// 定义一个栈
		Stack<String> stack = new Stack<>();
		// 遍历列表
		list.forEach((item) -> {
			if (item.matches("\\d+")) {
				// 如果是数字直接压栈
				stack.push(item);
			} else {
				// 弹出两个数进行计算 先进栈的数操作后进栈的数
				int number1 = Integer.parseInt(stack.pop());
				int number2 = Integer.parseInt(stack.pop());
				// 两个数 一个操作符 进行计算
				try {
					int res = calByNum(number1, number2, item);
					stack.push(res + "");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// 遍历完最后栈中的数字就是计算结果
		return Integer.parseInt(stack.pop());
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param number1
	 * @param number2
	 * @param item
	 * @return
	 * @description: 用number2操作number1
	 */
	private static int calByNum(int number1, int number2, String item) throws Exception {
		int res = 0;
		switch (item) {
			case "+":
				res = number2 + number1;
				break;
			case "-":
				res = number2 - number1;
				break;
			case "*":
				res = number2 * number1;
				break;
			case "/":
				res = number2 / number1;
				break;
			default:
				throw new RuntimeException("运算符号不对");
		}
		return res;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param expresion
	 * @return
	 * @description: 逆波兰表达式字符串格式转列表格式
	 */
	private static List<String> transferString2List(String expresion) {
		String[] split = expresion.split(" ");
		return Arrays.asList(split);
	}

}
