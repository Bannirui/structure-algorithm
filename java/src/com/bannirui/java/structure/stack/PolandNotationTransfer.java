package com.bannirui.java.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@author dingrui
 *@date 2020-11-18
 *@description : 中缀表达式转后缀表达式
 */
public class PolandNotationTransfer {

	public static void main(String[] args) {
		// 定义一个中缀表达式
		String inFixExpresionString = "1+((2+3)*4)-5";
		// 中缀表达式 字符串格式转列表格式 方便后续操作
		List<String> inFixExpresionList = expresionTransfer(inFixExpresionString);
		// 列表 中缀表达式=>后缀表达式
		List<String> suffixExpresionList = parse(inFixExpresionList);


		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param inFixExpresionList
	 * @return
	 * @description: 列表转换 中缀表达式转后缀表达式
	 */
	private static List<String> parse(List<String> inFixExpresionList) {
		// 初始化两个栈 s1存储运算符 s2存储中间结果 因为最后还要将s2逆序输出 直接就将中间结果存到列表中
		Stack<String> s1 = new Stack<>();
		List<String> s2 = new ArrayList<>();
		// 遍历中缀表达式
		inFixExpresionList.forEach((o) -> {
			if (o.matches("\\d+")) {
				// 如果遇到数字 压入栈s2
				s2.add(o);
			} else if ("(".equals(o)) {
				// 如果是左括号(，直接压入s1
				s1.push(o);
			} else if (")".equals(o)) {
				// 如果是右括号)，依次弹出s1栈顶的运算符，压入s2，直到遇到左括号为止，此时将这一对括号丢弃
				while (!"(".equals(s1.peek())) {
					s2.add(s1.pop());
				}
				// 丢弃左括号
				s1.pop();
			} else {
				// 运算符
				while (!s1.isEmpty() && optionOrder(o) <= optionOrder(s1.peek())) {
					// 否则，将s1的栈顶运算符弹出压入s2，再次转到4.1与s1中栈顶运算符优先级进行比较
					s2.add(s1.pop());
				}
				/**
				 * 如果s1为空，或者栈顶运算符为左括号(，直接将这个运算符压入s1
				 * 否则，如果优先级比s1栈顶运算符优先级高，将这个运算符压入s1
				 */
				s1.push(o);
			}

		});
		// 将s1中运算符依次弹出压入s2
		while (!s1.isEmpty()) {
			s2.add(s1.pop());
		}
		// s2就是结果
		return s2;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param operation
	 * @return
	 * @description: 计算出操作符的优先级
	 */
	private static int optionOrder(String operation) {
		int res = -1;
		switch (operation) {
			case "+":
			case "-":
				res = 1;
				break;
			case "*":
			case "/":
				res = 2;
				break;
			default:
				System.out.println("运算符有问题");
				break;
		}
		return res;
	}

	/**
	 * @author dingrui
	 * @date 2020/11/18
	 * @param s
	 * @return
	 * @description: 解析中缀表达式 将字符串格式转列表格式
	 */
	private static List<String> expresionTransfer(String s) {
		// char元素 ascii码中数字对应的是48到57 也就是'0'==>48 '9'==>57
		// 遍历字符串索引
		int index = 0;
		// 每个索引取出来的char
		char ch;
		// 多位数
		String keepNum;
		// 列表结果
		List<String> list = new ArrayList<>();
		while (index <= s.length() - 1) {
			if ((ch = s.charAt(index)) < 48 || (ch = s.charAt(index)) > 57) {
				// 不是数字
				list.add(ch + "");
				index++;
			} else {
				// 是数字
				// 可能数字是多位
				keepNum = "";
				while (index <= s.length() - 1 && (ch = s.charAt(index)) >= 48 && (ch = s.charAt(index)) <= 57) {
					keepNum += ch;
					index++;
				}
				list.add(keepNum);
			}
		}
		return list;
	}
}
