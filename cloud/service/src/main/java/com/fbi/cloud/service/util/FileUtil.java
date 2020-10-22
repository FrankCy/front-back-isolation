package com.fbi.cloud.service.util;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 *
 *
 * @author cy
 * @version FileUtil.java, v 0.1 2020年09月23日 17:12 cy Exp $
 */
public class FileUtil {

    /**
     * 文件符号
     */
    private static final String FILE_DECIMAL_POINT = ".";

    /**
     * 获取完整名称
     * @param fileName
     * @return
     */
    public static String getFileFullName(String fileName) {
        if(StringUtils.isNotEmpty(fileName)) {
            if (fileName.contains(FILE_DECIMAL_POINT)) {
                String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                String key = getUuid();
                StringBuffer keStrBuffer = new StringBuffer();
                keStrBuffer.append(key).append(".").append(fileExtension);
                return keStrBuffer.toString();
            } else {
                return getUuid();
            }
        } else {
            return getUuid();
        }
    }

    /**
     * 文件转换为数组
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] fileToByteArr(File file) throws IOException {
        byte[] buffer = null;
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[4096];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        buffer = bos.toByteArray();
        return buffer;
    }

    /**
     * inputStream转换成byte[]
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] inputStreamToByteArr(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int num = inputStream.read(buffer);
            while (num != -1) {
                baos.write(buffer, 0, num);
                num = inputStream.read(buffer);
            }
            baos.flush();
            return baos.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 获取uuid
     * @return
     */
    private static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

}
