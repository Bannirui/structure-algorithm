package com.bannirui.java.algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *@author dingrui
 *@date 2020-12-14
 *@description 马踏棋盘问题 骑士周游回溯算法
 */
public class HorseChessBoard {

	/**
	 * 棋盘的列数
	 */
	private static int X;

	/**
	 * 棋盘的行数
	 */
	private static int Y;

	/**
	 * 标记棋盘位置是否被访问过
	 */
	private static boolean[] visited;

	/**
	 * 标记棋盘所有位置是否都被访问 如果为true 表示马踏棋盘成功
	 */
	private static boolean finished;

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @param curPoint 马当前位置
	 * @return
	 * @description 根据当前位置 计算马还能走哪些位置 放入到集合中 最多8个点位
	 */
	public static List<Point> next(Point curPoint) {
		List<Point> ps = new ArrayList<>();
		Point p1 = new Point();
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		return ps;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @param chessboard 棋盘
	 * @param row 马当前位置的行 从0开始
	 * @param col 马当前位置的列 从0开始
	 * @param step 第几步 从1开始 初始位置是第一步
	 * @return
	 * @description 骑士周游问题算法
	 */
	public static void traversalChessboard(int[][] chessboard, int row, int col, int step) {
		chessboard[row][col] = step;
		// 标记该位置已经访问
		visited[row * X + col] = true;
		// 获取当前位置下一步可以走的位置的集合
		List<Point> ps = next(new Point(col, row));
		// ps排序
		sort(ps);
		// 遍历ps
		while (!ps.isEmpty()) {
			// 取出一个可以走的位置
			Point p = ps.remove(0);
			// 判断该点是否已经访问过
			if (!visited[p.y * X + p.x]) {
				// 还没访问过这个点
				traversalChessboard(chessboard, p.y, p.x, step + 1);
			}
		}
		if (step < X * Y && !finished) {
			// 棋盘到目前位置还没走完 或者 棋盘已经走完但是处于回溯状态
			chessboard[row][col] = 0;
			visited[row * X + col] = false;
		} else {
			finished = true;
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @param ps
	 * @return
	 * @description 优化
	 * 根据当前这一步的所有下一步可以选择走的位置 进行非递减排序 那么下一步先走的就是可选择最少的那个方案 减少回溯的次数
	 */
	public static void sort(List<Point> ps){
		ps.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// o1下一步可走的位置个数
				int count1 = next(o1).size();
				// o2下一步可走的位置个数
				int count2 = next(o2).size();
				if (count1<count2){
					return -1;
				} else if (count1==count2){
					return 0;
				} else {
					return 1;
				}
			}
		});
	}

	public static void main(String[] args) {
		X = 8;
		Y = 8;
		// 马初始位置 行从1开始
		int row = 1;
		// 马初始位置 列从1开始
		int col = 1;
		// 棋盘
		int[][] chessboard = new int[X][Y];
		// 是否已经访问过 状态都是false
		visited = new boolean[X * Y];

		traversalChessboard(chessboard, row - 1, col - 1, 1);

		// 算法执行完之后的棋盘
		for (int[] rows : chessboard) {
			System.out.println(Arrays.toString(rows));
		}
	}
}
