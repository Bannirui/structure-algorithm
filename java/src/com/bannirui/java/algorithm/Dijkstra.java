package com.bannirui.java.algorithm;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-12-13
 *@description 迪杰斯特拉算法 最短路径问题 图的广度优先遍历 某个顶点到其他顶点的最短距离
 */
public class Dijkstra {

	public static void main(String[] args) {
		// 顶点
		char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		// 邻接矩阵
		int[][] matrix = new int[vertexs.length][vertexs.length];
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
		Graph graph = new Graph(vertexs, matrix);
		// 打印
		graph.showGraph();

		// 从G出发 G顶点的下标是6
		graph.dijkstra(6);
		graph.showDijkstra();

		System.out.println();
	}
}

class Graph {
	/**
	 * 顶点数组
	 */
	private char[] vetexs;

	/**
	 * 邻接矩阵
	 */
	private int[][] matrix;

	/**
	 * 已经访问过的顶点的集合
	 */
	VisitedVertex visitedVertex;

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param vertexs
	 * @param matrix
	 * @return
	 * @description 构造器
	 */
	public Graph(char[] vertexs, int[][] matrix) {
		this.vetexs = vertexs;
		this.matrix = matrix;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @return
	 * @description 显示图
	 */
	public void showGraph() {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @return
	 * @description 显示迪杰斯特拉算法结果
	 */
	public void showDijkstra() {
		visitedVertex.show();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param index 出发顶点的下标
	 * @return
	 * @description 迪杰斯特拉算法实现
	 */
	public void dijkstra(int index) {
		visitedVertex = new VisitedVertex(vetexs.length, index);
		// 更新index顶点到周围顶点的距离和前驱顶点
		update(index);
		for (int i = 0; i < vetexs.length; i++) {
			// 选择并返回新的访问顶点
			index = visitedVertex.updateArr();
			// 更新index顶点到周围顶点的距离和前驱顶点
			update(index);
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @param index
	 * @return
	 * @description 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
	 */
	private void update(int index) {
		int length;
		// 遍历邻接矩阵matrix[index]行
		for (int i = 0; i < matrix[index].length; i++) {
			// length的含义：出发顶点到index顶点的距离+从index顶点到i顶点的距离
			length = visitedVertex.getDis(index) + matrix[index][i];
			// 如果顶点i没有被访问过 并且length小于出发顶点到i顶点的距离 就需要更新
			if (!visitedVertex.in(i) && length < visitedVertex.getDis(i)) {
				// 更新i顶点的前驱为index顶点
				visitedVertex.updatePre(i, index);
				// 更新出发顶点到i顶点的距离
				visitedVertex.updateDis(i, length);
			}
		}

	}
}

/**
 * @author dingrui
 * @date 2020-12-13
 * @description 已访问顶点集合
 */
class VisitedVertex {
	/**
	 * 记录各个顶点是否访问过，1表示访问过，0未访问过 该数组会动态更新
	 */
	public int[] alreadyArr;

	/**
	 * 每个下标对应的值为前一个顶点下标 会动态更新
	 */
	public int[] preVisited;

	/**
	 * 记录出发顶点到其他所有顶点的距离 比如G为出发点 就会记录G到其他顶点的距离 会动态更新 求的最短距离就会存放到dis中
	 */
	public int[] dis;

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param length 顶点个数
	 * @param index 出发顶点对应的下标 如果顶点G对应的下标为6
	 * @return
	 * @description
	 */
	public VisitedVertex(int length, int index) {
		this.alreadyArr = new int[length];
		this.preVisited = new int[length];
		this.dis = new int[length];
		// 初始化dis数组 除了自己是0 跟其他顶点距离都是最大距离
		Arrays.fill(dis, 65535);
		// 设置出发顶点被访问过
		this.alreadyArr[index] = 1;
		this.dis[index] = 0;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param index 顶点下标
	 * @return
	 * @description 判断该顶点是否已经访问过 如果已经访问过返回true 如果没有访问过返回false
	 */
	public boolean in(int index) {
		return alreadyArr[index] == 1;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param index 顶点的下标
	 * @param length 出发顶点到index顶点的距离值
	 * @return
	 * @description 更新出发顶点到index顶点距离的值
	 */
	public void updateDis(int index, int length) {
		dis[index] = length;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param pre pre节点的下标
	 * @param index index节点的下标
	 * @return
	 * @description 更新pre这个顶点的前驱节点为index这个节点
	 */
	public void updatePre(int pre, int index) {
		preVisited[pre] = index;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param index index节点的下标
	 * @return
	 * @description 返回出发顶点到index节点的距离
	 */
	public int getDis(int index) {
		return dis[index];
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @return
	 * @description 继续选择并返回新的访问顶点
	 * 比如 现在G为出发顶点 G走完之后 就是选择A作为新的访问顶点 但是A不是出发顶点
	 */
	public int updateArr() {
		int min = 65535;
		int index = 0;
		for (int i = 0; i < alreadyArr.length; i++) {
			if (alreadyArr[i] == 0 && dis[i] < min) {
				min = dis[i];
				index = i;
			}
			// 更新index顶点被访问过
			alreadyArr[index] = 1;
		}
		return index;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/14
	 * @return
	 * @description 显示结果
	 */
	public void show() {
		System.out.println("alreadyArr数组");
		for (int i : alreadyArr) {
			System.out.print(i+" ");
		}

		System.out.println();
		System.out.println("preVisited数组");
		for (int j : preVisited) {
			System.out.print(j+" ");
		}

		System.out.println();
		System.out.println("dis数组");
		for (int k : dis) {
			System.out.print(k+" ");
		}
	}
}
