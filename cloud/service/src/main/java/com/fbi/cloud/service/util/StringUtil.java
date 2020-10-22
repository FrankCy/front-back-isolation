package com.fbi.cloud.service.util;

/**
 *
 *
 * @author cy
 * @version StringUtil.java, v 0.1 2020年10月12日 17:24 cy Exp $
 */
public class StringUtil {
    /**
     * 将原字符串str的首字母大写处理
     * @param str 原字符串
     * @return 首字母大写的字符串
     */
    public static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
