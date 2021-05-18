package com.bannirui.java.algorithm;

import java.util.Arrays;

/**
 *@author dingrui
 *@date 2020-12-13
 *@description 克鲁斯卡尔算法 最小生成树 公交站问题
 */
public class Kruskal {

	/**
	 * 边的个数
	 */
	private int edgeNum;

	/**
	 * 顶点数组
	 */
	private char[] vertexs;

	/**
	 * 邻接矩阵
	 */
	private int[][] matrix;

	/**
	 * INF 表示两个顶点不能连通
	 */
	private static final Integer INF = Integer.MAX_VALUE;

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param vertexs 顶点
	 * @param matrix 邻接矩阵
	 * @return
	 * @description 构造函数
	 */
	public Kruskal(char[] vertexs, int[][] matrix) {
		// 初始化顶点数和边的个数
		int vlen = vertexs.length;
		// 初始化顶点
		this.vertexs = new char[vlen];
		for (int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
		}

		// 初始化边
		this.matrix = new int[vlen][vlen];
		for (int i = 0; i < vlen; i++) {
			for (int j = 0; j < vlen; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}

		// 统计边数量
		for (int i = 0; i < vlen; i++) {
			for (int j = i+1; j < vlen; j++) {
				if (this.matrix[i][j] != INF) {
					edgeNum++;
				}
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @return
	 * @description 打印邻接矩阵
	 */
	public void print() {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param edges 边的集合
	 * @return
	 * @description 对边按照边的权值进行排序
	 */
	private void sortEdges(EData[] edges) {
		for (int i = 0; i < edges.length - 1; i++) {
			for (int j = 0; j < edges.length - 1 - i; j++) {
				if (edges[j].weight > edges[j+1].weight) {
					EData tmp = edges[j];
					edges[j] = edges[j + 1];
					edges[j + 1] = tmp;
				}
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param ch 顶点
	 * @return 如果在顶点集合中找到顶点返回对应的下标 如果没找到返回-1
	 * @description 返回顶点在顶点集合的下标
	 */
	private int getPosition(char ch){
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i]==ch){
				return i;
			}
		}
		return -1;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @return
	 * @description 获取图中的边放到数组中
	 * 通过matrix邻接矩阵获取边 二维数组中的值非0非INF就是有效的边
	 */
	private EData[] getEdges(){
		int index=0;
		EData[] edges = new EData[edgeNum];
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = i+1; j < vertexs.length; j++) {
				if (matrix[i][j]!=INF){
					edges[index++]=new EData(vertexs[i],vertexs[j],matrix[i][j]);
				}
			}
		}
		return edges;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/13
	 * @param ends 数组记录了各个顶点对应的终点是哪个
	 * @param index 顶点下标
	 * @return 下标为i的顶点对应的终点的下标
	 * @description 获取下标为index的顶点对应的终点
	 * 用于判断两个顶点的终点是否相同
	 */
	private int getEnd(int[] ends,int index){
		while (ends[index] != 0) {
			index=ends[index];
		}
		return index;
	}

	public EData[] kruskal(){
		// 表示最后结果数组的索引
		int index=0;
		// 用于保存已有的最小生成树中的每个顶点在最小生成树中的终点
		int[] ends=new int[edgeNum];
		// 结果数组 保存最终的最小生成树
		EData[] results=new EData[edgeNum];

		// 获取图中所有的边
		EData[] edges = getEdges();
		// 边按照权值大小升序排序
		sortEdges(edges);
		// 遍历edges数组 将边添加到最小生成树中 判断是否会形成回路
		for (int i = 0; i < edgeNum; i++) {
			// 获得第i条边的第一个顶点
			int position1 = getPosition(edges[i].start);
			// 获得第i条边的第二个顶点
			int position2 = getPosition(edges[i].end);
			// 获取position1在最小生成树中的终点
			int end1 = getEnd(ends, position1);
			// 获取position1在最小生成树中的终点
			int end2 = getEnd(ends, position2);
			// 判断是否形成回路 终点是否一样
			if (end1!=end2){
				// 将这条边加入results
				results[index++]=edges[i];
				// 设置终点 这条新增边有了起点与终点的映射关系
				ends[end1]=end2;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		// 顶点
		char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		// 邻接矩阵
		int[][] matrix = {
				{0, 12, INF, INF, INF, 16, 14},
				{12, 0, 10, INF, INF, 7, INF},
				{INF, 10, 0, 3, 5, 6, INF},
				{INF, INF, 3, 0, 5, 6, INF},
				{INF, INF, 5, 4, 0, 2, 8},
				{16, 7, 6, INF, 2, 0, 9},
				{14, INF, INF, INF, 8, 9, 0}
		};
		// 创建克鲁斯卡尔算法实例对象
		Kruskal kruskal = new Kruskal(vertexs, matrix);
		// 打印输出
		kruskal.print();

		EData[] result = kruskal.kruskal();

		System.out.println();
	}
}

/**
 * @author dingrui
 * @date 2020-12-13
 * @description 边的抽象 该类的实例对象表示一条边
 */
class EData {
	/**
	 * 边的一个点
	 */
	char start;

	/**
	 * 边的另一个点
	 */
	char end;

	/**
	 * 边的权值
	 */
	int weight;

	public EData(char start, char end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
