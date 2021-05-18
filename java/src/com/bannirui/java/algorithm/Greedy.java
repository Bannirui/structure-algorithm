package com.bannirui.java.algorithm;

import java.util.*;

/**
 *@author dingrui
 *@date 2020-12-10
 *@description 贪心算法
 */
public class Greedy {

	public static void main(String[] args) {
		new Greedy().greedy();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/10
	 * @return
	 * @description
	 */
	private void greedy() {
		Map<String, Set<String>> broadcasts = new HashMap<>();

		// 电台-电台能覆盖的地区
		Set<String> hashSet1 = new HashSet<>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");

		Set<String> hashSet2 = new HashSet<>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");


		Set<String> hashSet3 = new HashSet<>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");


		Set<String> hashSet4 = new HashSet<>();
		hashSet4.add("上海");
		hashSet4.add("天津");

		Set<String> hashSet5 = new HashSet<>();
		hashSet5.add("杭州");
		hashSet5.add("大连");

		broadcasts.put("k1", hashSet1);
		broadcasts.put("k2", hashSet2);
		broadcasts.put("k3", hashSet3);
		broadcasts.put("k4", hashSet4);
		broadcasts.put("k5", hashSet5);

		// 所有地区
		Set<String> allAreas = new HashSet<>();
		for (String k : broadcasts.keySet()) {
			allAreas.addAll(broadcasts.get(k));
		}

		// 存放选择的电台
		List<String> selectors = new ArrayList<>();

		// 临时集合 存放遍历过程中 电台能够覆盖地区and所有地区 的交集
		Set<String> tmp = new HashSet<>();
		// 被选中的电台 每次遍历选择能够覆盖地区最多的电台
		String maxK = null;

		while (allAreas.size() != 0) {
			maxK = null;
			// 遍历电台
			for (String k : broadcasts.keySet()) {
				tmp.clear();
				// 每个电台能够覆盖的地区
				Set<String> areas = broadcasts.get(k);
				tmp.addAll(areas);
				// tmp跟所有地区allAreas的交集 重新赋值给tmp
				tmp.retainAll(allAreas);

				if (tmp.size() > 0 && (maxK == null || tmp.size() > broadcasts.get(maxK).size())) {
					maxK = k;
				}
			}

			if (maxK != null) {
				// 被选中能够覆盖地区最多的电台
				selectors.add(maxK);
				allAreas.removeAll(broadcasts.get(maxK));
			}
		}
	}
}
