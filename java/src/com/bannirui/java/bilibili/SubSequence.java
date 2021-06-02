package com.bannirui.java.bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 *@author dingrui
 *@date 2021-05-18
 *@description 字符串子序列
 */
public class SubSequence {

    public static void main(String[] args) {
        String str1 = "abc";
        List<String> res1 = new ArrayList<>(0);
        solution01(str1, 0, "", res1);
        String str2 = "abc";
        List<String> res2 = new ArrayList<>(0);
        solution02(str2.toCharArray(), 0, res2);
        System.out.println();
    }

    /**
     * @author dingrui
     * @date 2021/5/18
     * @param str
     * @param index
     * @param path
     * @param res
     * @return
     * @description 字符串的全部子序列
     */
    public static void solution01(String str, int index, String path, List<String> res) {
        if (index == str.length()) {
            // 字符串结尾
            res.add(path);
            return;
        }
        // 拼接上当前字符
        solution01(str, index + 1, path + str.charAt(index), res);
        // 不拼接上当前字符
        solution01(str, index + 1, path, res);
    }

    public static void solution02(char[] str, int index, List<String> res) {
        if (index == str.length) {
            // 字符串结尾
            res.add(String.valueOf(str));
            return;
        }
        for (int j = index; j < str.length; j++) {
            swap(str, index, j);
            solution02(str, index + 1, res);
            swap(str, j, index);
        }
    }

    /**
     * @author dingrui
     * @date 2021/6/1
     * @param str
     * @param index
     * @param res
     * @return
     * @description 分支限界
     */
    public static void solution03(char[] str, int index, List<String> res) {
        if (index == str.length) {
            // 字符串结尾
            res.add(String.valueOf(str));
            return;
        }
        // a-z字符数组 记录是否已经使用过
        boolean[] visit = new boolean[26];
        for (int j = index; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, index, j);
                solution02(str, index + 1, res);
                swap(str, j, index);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
