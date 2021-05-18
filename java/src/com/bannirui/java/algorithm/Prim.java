package com.bannirui.java.algorithm;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-12-12
 *@description 普里姆修路问题 最小生成树MST
 */
public class Prim {
	/**
	 * 用10,000这样一个比较大的数字表示两个村庄不联通
	 * 场景是村庄自己跟自己不连通
	 */
	public static final Integer NOT_LINK = 10_000;

	public static void main(String[] args) {
		// 图的节点的值
		char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		// 图的节点个数
		int verxs = data.length;
		// 邻接矩阵
		int[][] weight = new int[][]{
				{NOT_LINK, 5, 7, NOT_LINK, NOT_LINK, NOT_LINK, 2},
				{5, NOT_LINK, 7, NOT_LINK, 9, NOT_LINK, NOT_LINK, 3},
				{7, NOT_LINK, NOT_LINK, NOT_LINK, 8, NOT_LINK, NOT_LINK},
				{NOT_LINK, 9, NOT_LINK, NOT_LINK, NOT_LINK, 4, NOT_LINK},
				{NOT_LINK, NOT_LINK, 8, NOT_LINK, NOT_LINK, 5, 4},
				{NOT_LINK, NOT_LINK, NOT_LINK, 4, 5, NOT_LINK, 6},
				{2, 3, NOT_LINK, NOT_LINK, 4, 6, NOT_LINK},
		};
		// 创建MGraph
		MGraph graph = new MGraph(verxs);
		// 生成MinTree
		MinTree minTree = new MinTree();
		minTree.createGraph(graph, verxs, data, weight);
		minTree.showGraph(graph);

		minTree.prim(graph,0);
	}
}

/**
 * @author dingrui
 * @date 2020-12-12
 * @description 最小生成树
 */
class MinTree {
	/**
	 * @author dingrui
	 * @date 2020/12/12
	 * @param mGraph 图对象
	 * @param verxs 图的节点数量
	 * @param data 图的各个节点值
	 * @param weight 图的邻接矩阵
	 * @return
	 * @description 通过图创建最小生成树
	 */
	public void createGraph(MGraph mGraph, int verxs, char[] data, int[][] weight) {
		int i, j;
		for (i = 0; i < verxs; i++) {
			mGraph.data[i] = data[i];
			for (j = 0; j < verxs; j++) {
				mGraph.weight[i][j] = weight[i][j];
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/12
	 * @param mGraph 图
	 * @return
	 * @description 显示树
	 */
	public void showGraph(MGraph mGraph) {
		for (int[] link : mGraph.weight) {
			System.out.println(Arrays.toString(link));
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/12
	 * @param graph 图
	 * @param verxIndex 图中节点所用 也就是从哪个节点开始修路
	 * @return
	 * @description prim算法 得到最小生成树
	 */
	public void prim(MGraph graph, int verxIndex) {
		// visited数组表示节点是否被访问过
		int[] visited = new int[graph.verxs];
		// 默认的时候都是0 表示还没有被访问过
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}

		// 当前节点标记为被访问
		visited[verxIndex] = 1;
		// h1 h2表示两个节点的下标
		int h1 = -1;
		int h2 = -1;
		// 初始化为一个比较大的数 在遍历过程中 如果找到权值较小的边 这个值会被替换
		int minWeight = 10_000;

		// 这个图有verxs个节点 因此有verxs-1个边 最外层循环的层数就是边的数量
		for (int k = 1; k < graph.verxs; k++) {
			// i节点表示被访问过的节点
			for (int i = 0; i < graph.verxs; i++) {
				// j节点表示还没有被访问过的节点
				for (int j = 0; j < graph.verxs; j++) {
					if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
						// if条件满足 说明找到一个权值小的边了 进行替换
						minWeight = graph.weight[i][j];
						h1 = i;
						h2 = j;
					}
				}
			}
			System.out.println("边->" + graph.data[h1] + "," + graph.data[h2] + "->权值：" + minWeight);
			// 标记节点被访问过
			visited[h2] = 1;
			// 重置minWeight
			minWeight = 10_000;
		}
	}
}

/**
 * @author dingrui
 * @date 2020-12-12
 * @description 图
 */
class MGraph {
	/**
	 * 表示图的节点个数
	 */
	int verxs;

	/**
	 * 存放节点数据
	 */
	char[] data;

	/**
	 * 存放边 就是邻接矩阵
	 */
	int[][] weight;

	/**
	 * @author dingrui
	 * @date 2020/12/12
	 * @param verxs 节点个数
	 * @return
	 * @description 构造函数
	 */
	public MGraph(int verxs) {
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
	}
}
