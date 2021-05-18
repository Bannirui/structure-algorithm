package com.bannirui.java.structure.recursion;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-11-19
 *@description : 走迷宫问题
 */
public class Maze {

	public static void main(String[] args) {
		// 实例化一个二维数组表示迷宫地图 8行*6列
		int[][] map = new int[8][6];
		// 四周弄上墙 四周元素都是1
		decorate(map, 8, 6);
		// 弄上两个墙 1表示墙
		map[3][1] = 1;
		map[3][2] = 1;
		// 再弄两个墙 把路堵死
		map[1][2] = 1;
		map[2][2] = 1;
		// 打印
		System.out.println("走迷宫之前");
		System.out.println();
		printMap(map);
		// 从(1,1)出发 是否能找到一条到终点(6.4)的路
		boolean result = findWay(map, 1, 1, 6, 4);
		System.out.println("能否走出迷宫：" + result);
		// 打印
		System.out.println("走迷宫之后");
		System.out.println();
		printMap(map);
	}

	/**
	 * @author dingrui
	 * @date 2020/11/19
	 * @param map
	 * @param row
	 * @param col
	 * @return
	 * @description: 二维数组四周设置为1
	 */
	private static void decorate(int[][] map, int row, int col) {
		// 左右设置为1
		for (int i = 0; i < row; i++) {
			map[i][0] = 1;
			map[i][col - 1] = 1;
		}
		// 上下设置为1
		for (int j = 0; j < col; j++) {
			map[0][j] = 1;
			map[row - 1][j] = 1;
		}

	}

	/**
	 * @author dingrui
	 * @date 2020/11/19
	 * @param map 迷宫地图
	 * @param startRow 起始点row
	 * @param startCol 起始点col
	 * @param endRow 终点row
	 * @param endCol 终点col
	 * @return
	 * @description: 根据给定的起始点(row, col) 尝试找到去终点(5,3) 有这样的一条路就返回true 没有就返回false
	 * 1：墙
	 * 2：可以走
	 * 3：走过，不通
	 */
	private static boolean findWay(int[][] map, int startRow, int startCol, int endRow, int endCol) {
		if (map[endRow][endCol] == 2) {
			// 终点可以走 找到了通往终点的路
			return true;
		} else {
			// 没有走到终点 当前点开始出发
			if (map[startRow][startCol] == 0) {
				// 当前点还没有走过 是0
				// 先设置当前点是可以走的 设置为2
				map[startRow][startCol] = 2;
				if (findWay(map, startRow + 1, startCol, endRow, endCol)) {
					// 尝试向下走
					return true;
				} else if (findWay(map, startRow, startCol + 1, endRow, endCol)) {
					// 尝试向右走
					return true;
				} else if (findWay(map, startRow, startCol - 1, endRow, endCol)) {
					// 尝试向上走
					return true;
				} else if (findWay(map, startRow - 1, startCol, endRow, endCol)) {
					// 尝试向左走
					return true;
				} else {
					// 下->右->上->左 都走不同 当前点设为3
					map[startRow][startCol] = 3;
					return false;
				}
			} else {
				// 当前点已经走过 可能是2：走过并且能走通 可能是3：走过但是走不通 不可能是1：当前点不可能是个墙吧
				// 没有走到终点前 当前点已经走过 只能说明无路可走了 找不到路去终点了 返回false
				return false;
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/11/19
	 * @param map
	 * @return
	 * @description: 打印二维数组
	 */
	private static void printMap(int[][] map) {
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
			System.out.println();
		}
	}


}
