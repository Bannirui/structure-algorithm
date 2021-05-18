package com.bannirui.java.structure.recursion;

/**
 *@author dingrui
 *@date 2020-11-18
 *@description : 递归调用
 */
public class Recursion {

	public static void main(String[] args) {
		printNum(5);
	}

	private static void printNum(int n) {
		if (n > 2) {
			printNum(n-1);
		}
		System.out.println(n);
	}
}
