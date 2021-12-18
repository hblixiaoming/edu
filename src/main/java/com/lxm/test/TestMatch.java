package com.lxm.test;

import java.util.Arrays;
import java.util.List;

public class TestMatch {
    private static final List<String> TITLE_PREFIX =
            Arrays.asList("bapak", "pak", "nyonya", "tuan", "nona", "ir", "drs", "dr",  "prof", "datuk", "hj", "haji", "hajji", "hajah", "hajjah");

    /**
     * 替换不能以title开头的字符串
     *
     * @param source 原始字符串
     * @return 替换结果
     */
    public static String titlePrefixReplace(String source) {
        String rtn = source;
        for (String prefix : TITLE_PREFIX) {
            //rtn = rtn.replaceFirst("((?i)" + prefix + ")", "");
//            if (source.startsWith(prefix.toLowerCase())) {
//                rtn = rtn.replaceFirst(prefix.toLowerCase(), "");
//            }
//            if (source.startsWith(prefix.toUpperCase())) {
//                rtn = rtn.replaceFirst(prefix.toUpperCase(), "");
//            }
            rtn = rtn.replaceFirst("^((?i)" + prefix + ")", "");
        }
        return rtn;
    }


    public static void main(String[] args){
//        String str1 = "DrsTT Datuk huidu ONE";
//        System.out.println(titlePrefixReplace(str1));
//        String str2= "xtuan Datuk huidu ONE";
//        System.out.println(titlePrefixReplace(str2));
//        String str3="Hajjahpak addd";
//        System.out.println(titlePrefixReplace(str3));
        String str3="DTT Datuk huidu ONE";
        System.out.println(titlePrefixReplace(str3));
    }



}
