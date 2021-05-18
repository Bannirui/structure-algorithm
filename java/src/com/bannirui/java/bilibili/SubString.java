package com.bannirui.java.bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 *@author dingrui
 *@date 2021-05-18
 *@description 字符串子串
 */
public class SubString {

    public static void main(String[] args) {
        String str = "abcd";
        List<String> res = solution01(str);
        System.out.println();
    }

    public static List<String> solution01(String str) {
        List<String> res = new ArrayList<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String substring = str.substring(i, j);
                res.add(substring);
            }
        }
        return res;
    }
}
