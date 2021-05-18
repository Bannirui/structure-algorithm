package com.bannirui.java.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *@author dingrui
 *@date 2020-12-08
 *@description 图
 * 1，存储顶点
 * 2，矩阵，二维数组存储图对应的邻接矩阵
 */
public class Graph {

	public static void main(String[] args) {
		// 节点个数
		int n = 5;
		// 节点
		String[] vertexValueArray = {"A", "B", "C", "D", "E"};

		Graph graph = new Graph(n);
		// 循环添加顶点
		for (String vertex : vertexValueArray) {
			graph.insertVertex(vertex);
		}

		/**
		 * 添加边
		 * A-B A-C
		 * B-C B-D B-E
		 */
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);

		// 打印
		graph.showGraph();

		// 深度遍历
		System.out.println("dfs 深度优先遍历");
		graph.dfs();

		System.out.println();
		Arrays.fill(graph.isVisited, false);

		// 广度优先
		System.out.println("dfs 广度优先遍历");
		graph.bfs();

		System.out.println();
	}

	/**
	 * 存储图的顶点的集合
	 */
	private List<String> vertexList;

	/**
	 * 存储图对应的邻接矩阵
	 */
	private int[][] edges;

	/**
	 * 图的边的数目
	 */
	private int numOfEdges;

	/**
	 * 定义一个数组 标记某个节点是否被访问过 true表示节点被访问过 false表示姐弟啊你没有被访问过
	 */
	private boolean[] isVisited;

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param n
	 * @return
	 * @description 构造函数 初始化矩阵和顶点列表
	 */
	public Graph(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<>(n);
		numOfEdges = 0;
		isVisited = new boolean[n];
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param vertex
	 * @return
	 * @description 添加节点
	 */
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param v1 第一个顶点的下标
	 * @param v2 第二个顶点的下标
	 * @param weight 权值 比如两个顶点之间构成边 1表示两个顶点构边 0表示两个顶点之间不构成边
	 * @return
	 * @description 添加边
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @return
	 * @description 获取图的节点的个数
	 */
	public int getNumOfVertex() {
		return vertexList.size();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @return
	 * @description 获取图的边的数目
	 */
	public int getNumOfEdges() {
		return numOfEdges;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param index
	 * @return
	 * @description 根据索引获取节点对应的值
	 */
	public String getValueByIndex(int index) {
		return vertexList.get(index);
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param v1 节点1
	 * @param v2 节点2
	 * @return
	 * @description 图中两个节点之间的权值
	 */
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @return
	 * @description 打印图
	 */
	public void showGraph() {
		for (int[] edge : edges) {
			System.out.println(Arrays.toString(edge));
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param index 当前节点下标
	 * @return
	 * @description 根据当前节点找到第一个邻接节点的下标 如果没有邻接节点 返回-1
	 */
	private int getFirstNeighborIndex(int index) {
		for (int i = index; i < vertexList.size(); i++) {
			if (edges[index][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param v1 第一个节点下标
	 * @param v2 第二个节点下标
	 * @return 返回找到的邻接节点的下标
	 * @description 根据前一个邻接节点下标获取下一个邻接节点的下标 如果没有则返回-1
	 * 比如v1这个节点的邻接节点有v2 v3 v4，如果入参为v1 v2也就是说找v1在v2之后的邻接节点的下标 也就是v3
	 *
	 */
	private int getNextNeighborIndex(int v1, int v2) {
		for (int i = v2 + 1; i < vertexList.size(); i++) {
			if (edges[v1][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @param isVisited
	 * @param index
	 * @return
	 * @description dfs算法 深度优先遍历
	 */
	private void dfs(boolean[] isVisited, int index) {
		// 输出当前节点
		System.out.print(getValueByIndex(index) + "->");
		// 当前节点设置已经访问过
		isVisited[index] = true;
		// 当前节点第一个邻接节点的下标
		int w = getFirstNeighborIndex(index);
		// firstNeighborIndex不为-1说明找到了第一个邻接节点
		while (w != -1) {
			if (!isVisited[w]) {
				// 没有被访问过
				dfs(isVisited, w);
			} else {
				// 已经被访问过
				w = getNextNeighborIndex(index, w);
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/8
	 * @return
	 * @description 遍历所有节点进行dfs
	 */
	private void dfs() {
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/9
	 * @param isVisited 图的节点是否被访问过
	 * @param index 第几个节点 节点数组的下标
	 * @return
	 * @description 对一个节点进行广度优先遍历
	 */
	private void bfs(boolean[] isVisited, int index) {
		// 表示队列的头节点对应的下标
		int u;
		// 邻接节点w
		int w;
		// 队列 记录节点访问的顺序
		LinkedList queue = new LinkedList();

		// 访问节点 输出节点信息
		System.out.print(getValueByIndex(index) + "->");
		// 标记已经访问过这个节点
		isVisited[index] = true;
		// 将节点放到队列
		queue.addLast(index);

		while (!queue.isEmpty()) {
			// 取出队列的头节点下标
			u = (Integer) queue.removeFirst();
			// 取得第一个邻接节点的下标
			w = getFirstNeighborIndex(u);
			while (w != -1) {
				// 判断w是否已经被访问过
				if (!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "->");
					// 标记这个节点已经被访问过
					isVisited[w] = true;
					// 加入队列
					queue.addLast(w);
				}
				// 如果w已经被访问过 那就找u在w后面的邻接节点
				w = getNextNeighborIndex(u, w);
			}
		}
	}

	/**
	 * @author dingrui
	 * @date 2020/12/9  
	 * @return
	 * @description 对图的所有节点进行广度优先遍历
	 */
	private void bfs() {
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
}
