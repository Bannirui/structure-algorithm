package com.bannirui.java.structure.sparsearray;

/**
 *@author dingrui
 *@date 2020-11-09
 *@description : 稀疏数组
 * 黑白棋棋盘->二维数组->稀疏数组
 * 1：黑棋子
 * 2：白棋子
 */
public class SparseArray {

	public static void main(String[] args) {
		// 1，原始的二维数组
		int[][] chessCommonArray = new int[11][11];
		chessCommonArray[1][2] = 1;
		chessCommonArray[2][3] = 2;

		// 普通数组输出
		System.out.println("普通数组：");
		int count = 0;
		for (int[] row : chessCommonArray) {
			for (int item : row) {
				if (0 != item) {
					count++;
				}
				System.out.printf("%d\t", item);
			}
			System.out.println();
		}

		// 2，生成稀疏数组
		// 2.1，普通二维数组的有效数据个数count
		// 2.2，创建对应的稀疏数组
		int[][] chessSparseArray = new int[count + 1][3];
		// 稀疏数组 第一行
		chessSparseArray[0][0] = 11;
		chessSparseArray[0][1] = 11;
		chessSparseArray[0][2] = count;

		// 遍历生成其他行
		count = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				int item = chessCommonArray[i][j];
				if (0 != item) {
					count++;
					chessSparseArray[count][0] = i;
					chessSparseArray[count][1] = j;
					chessSparseArray[count][2] = item;
				}
			}
		}

		// 稀疏数组输出
		System.out.println("稀疏数组：");
		for (int[] row : chessSparseArray) {
			for (int item : row) {
				System.out.printf("%d\t", item);
			}
			System.out.println();
		}

		// ------------------------------ 手动分割 ------------------------------
		// 3，稀疏数组恢复成普通二维数组
		// 3.1，总共几行几列
		int row = chessSparseArray[0][0];
		int column = chessSparseArray[0][1];
		int[][] chessCommonArrayNew = new int[row][column];
		// 3.2，有效数据
		for (int i = 1; i < chessSparseArray.length; i++) {
			int rowIndex = chessSparseArray[i][0];
			int colIndex = chessSparseArray[i][1];
			int data = chessSparseArray[i][2];
			chessCommonArrayNew[rowIndex][colIndex] = data;
		}

		// 普通数组输出
		System.out.println("新的普通数组：");
		for (int[] newRow : chessCommonArrayNew) {
			for (int item : newRow) {
				if (0 != item) {
					count++;
				}
				System.out.printf("%d\t", item);
			}
			System.out.println();
		}
	}
}
