package com.bannirui.java.algorithm;

/**
 *@author dingrui
 *@date 2020-12-10
 *@description KMP字符匹配
 */
public class KMP {

	public static void main(String[] args) {
		String parent = "你好 你好 你好呀banirui";
		String sub = "你好呀banirui";

		KMP kmp = new KMP();
		// 暴力匹配
		int i = kmp.violenceMatch(parent, sub);

		// kmp匹配
		int[] next = kmp.kmpNext(sub);
		int j = kmp.kmpSearch(parent, sub, next);

		System.out.println();
	}

	/**
	 * @author dingrui
	 * @date 2020/12/10
	 * @param parent 源字符串
	 * @param sub 子字符串
	 * @param next sub子字符串的部分匹配表
	 * @return 如果在源字符串中匹配到子字符串 返回第一次匹配到的位置 如果没有匹配到 返回-1
	 * @description kmp匹配
	 */
	private int kmpSearch(String parent, String sub, int[] next) {
		for (int parentIndex = 0, subIndex = 0; parentIndex < parent.length(); parentIndex++) {
			while (subIndex > 0 && parent.charAt(parentIndex) != sub.charAt(subIndex)) {
				subIndex = next[subIndex - 1];
			}

			if (parent.charAt(parentIndex) == sub.charAt(subIndex)) {
				subIndex++;
			}

			if (subIndex == sub.length()) {
				return parentIndex - subIndex + 1;
			}
		}
		return -1;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/10
	 * @param dest 子字符串
	 * @return
	 * @description 构建子串的next数组
	 */
	private int[] kmpNext(String dest) {
		// 部分匹配值 前缀 后缀 公共字符串最大长度
		int[] next = new int[dest.length()];
		// 如果字符串只有一个字符 没有前缀 也没有后缀 部分匹配值就是0
		next[0] = 0;

		for (int i = 1, j = 0; i < dest.length(); i++) {
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j - 1];
			}

			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

	/**
	 * @author dingrui
	 * @date 2020/12/10
	 * @param parent 父字符串
	 * @param sub 子字符串
	 * @return
	 * @description 字符串暴力匹配 如果匹配成功 返回父字符串中匹配成功的起始下标(从0开始) 如果没有匹配返回-1
	 */
	private int violenceMatch(String parent, String sub) {
		char[] parentArr = parent.toCharArray();
		char[] subArr = sub.toCharArray();

		int parentLength = parentArr.length;
		int subLength = subArr.length;

		int parentIndex = 0;
		int subindex = 0;

		while (parentIndex < parentLength && subindex < subLength) {
			if (parentArr[parentIndex] == subArr[subindex]) {
				parentIndex++;
				subindex++;
			} else {
				parentIndex = parentIndex - subindex + 1;
				subindex = 0;
			}
		}

		if (subindex == subLength) {
			return parentIndex - subindex;
		} else {
			return -1;
		}
	}
}
