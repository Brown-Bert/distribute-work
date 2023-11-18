package org.example.utils;

import java.util.ArrayList;
import java.util.List;

public class ListAndString {
    public static String ListToString(List<String> list){
        String str = "";
        for (String s : list) {
            str += s + " ";
        }
        return str;
    }
    public static List<String> StringToList(String str){
        List<String> list = new ArrayList<>();
        String[] s = str.split(" ");
        for (String string : s) {
            list.add(string);
        }
        return list;
    }
}
