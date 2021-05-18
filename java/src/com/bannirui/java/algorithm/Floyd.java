package com.bannirui.java.algorithm;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-12-14
 *@description 弗洛伊德算法 最短距离问题 各个顶点到其他所有顶点最短距离
 */
public class Floyd {
	public static void main(String[] args) {
		// 顶点
		char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		// 邻接矩阵
		int[][] matrix = new int[vertex.length][vertex.length];
		// 该距离长度表示两点不可连接
		final int N = 65535;
		matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
		matrix[1] = new int[]{5, N, N, 9, N, N, 3};
		matrix[2] = new int[]{7, N, N, N, 8, N, N};
		matrix[3] = new int[]{N, 9, N, N, N, 4, N};
		matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
		matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
		matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

		// 创建图
		FloydGraph graph = new FloydGraph(vertex.length, matrix, vertex);

		// 显示图
		graph.show();

		// 调用弗洛伊德算法
		graph.floyd();

		// 显示图
		graph.show();
	}
}

/**
 * @author dingrui
 * @date 2020-12-14
 * @description 创建图
 */
class FloydGraph {
	/**
	 * 存放顶点的额数组
	 */
	private char[] vertex;

	/**
	 * 保存从各个顶点出发到其他顶点的距离
	 */
	private int[][] dis;

	/**
	 * 保存到达目标顶点的前驱顶点
	 */
	private int[][] pre;

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @param length 大小
	 * @param matrix 邻接矩阵
	 * @param vertex 顶点数组
	 * @return
	 * @description 构造函数
	 */
	public FloydGraph(int length, int[][] matrix, char[] vertex) {
		this.vertex = vertex;
		this.dis = matrix;
		this.pre = new int[length][length];

		// 初始化pre 前驱顶点的下标
		for (int i = 0; i < length; i++) {
			Arrays.fill(pre[i], i);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @return
	 * @description 显示pre数组和dis数组
	 */
	public void show() {
		System.out.println("pre数组");
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis.length; j++) {
				System.out.print(pre[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("dis数组");
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis.length; j++) {
				System.out.print(dis[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @return
	 * @description 弗洛伊德算法
	 */
	public void floyd() {
		// 变量保存距离
		int length = 0;
		// 对中间顶点遍历 k表示终点顶点的下标
		for (int k = 0; k < dis.length; k++) {
			// 从i顶点出发
			for (int i = 0; i < dis.length; i++) {
				// 从i顶点出发 通过k顶点 到达j顶点
				for (int j = 0; j < dis.length; j++) {
					// 从i到j 经过k 距离
					length = dis[i][k] + dis[k][j];
					if (length < dis[i][j]) {
						// 以k为中间顶点 从i到j 比i顶点到j顶点的直连距离还小
						// 更新距离
						dis[i][j] = length;
						// 更新前驱顶点
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
	}
}
