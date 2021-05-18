package com.bannirui.java.structure.stack;

/**
 *@author dingrui
 *@date 2020-11-17
 *@description : 用栈进行表达式计算 中缀表达式
 */
public class Calculator {

	/**
	 * @author dingrui
	 * @date 2020/11/17
	 * @param args
	 * @return
	 * @description:
	 */
	public static void main(String[] args) {
		// 表达式
		String expresion = "70+2*3-6+1000";

		// 定义两个栈 分别存放数字和运算符
		ArrayStack numberStack = new ArrayStack(10);
		ArrayStack operatorStack = new ArrayStack(10);

		// 扫描表达式的索引
		int index = 0;
		// 字符串表达式中取出来的字符char
		char ch = ' ';
		// 数字
		int number1 = 0;
		int number2 = 0;
		// 运算符
		int operator = 0;
		// 计算结果
		int result = 0;
		// 用于拼接多位数的数字
		String keepNum = "";

		// 开始遍历
		while (true) {
			// char
			ch = expresion.charAt(index);
			if (operatorStack.isOperator(ch)) {
				// 如果是运算符号
				if (operatorStack.isEmpty()) {
					// 如果当前的符号栈为空，直接入符号栈
					operatorStack.push(ch);
				} else {
					// 如果当前符号栈不为空，则进行比较当前操作符和栈中符号
					if (operatorStack.operatorOrder(ch) <= operatorStack.operatorOrder(operatorStack.peek())) {
						// 当前操作符优先级小于等于栈中操作符，从数栈中pop出两个数字，从操作符栈中pop出一个符号，进行计算，运算结果入数栈，当前操作符入符号栈
						number1 = numberStack.pop();
						number2 = numberStack.pop();
						operator = operatorStack.pop();
						result = operatorStack.calculate(number1, number2, operator);
						numberStack.push(result);
						operatorStack.push(ch);
					} else {
						// 当前操作符优先级大于符号栈中操作符，直接入符号栈
						operatorStack.push(ch);
					}
				}
			} else {
				// 如果是数字，直接入数字栈
				// 现在取到的ch类型是char 对应int类型需要减去48  比如'1'<=====>49
				// 即使是数字也不能直接入栈 如果是多位数字的话需要一直往后探测 比如：11 111 1111这种
				// numberStack.push(ch - 48);
				// 临时变量 往后探测表达式字符串 找到运算符之前的最后一个数字拼接起来 如果已经遍历到最后一位了 就不要继续探测了
				int tmpIndex = index;
				while (tmpIndex != expresion.length()) {
					char tmpCh = expresion.charAt(tmpIndex);
					if (operatorStack.isOperator(tmpCh)) {
						// 如果探测到操作符 跳出循环
						break;
					}
					// 拼接数字
					keepNum += tmpCh;
					tmpIndex++;
				}
				// 数字进栈
				numberStack.push(Integer.parseInt(keepNum));
				// 因为现在tmpIndex已经指向了符号位 跳出这个while循环之后随之而来的就是index++ 所以把index指向tmpIndex的前一位
				index = tmpIndex - 1;
				// 数字进栈完毕过后清空数字字符串
				keepNum = "";
			}
			index++;
			if (index >= expresion.length()) {
				// 遍历结束
				break;
			}
		}

		// 表达式遍历结束了 这个时候数栈中应该还有两个数字 操作符栈中应该还有一个操作符
		while (true) {
			if (operatorStack.isEmpty()) {
				break;
			}
			number1 = numberStack.pop();
			number2 = numberStack.pop();
			operator = operatorStack.pop();
			result = operatorStack.calculate(number1, number2, operator);
			numberStack.push(result);
		}

		// 这个时候数栈中应该只有一个数字了就是结果
		System.out.printf("表达式的计算结果：%s=%d\n", expresion, numberStack.peek());
	}
}
