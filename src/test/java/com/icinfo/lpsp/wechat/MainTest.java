package com.icinfo.lpsp.wechat;

import java.util.Arrays;

/**
 * Created by yushunwei on 2016/8/7.
 */
public class MainTest {
    public static void main(String[] args) {
        test("ace","bdf","135","246");
    }

    private static void test(String... arr){
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for(String p : arr){
            sb.append(p);
        }
        System.out.println(sb.toString());
    }
}
