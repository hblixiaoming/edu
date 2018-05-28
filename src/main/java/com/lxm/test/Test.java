package com.lxm.test;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Test {

    public static final NumberFormat numberFormat = NumberFormat.getPercentInstance(Locale.CHINA);

    {
        numberFormat.setMinimumFractionDigits(4);
    }
//    public static void main(String[] args){
//        int count = 0;
//        retry:
//        for (; ; ) {
//            count = 0;
//            for (; ; ) {
//                count++;
//                System.out.println("count==" + count);
//                if (count % 5 == 0) {
//                    continue retry;
//                }
//            }
//        }
//    }

    public static void main(String[] args)throws Exception{
//        BigDecimal obj = new BigDecimal(0.006);
//        try {
//            DecimalFormat format = new DecimalFormat("##.##%");
//            System.out.println(format.format(0.0047));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        String a = "李小";
        String b = URLEncoder.encode(a,"UTF-8");
        System.out.println(URLEncoder.encode(a,"UTF-8"));
        System.out.println(URLDecoder.decode(b,"UTF-8"));
    }
}
