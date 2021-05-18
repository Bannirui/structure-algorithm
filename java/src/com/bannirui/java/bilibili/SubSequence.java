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
        String str = "abc";
        List<String> res = new ArrayList<>(0);
        solution01(str, 0, "", res);
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
}
