package com.fbi.cloud.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 * @author cy
 * @version DateUtil.java, v 0.1 2020年10月13日 08:38 cy Exp $
 */
public class DateUtil {

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentTime() {
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // new Date()为获取当前系统时间
        return df.format(new Date());
    }

}
