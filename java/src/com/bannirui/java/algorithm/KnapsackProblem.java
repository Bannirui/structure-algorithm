package com.bannirui.java.algorithm;

/**
 *@author dingrui
 *@date 2020-12-09
 *@description 01背包问题
 */
public class KnapsackProblem {
	public static void main(String[] args) {
		// 物品重量
		int[] w = {1, 4, 3};
		// 物品的价格
		int[] val = {1500, 3000, 2000};
		// 背包的容量
		int m = 4;
		// 物品的个数
		int n = val.length;

		// 创建二维数组 v[i][j]表示前i个物品能够装入容量为j的背包中的最大价值
		int[][] v = new int[n + 1][m + 1];

		// 记录放入背包中商品的情况
		int[][] path = new int[n + 1][m + 1];

		// 初始化首行首列
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		for (int j = 0; j < v[0].length; j++) {
			v[0][j] = 0;
		}

		// 跳过首行首列 处理其他 动态规划处理
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				if (w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					if (v[i - 1][j] > val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = v[i - 1][j];
					} else {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					}
				}
			}
		}

		// 输出推导的列表
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

		// 装入包的方案
		// path行最大下标
		int i = path.length - 1;
		// path列最大下标
		int j = path[0].length - 1;
		while (i > 0 && j > 0) {
			if (path[i][j] == 1) {
				System.out.printf("第%d个商品放入到背包中\n", i);
				j -= w[i - 1];
			}
			i--;
		}

		System.out.println();
	}

}
