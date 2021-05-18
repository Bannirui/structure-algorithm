package com.bannirui.java.algorithm;

/**
 *@author dingrui
 *@date 2020-12-09
 *@description 汉诺塔问题 分治算法解决
 */
public class HanoiTower {
	public static void main(String[] args) {
		int counts = 3;
		String a = "A";
		String b = "B";
		String c = "C";

		new HanoiTower().hanoiTower(counts, a, b, c);
	}

	private void hanoiTower(int counts, String a, String b, String c) {
		if (counts == 1) {
			// 只有一个圆盘需要移动 直接从a->c
			System.out.printf("移动圆盘 %s到%s\n", a, c);
		} else {
			//  多于1个盘的场景都可以拆分为1个圆盘+n-1个圆盘
			// 先把上面n-1个圆盘从a移动到b
			hanoiTower(counts - 1, a, c, b);
			// 再把最下面的1个圆盘从a移动到c
			System.out.printf("移动圆盘 %s到%s\n", a, c);
			// 最后再把b上面的n-1个圆盘移动到c
			hanoiTower(counts - 1, b, a, c);
		}
	}
}
