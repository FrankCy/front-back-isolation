package com.fbi.cloud.service.util;

/**
 *
 *
 * @author cy
 * @version ByteUtil.java, v 0.1 2020年09月21日 09:24 cy Exp $
 */
public class ByteUtil {

    /**
     * byte转换
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

}
